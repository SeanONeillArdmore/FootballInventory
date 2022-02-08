package com.footballinventory.service;

import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.Jersey;
import com.footballinventory.exception.JerseyNotFoundException;
import com.footballinventory.model.JerseyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FootballFootballInventoryServiceImpl implements FootballInventoryService {

    private final JerseyRepository jerseyRepository;

    @Override
    public JerseyDTO addJersey(JerseyDTO jerseyDTO) {
        Jersey jerseyEntity = new Jersey();
        jerseyEntity.setColor(jerseyDTO.getColor());
        jerseyEntity.setSize(jerseyDTO.getSize());
        jerseyEntity.setTeam(jerseyDTO.getTeam());
        jerseyEntity.setYear(jerseyDTO.getYear());
        Jersey created = jerseyRepository.save(jerseyEntity);
        jerseyDTO.setJerseyId(created.getId());
        return jerseyDTO;
    }

    @Override
    public JerseyDTO updateJersey(String id, JerseyDTO jerseyDTO) {
        findJerseyById(id);
        Jersey jerseyEntity = new Jersey();
        jerseyEntity.setId(id);
        jerseyEntity.setColor(jerseyDTO.getColor());
        jerseyEntity.setTeam(jerseyDTO.getTeam());
        jerseyEntity.setSize(jerseyDTO.getSize());
        jerseyEntity.setYear(jerseyDTO.getYear());
        jerseyRepository.save(jerseyEntity);
        return jerseyDTO;
    }

    @Override
    public void deleteJersey(String id) {
        findJerseyById(id);
        jerseyRepository.deleteById(id);
    }

    @Override
    public List<JerseyDTO> findAllJerseys() {
        List<Jersey> jerseyEntities = jerseyRepository.findAll();
        List<JerseyDTO> jerseyDTOS = jerseyEntities.stream().map(
                i -> new JerseyDTO(i.getId(), i.getTeam(), i.getSize(), i.getColor(), i.getYear())
        ).collect(Collectors.toList());
        return jerseyDTOS;
    }

    @Override
    public JerseyDTO findJerseyById(String id) {
        Optional<Jersey> optional = jerseyRepository.findById(id);
        if (optional.isEmpty()){
            throw  new JerseyNotFoundException("Jersey Not found : " + id);
        }
        Jersey jersey = optional.get();
        return new JerseyDTO(jersey.getId(), jersey.getTeam(), jersey.getSize(), jersey.getColor(), jersey.getYear());
    }

    @Override
    public List<JerseyDTO> findJerseysByYear(String team, Integer year) {
        List<Jersey> jerseyEntities = jerseyRepository.findByTeamStartingWithAndYear(team, year);
        List<JerseyDTO> jerseyDTOS = jerseyEntities.stream().map(
                i -> new JerseyDTO(i.getId(), i.getTeam(), i.getSize(), i.getColor(), i.getYear())
        ).collect(Collectors.toList());
        return jerseyDTOS;
    }
}
