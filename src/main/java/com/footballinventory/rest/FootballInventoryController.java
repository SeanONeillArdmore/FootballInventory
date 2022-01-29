package com.footballinventory.rest;

import com.footballinventory.dao.InventoryRepository;
import com.footballinventory.entity.InventoryEntity;
import com.footballinventory.model.Inventory;
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

    private InventoryRepository inventoryRepository;

    @Autowired
    public FootballInventoryController(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.POST)
    public ResponseEntity addInventory(@RequestBody Inventory inventory) {

        try {
            InventoryEntity inventoryEntity = new InventoryEntity();
            inventoryEntity.setColor(inventory.getColor());
            inventoryEntity.setSize(inventory.getSize());
            inventoryEntity.setTeam(inventory.getTeam());
            InventoryEntity created = inventoryRepository.save(inventoryEntity);
            inventory.setInventoryId(created.getId());
            return new ResponseEntity<>(inventory, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @RequestMapping(value = "/inventory", method = RequestMethod.GET)
    public ResponseEntity getInventory(@RequestParam(value = "by_team", required = false) String teamFilter) {

        try {
            List<InventoryEntity> inventoryEntities;
            if (StringUtils.isEmpty(teamFilter)) {
                inventoryEntities = inventoryRepository.findAll();
            } else {
                inventoryEntities = inventoryRepository.findByTeam(teamFilter);
            }
            List<Inventory> books = inventoryEntities.stream().map(
                    i -> new Inventory(i.getId(), i.getTeam(), i.getSize(), i.getColor())
            ).collect(Collectors.toList());
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
