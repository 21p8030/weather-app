package ch.bztf.lb121p8030.lb1;

import ch.bztf.lb121p8030.lb1.Controller.LocationController;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MvcResult;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class LocationControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   @Test
   public void getLocation() throws Exception {
      String uri = "/location?ort=london";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE))
            .andReturn();
      int Status = mvcResult.getResponse().getStatus();
      assertEquals(200, Status);
      String content = mvcResult.getResponse().getContentAsString();
      Location[] locations = super.mapFromJson(content, Location[].class);
      assertTrue(locations.length > 0);
   }

}