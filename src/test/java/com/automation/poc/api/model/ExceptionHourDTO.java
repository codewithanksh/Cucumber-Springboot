package com.automation.poc.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.util.List;

@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionHourDTO {
    public String date;
    public boolean isClosed;
    public List<ShiftsDTO> shifts;

    @Tolerate
    public ExceptionHourDTO(){}
}
