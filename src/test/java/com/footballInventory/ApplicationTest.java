package com.footballInventory;

import com.footballinventory.FootballInventoryApplication;
import com.footballinventory.dao.JerseyRepository;
import com.footballinventory.entity.JerseyEntity;
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
    public void test_retrieve_record() throws Exception {
        JerseyEntity jersey = new JerseyEntity();
        jersey.setId(UUID.randomUUID().toString());
        jersey.setTeam("NY Cosmos");
        jersey.setSize("XS");
        jersey.setColor("White");
        jerseyRepository.save(jersey);

        mvc.perform(get("/football-api/jersey")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[2].team", is("NY Cosmos")))
                .andExpect(jsonPath("$[2].size", is("XS")))
                .andExpect(jsonPath("$[2].color", is("White")))
        ;
    }
}
