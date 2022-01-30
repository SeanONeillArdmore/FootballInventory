package com.footballinventory.rest;

import com.footballinventory.model.Jersey;
import com.footballinventory.service.FootballInventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/football-api")
public class FootballInventoryController {

    private final FootballInventoryService inventoryService;

    @RequestMapping(value = "/jersey", method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody Jersey jersey) {
        try {
            return new ResponseEntity<>(inventoryService.addJersey(jersey), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/jersey", method = RequestMethod.GET)
    public ResponseEntity getInventory(@RequestParam(value = "by_team", required = false) String teamFilter) {
        try {
            List<Jersey> jerseys;
            if (StringUtils.isEmpty(teamFilter)) {
                jerseys = inventoryService.findAllJerseys();
            } else {
                jerseys = inventoryService.findJerseyByTeam(teamFilter);
            }
            return new ResponseEntity<>(jerseys, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/jersey/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteInventory(@PathVariable String id) {
        try {
            inventoryService.deleteJersey(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/jersey/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateInventory(@RequestBody Jersey jersey, @PathVariable String id) {
        try {
            return new ResponseEntity<>(inventoryService.updateJersey(id, jersey), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
