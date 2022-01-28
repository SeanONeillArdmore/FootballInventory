package com.footballinventory.rest;

import com.footballinventory.dao.InventoryRepository;
import com.footballinventory.model.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/football-api")
public class FootballInventoryController {

    private InventoryRepository inventoryRepository;

    @Autowired
    public FootballInventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody Inventory inventory) {

     return null;
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ResponseEntity getInventory(@RequestParam(value = "by_team", required = false) String teamFilter) {

        return null;
    }

}
