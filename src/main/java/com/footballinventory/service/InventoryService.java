package com.footballinventory.service;

import com.footballinventory.model.Jersey;

import java.util.Collection;

public interface InventoryService {

    Jersey addJersey(Jersey jersey);
    void updateJersey(String id, Jersey jersey);
    void deleteJersey(String id);
    Jersey findJerseyByTeam(String id);
    Collection<Jersey> findAllJerseys();
}
