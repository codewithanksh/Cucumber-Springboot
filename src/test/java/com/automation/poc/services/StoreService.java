package com.automation.poc.services;

import com.automation.poc.api.beans.Store;
import com.automation.poc.api.model.StoreDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface StoreService {

    void addStore(StoreDTO storeDTO);

    Integer deleteStore(Integer storeId);

    Store getStore(Integer storeId);

    Integer getStoreStatus(Integer storeId);

    Integer modifyStore(StoreDTO storeDTO);


}
