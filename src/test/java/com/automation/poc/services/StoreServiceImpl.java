package com.automation.poc.services;

import com.automation.poc.api.beans.Store;
import com.automation.poc.api.constants.StoreAPIEndpoints;
import com.automation.poc.api.model.StoreDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Service;

import static io.restassured.RestAssured.given;

@Service
public class StoreServiceImpl implements StoreService {


    @Override
    public Store getStore(Integer storeId) {
        setupBaseURI();
        return given().relaxedHTTPSValidation().contentType(ContentType.JSON).pathParam("storeId", storeId)
                .when().get(StoreAPIEndpoints.GET_STORE)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getObject("data", Store.class);
    }

    @Override
    public Integer getStoreStatus(Integer storeId) {
        setupBaseURI();
        return given().log().all().relaxedHTTPSValidation().contentType(ContentType.JSON).pathParam("storeId", storeId)
                .when().get(StoreAPIEndpoints.GET_STORE)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK)
                .extract().response().statusCode();
    }

    @Override
    public void addStore(StoreDTO storeDTO) {
        setupBaseURI();
        given().relaxedHTTPSValidation().contentType(ContentType.JSON).relaxedHTTPSValidation()
                .body(storeDTO)
                .when().post(StoreAPIEndpoints.ADD_STORE)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK)
                .extract().response().prettyPrint();
    }

    @Override
    public Integer modifyStore(StoreDTO storeDTO) {
        setupBaseURI();
        return given().relaxedHTTPSValidation().contentType(ContentType.JSON).relaxedHTTPSValidation()
                .body(storeDTO)
                .when().put(StoreAPIEndpoints.MODIFY_STORE)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK)
                .extract().statusCode();
    }

    @Override
    public Integer deleteStore(Integer storeId) {
        setupBaseURI();
        return given().relaxedHTTPSValidation().contentType(ContentType.JSON).pathParam("storeId", storeId)
                .when().delete(StoreAPIEndpoints.DELETE_STORE)
                .then().log().ifValidationFails().statusCode(HttpStatus.SC_OK)
                .extract().statusCode();
    }
    
    private static void setupBaseURI(){
        RestAssured.baseURI = StoreAPIEndpoints.BASE_URL;
    }
}
