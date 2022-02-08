package com.footballinventory.rest;

import com.footballinventory.model.JerseyDTO;
import com.footballinventory.service.FootballInventoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@Tag(name = "Football Stock API", description = "Football Shop Jersey stock tracker")
@RestController
@RequestMapping(path = "/football-stock-api")
public class FootballStockController {

    private final FootballInventoryService inventoryService;

    @ApiOperation(value = "Add a Jersey to the Inventory")
    @RequestMapping(value = "/jersey", method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody JerseyDTO jerseyDTO) {
        return new ResponseEntity<>(inventoryService.addJersey(jerseyDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "Get All Jerseys from Inventory")
    @RequestMapping(value = "/jersey", method = RequestMethod.GET)
    public ResponseEntity getInventory(){
        return new ResponseEntity<>(inventoryService.findAllJerseys(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get a specific Jersey from Inventory based on id")
    @RequestMapping(value = "/jersey/{id}", method = RequestMethod.GET)
    public ResponseEntity getJersey(@PathVariable String id){
        return new ResponseEntity<>(inventoryService.findJerseyById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete a Jersey from Inventory")
    @RequestMapping(value = "/jersey/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteInventory(@PathVariable String id) {
        inventoryService.deleteJersey(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value = "Update a Jersey in the Inventory")
    @RequestMapping(value = "/jersey/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateInventory(@RequestBody JerseyDTO jerseyDTO, @PathVariable String id) {
        return new ResponseEntity<>(inventoryService.updateJersey(id, jerseyDTO), HttpStatus.OK);
    }
}
