package com.footballinventory.service;

import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.JerseyEntity;
import com.footballinventory.model.Jersey;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FootballFootballInventoryServiceImpl implements FootballInventoryService {

    private final JerseyRepository jerseyRepository;

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
    public Jersey updateJersey(String id, Jersey jersey) {
        JerseyEntity jerseyEntity = jerseyRepository.getOne(id);
        jerseyEntity.setId(jersey.getJerseyId());
        jerseyEntity.setColor(jersey.getColor());
        jerseyEntity.setTeam(jersey.getTeam());
        jerseyEntity.setSize(jersey.getJerseyId());
        jerseyRepository.save(jerseyEntity);
        return jersey;
    }

    @Override
    public void deleteJersey(String id) {
        JerseyEntity jerseyEntity = jerseyRepository.getOne(id);
        jerseyRepository.deleteById(id);
    }

    @Override
    public List<Jersey> findAllJerseys() {
        List<JerseyEntity> jerseyEntities = jerseyRepository.findAll();
        List<Jersey> jerseys = jerseyEntities.stream().map(
                i -> new Jersey(i.getId(), i.getTeam(), i.getSize(), i.getColor())
        ).collect(Collectors.toList());
        return jerseys;
    }

    @Override
    public List<Jersey> findJerseyByTeam(String teamFilter) {
        List<JerseyEntity> jerseyEntities = jerseyRepository.findByTeam(teamFilter);
        List<Jersey> jerseys = jerseyEntities.stream().map(
                i -> new Jersey(i.getId(), i.getTeam(), i.getSize(), i.getColor())
        ).collect(Collectors.toList());
        return jerseys;
    }
}
