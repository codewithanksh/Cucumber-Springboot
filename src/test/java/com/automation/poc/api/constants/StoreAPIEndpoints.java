package com.automation.poc.api.constants;

public class StoreAPIEndpoints {

    public static final String BASE_URL ="https://store-search-sit.int-np.ae-gcp.io";
    public static final String GET_STORE = "/v1/aeostoredata/{storeId}";
    public static final String ADD_STORE ="/v1/aeostoredata/addstore";
    public static final String DELETE_STORE = "/v1/aeostoredata/{storeId}";
    public static final String MODIFY_STORE = "/v1/aeostoredata/modifystore";
    public static final String NEAR_BY_STORE_BY_ZIP = "/v1/aeostoredata/getnearbystores?country=US&limit={limit}&location={zipCode}&radius=50";

}
