package com.footballInventory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.footballinventory.FootballInventoryApplication;
import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.Jersey;
import com.footballinventory.model.JerseyDTO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = FootballInventoryApplication.class)
@AutoConfigureMockMvc()
public class ApplicationTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private JerseyRepository jerseyRepository;

    @Test
    public void test_retrieve_delete_record() throws Exception {
        Jersey jersey = new Jersey();
        jersey.setId(UUID.randomUUID().toString());
        jersey.setTeam("NY Cosmos");
        jersey.setSize("XS");
        jersey.setColor("White");
        Jersey saved = jerseyRepository.save(jersey);

        // Get Added Jersey
        mvc.perform(get("/football-stock-api/jersey/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.team", is("NY Cosmos")))
                .andExpect(jsonPath("$.size", is("XS")))
                .andExpect(jsonPath("$.color", is("White")));
        // Delete Jersey
        mvc.perform(delete("/football-stock-api/jersey/" + saved.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Check is deleted
        mvc.perform(get("/football-stock-api/jersey/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_retrieve_update_record() throws Exception {
        //Add
        Jersey jersey = new Jersey();
        jersey.setId(UUID.randomUUID().toString());
        jersey.setTeam("Everton");
        jersey.setSize("XL");
        jersey.setColor("Blue");
        Jersey saved = jerseyRepository.save(jersey);

        JerseyDTO jerseyDTO = new JerseyDTO();
        jerseyDTO.setTeam("Spurs");
        jerseyDTO.setSize("L");
        jerseyDTO.setColor("White");

        mvc.perform(put("/football-stock-api/jersey/" + saved.getId()).content(asJsonString(jerseyDTO))
                .contentType(MediaType.APPLICATION_JSON))
                                .andExpect(status().isOk())
                .andExpect(jsonPath("$.team", is("Spurs")))
                .andExpect(jsonPath("$.size", is("L")))
                .andExpect(jsonPath("$.color", is("White")));
    }

    @Test
    public void test_search_for_record() throws Exception {
        Jersey jersey = new Jersey();
        jersey.setId(UUID.randomUUID().toString());
        jersey.setTeam("Milan");
        jersey.setSize("M");
        jersey.setColor("WhiteRed");
        jersey.setYear(1992);
        Jersey saved = jerseyRepository.save(jersey);

        mvc.perform(get("/football-sales-api/jersey/Milan/1992")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].team", is("Milan")))
                .andExpect(jsonPath("$.[0].size", is("M")))
                .andExpect(jsonPath("$.[0].year", is(1992)))
                .andExpect(jsonPath("$.[0].color", is("WhiteRed")));
    }

    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}