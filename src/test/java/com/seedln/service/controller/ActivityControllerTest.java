package com.seedln.service.controller;

import com.seedln.service.ServiceApplication;
import com.seedln.service.model.Activity;
import com.seedln.service.repo.ActivityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = ServiceApplication.class
)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class ActivityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ActivityRepository activityRepository;

//    @Autowired
//    private TestEntityManager testEntityManager;

    @Test
    public void itCanSaveAnActivetyWithTags() throws Exception {
        String content = "{\"title\" : \"something\", \"type\": \"else\", \"tags\" : [{\n\t\"tag\" : \"this is a tag\"\n}]}";
        mockMvc.perform(post("/activities")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title", is("something")))
                .andExpect(jsonPath("$.type", is("else")))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.tags[0].tag", is("this is a tag")));
    }

    @Test
    public void itCanAddATagToAPreExistingAcitvity(){

    }

//    @Test
//    public void itCanFetchAPreExistingActivityWithTags() throws Exception {
//        Activity activity = new Activity("preexisting", "banter");
//        testEntityManager.persist(activity);
//        testEntityManager.flush();
//
//        mockMvc.perform(get("/activities"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.title").exists())
//                .andExpect(jsonPath("$.title", is("something")))
//                .andExpect(jsonPath("$.type", is("else")))
//                .andExpect(jsonPath("$.id").exists())
//                .andExpect(jsonPath("$.tags[0].tag", is("this is a tag")));
//    }
}