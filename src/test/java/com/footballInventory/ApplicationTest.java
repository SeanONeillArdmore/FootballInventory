package com.footballInventory;

import com.footballinventory.FootballInventoryApplication;
import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.Jersey;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

        // Add Jersey
        mvc.perform(get("/football-api/jersey/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.team", is("NY Cosmos")))
                .andExpect(jsonPath("$.size", is("XS")))
                .andExpect(jsonPath("$.color", is("White")));
        // Delete Jersey
        mvc.perform(delete("/football-api/jersey/" + saved.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Check is deleted
        mvc.perform(get("/football-api/jersey/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    // update jersey
    // add one
    // update // retreiev and check its updated
}
