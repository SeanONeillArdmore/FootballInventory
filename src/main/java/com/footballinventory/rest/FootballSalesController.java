package com.footballinventory.rest;

import com.footballinventory.service.FootballInventoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@RequiredArgsConstructor
@Slf4j
@Validated
@Tag(name = "Football Sales API", description = "Football Shop Jersey sales tracker")
@RestController
@RequestMapping(path = "/football-sales-api")
public class FootballSalesController {

    private final FootballInventoryService inventoryService;

    @ApiOperation(value = "Get a specific Jersey from Inventory based on team and year")
    @RequestMapping(value = "/jersey/{team}/{year}", method = RequestMethod.GET)
    public ResponseEntity getJersey(@PathVariable @Size(min = 1, max = 10)  String team, @PathVariable Integer year){
        return new ResponseEntity<>(inventoryService.findJerseysByYear(team, year), HttpStatus.OK);
    }
}
