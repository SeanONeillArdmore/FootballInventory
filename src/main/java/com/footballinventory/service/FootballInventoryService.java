package com.footballinventory.service;

import com.footballinventory.model.JerseyDTO;

import java.util.List;

public interface FootballInventoryService {

    JerseyDTO addJersey(JerseyDTO jerseyDTO);
    JerseyDTO updateJersey(String id, JerseyDTO jerseyDTO);
    void deleteJersey(String id);
    JerseyDTO findJerseyById(String id);
    List<JerseyDTO> findAllJerseys();
    List<JerseyDTO> findJerseysByYear(String team, Integer year);
}
