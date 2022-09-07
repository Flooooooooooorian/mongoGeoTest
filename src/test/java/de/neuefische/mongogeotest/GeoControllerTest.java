package de.neuefische.mongogeotest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class GeoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GeoRepo geoRepo;

    @Test
    void findInCircle() throws Exception {

        Geo geo1 = new Geo("123", new GeoJsonPoint(5, 5));
        Geo geo2 = new Geo("123", new GeoJsonPoint(10, 10));

        geoRepo.save(geo1);
        geoRepo.save(geo2);

        String result = mockMvc.perform(get("/api/geo/20"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(result);
    }
}
