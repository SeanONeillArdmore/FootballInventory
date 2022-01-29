package com.footballinventory.service;

import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.JerseyEntity;
import com.footballinventory.model.Jersey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InventoryServiceImpl implements InventoryService {

    private JerseyRepository jerseyRepository;

    @Autowired
    public InventoryServiceImpl(JerseyRepository jerseyRepository) {
        this.jerseyRepository = jerseyRepository;
    }

    @Override
    public Jersey addJersey(Jersey jersey) {
        JerseyEntity jerseyEntity = new JerseyEntity();
        jerseyEntity.setColor(jersey.getColor());
        jerseyEntity.setSize(jersey.getSize());
        jerseyEntity.setTeam(jersey.getTeam());
        JerseyEntity created = jerseyRepository.save(jerseyEntity);
        jersey.setJerseyId(created.getId());
        return jersey;
    }

    @Override
    public void updateJersey(String id, Jersey jersey) {

    }

    @Override
    public void deleteJersey(String id) {

    }

    @Override
    public Jersey findJerseyByTeam(String id) {
        return null;
    }

    @Override
    public Collection<Jersey> findAllJerseys() {
        return null;
    }
}
