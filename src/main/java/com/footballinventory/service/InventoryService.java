package com.footballinventory.service;

import com.footballinventory.model.Jersey;

import java.util.Collection;

public interface InventoryService {

    void createJersey(Jersey jersey);
    void updateJersey(String id, Jersey jersey);
    void deleteJersey(String id);
    Collection<Jersey> getProducts();
}
