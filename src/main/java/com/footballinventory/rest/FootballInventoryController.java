package com.footballinventory.rest;

import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.JerseyEntity;
import com.footballinventory.model.Jersey;
import com.footballinventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/football-api")
public class FootballInventoryController {

    private JerseyRepository jerseyRepository;
    private InventoryService inventoryService;

    @Autowired
    public FootballInventoryController(JerseyRepository jerseyRepository, InventoryService inventoryService) {
        this.jerseyRepository = jerseyRepository;
        this.inventoryService = inventoryService;
    }

    @RequestMapping(value = "/jersey", method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody Jersey jersey) {

        try {
            JerseyEntity jerseyEntity = new JerseyEntity();
            jerseyEntity.setColor(jersey.getColor());
            jerseyEntity.setSize(jersey.getSize());
            jerseyEntity.setTeam(jersey.getTeam());
            JerseyEntity created = jerseyRepository.save(jerseyEntity);
            jersey.setJerseyId(created.getId());
            return new ResponseEntity<>(jersey, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/jersey", method = RequestMethod.GET)
    public ResponseEntity getInventory(@RequestParam(value = "by_team", required = false) String teamFilter) {
        try {
            List<JerseyEntity> jerseyEntities;
            if (StringUtils.isEmpty(teamFilter)) {
                jerseyEntities = jerseyRepository.findAll();
            } else {
                jerseyEntities = jerseyRepository.findByTeam(teamFilter);
            }
            List<Jersey> books = jerseyEntities.stream().map(
                    i -> new Jersey(i.getId(), i.getTeam(), i.getSize(), i.getColor())
            ).collect(Collectors.toList());
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/jersey/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteInventory(@PathVariable String id) {
        try {
            JerseyEntity jerseyEntity = jerseyRepository.getOne(id);
            jerseyRepository.delete(jerseyEntity);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/jersey", method = RequestMethod.PUT)
    public ResponseEntity updateInventory(@RequestBody Jersey jersey) {
        try {
            JerseyEntity jerseyEntity = new JerseyEntity();
            jerseyEntity.setId(jersey.getJerseyId());
            jerseyEntity.setColor(jersey.getColor());
            jerseyEntity.setTeam(jersey.getTeam());
            jerseyEntity.setSize(jersey.getJerseyId());
            jerseyRepository.save(jerseyEntity);
            return new ResponseEntity<>(jersey, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
