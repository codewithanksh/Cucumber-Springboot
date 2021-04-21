package com.automation.poc.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)

public class StoreDTO {
    public String storeId;
    public Boolean isClosed;
    public LocationDTO location;

    @Tolerate
    public StoreDTO(){

    }
}
