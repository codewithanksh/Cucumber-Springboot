package com.automation.poc.api.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

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
    public String state;
    public double latitude;
    public double longitude;
    public List<Double> coordinates;
    public String displayAddress;
    public double bopisCutOffTime;
    public String storeOpenDate;
    public String storeCloseDate;
    public long timestamp;
    public List<ExceptionHour> exceptionHours;
    public List<WeekHour> weekHours;
    public boolean curbSideEnabled;
    public boolean lockerEnabled;
    public boolean sddEnabled;
    public boolean geoFenceEnabled;
    public String parkingInformation;
    public String storeId;
}
