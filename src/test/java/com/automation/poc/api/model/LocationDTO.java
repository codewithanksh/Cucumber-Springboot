package com.automation.poc.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Tolerate;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDTO {

    public String zip;
    public String hours;
    public String locationName;
    public String addressLine1;
    public String addressLine2;
    public String city;
    public boolean bopisEnabled;
    public String timezone;
    public String language;
    public String phone;
    public String countryCode;
    public String storeId;
    public String state;
    public double latitude;
    public double longitude;
    public List<Double> coordinates;
    public String displayAddress;
    public double bopisCutOffTime;
    public String storeOpenDate;
    public String storeCloseDate;
    public long timestamp;
    public List<ExceptionHourDTO> exceptionHours;
    public List<WeekHourDTO> weekHours;
    public boolean curbSideEnabled;
    public boolean lockerEnabled;
    public boolean sddEnabled;
    public boolean geoFenceEnabled;
    public String parkingInformation;

    @Tolerate
    public LocationDTO() {

    }
}
