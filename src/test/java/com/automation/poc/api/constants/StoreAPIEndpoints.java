package com.automation.poc.api.constants;

public class StoreAPIEndpoints {

    public static final String BASE_URL ="<URL>";
    public static final String GET_STORE = "/v1/<DataStore>/{storeId}";
    public static final String ADD_STORE ="/v1/<DataStore>/addstore";
    public static final String DELETE_STORE = "/v1/<DataStore>/{storeId}";
    public static final String MODIFY_STORE = "/v1/<DataStore>/modifystore";
    public static final String NEAR_BY_STORE_BY_ZIP = "/v1/<DataStore>/getnearbystores?country=US&limit={limit}&location={zipCode}&radius=50";

}
