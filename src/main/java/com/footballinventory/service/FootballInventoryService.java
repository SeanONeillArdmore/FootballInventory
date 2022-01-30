package com.footballinventory.service;

import com.footballinventory.model.Jersey;

import java.util.List;

public interface FootballInventoryService {

    Jersey addJersey(Jersey jersey);
    Jersey updateJersey(String id, Jersey jersey);
    void deleteJersey(String id);
    Jersey findJerseyById(String id);
    List<Jersey> findAllJerseys();
}
