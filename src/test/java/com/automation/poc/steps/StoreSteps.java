package com.automation.poc.steps;

import com.automation.poc.api.beans.Shifts;
import com.automation.poc.services.StoreService;
import com.automation.poc.api.model.*;
import com.automation.poc.api.utils.CustomBeanUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class StoreSteps {

    private final Logger log = LoggerFactory.getLogger(StoreSteps.class);

    @Autowired
    private StoreService storeService;

    static StoreDTO storeDTO = new StoreDTO();

    static LocationDTO locationDTO = new LocationDTO();

    @Given("User verifies no store with id {int} exists")
    public void user_verifies_no_store_with_id_exists(Integer storeId) {
        //Todo : Verify if a store with given Id exists, If yes then fire a DELETE CALL to delete it
//        if (storeService.getStoreStatus(storeId) == 200) // Based on result, choose to fire or not fire delete call
//            storeService.deleteStore(storeId);
    }

    @And("User provides following address details for store {int}")
    public void user_provides_following_address_details_for_store(Integer storeId, List<Map<String, String>> locationMapList) throws Exception {

        if (locationMapList.size() > 1)
            throw new Exception("More than one address per store is not allowed");

        Map<String, String> locationMap = locationMapList.get(0);
        ObjectMapper mapper = new ObjectMapper();
        locationDTO.setStoreId(String.valueOf(storeId));
        locationDTO = mapper.convertValue(locationMap, LocationDTO.class);
        storeDTO.setLocation(locationDTO);

        System.out.println("\nAddress Details Added:\n");
        System.out.println(mapper.writeValueAsString(storeDTO));

    }

    @And("following are the geographical location details for store {int}")
    public void following_are_the_geographical_location_details_for_store(Integer storeId, List<Map<String, String>> geoLocationMapList) throws Exception {

        if (geoLocationMapList.size() > 1)
            throw new Exception("More than one Geolocation per store is not allowed");

        Map<String, String> locationMap = geoLocationMapList.get(0);
        ObjectMapper mapper = new ObjectMapper();
        LocationDTO templocationDTO = mapper.convertValue(locationMap, LocationDTO.class);
        templocationDTO.setCoordinates(new ArrayList<Double>(Arrays.asList(templocationDTO.getLongitude(), templocationDTO.getLatitude())));
        CustomBeanUtils.copyPropertiesIgnoreNull(templocationDTO, locationDTO);
        storeDTO.setLocation(locationDTO);

        System.out.println("\nGeographic Location Details Added:\n");
        System.out.println(mapper.writeValueAsString(storeDTO));

    }

    @And("following are the shift details for store {int}")
    public void following_are_the_shift_details_for_store(Integer storeId, List<Map<String, String>> weekHourList) throws Exception {

        if (weekHourList.size() > 7)
            throw new Exception("More than seven weekly shifts per store is not allowed");

        List<WeekHourDTO> weekHourDTOListFinal = weekHourList.stream().map(weekHourRecord ->
                WeekHourDTO.builder().day(weekHourRecord.get("Day")).isClosed(Boolean.parseBoolean(weekHourRecord.get("isClosed")))
                        .shifts(new ArrayList<>(Arrays.asList(ShiftsDTO.builder().from(weekHourRecord.get("from")).till(weekHourRecord.get("till")).build())))
                        .build()).collect(Collectors.toList());


        locationDTO.setWeekHours(weekHourDTOListFinal);
        storeDTO.setLocation(locationDTO);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("\nWeekhours Details Added:\n");
        System.out.println(mapper.writeValueAsString(storeDTO));


    }

    @And("following are the exceptional hours details for store {int}")
    public void following_are_the_exceptional_hours_details_for_store(Integer storeId, List<Map<String, String>> exceptionalHourList) throws JsonProcessingException {

        List<ExceptionHourDTO> exceptionslHourDTOListFinal = exceptionalHourList.stream().map(exceptionalHourRecord ->
                ExceptionHourDTO.builder().date(exceptionalHourRecord.get("Date")).isClosed(Boolean.parseBoolean(exceptionalHourRecord.get("isClosed")))
                        .shifts(new ArrayList<>(Arrays.asList(ShiftsDTO.builder().from(exceptionalHourRecord.get("from")).till(exceptionalHourRecord.get("till")).build())))
                        .build()).collect(Collectors.toList());

        locationDTO.setExceptionHours(exceptionslHourDTOListFinal);
        storeDTO.setLocation(locationDTO);

        ObjectMapper mapper = new ObjectMapper();
        System.out.println("\nExceptional hours Details Added:\n");
        System.out.println(mapper.writeValueAsString(storeDTO));
    }

    @And("following are the other details for store {int}")
    public void following_are_the_other_details_for_store(Integer storeId, List<Map<String, String>> otherDetailsMapList) throws Exception {

        if (otherDetailsMapList.size() > 1)
            throw new Exception("More than one Otherdetails per store is not allowed");

        Map<String, String> otherDetailsMap = otherDetailsMapList.get(0);
        ObjectMapper mapper = new ObjectMapper();
        LocationDTO templocationDTO = mapper.convertValue(otherDetailsMap, LocationDTO.class);
        CustomBeanUtils.copyPropertiesIgnoreNull(templocationDTO, locationDTO);
        storeDTO.setLocation(locationDTO);

        System.out.println("\nOther Details Map Details Added:\n");
        System.out.println(mapper.writeValueAsString(storeDTO));
    }

    @Then("Store should be created successfully with {int} and closed status as {string}")
    public void store_should_be_created_successfully(Integer storeId, String isClosed) throws JsonProcessingException {
        storeDTO.setStoreId(String.valueOf(storeId));
        storeDTO.setIsClosed(Boolean.parseBoolean(isClosed));
        System.out.println("\nFinal Store Request Payload:\n");
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(storeDTO));
        storeService.addStore(storeDTO);
        //Todo : Verify if a store with given Id is created or not
    }
}
