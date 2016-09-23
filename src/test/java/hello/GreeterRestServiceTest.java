package hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by da3mon on 2016.09.22..
 */

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"greeter.message=Hello, %s !"})
@AutoConfigureMockMvc
public class GreeterRestServiceTest{

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetHelloWorld() throws Exception {
        this.mockMvc.perform(get("/greeter").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.content").value("Hello, World !"));
    }

    @Test
    public void greetHelloName() throws Exception{
        String name = "Daemon";
        this.mockMvc.perform(get("/greeter/"+name).accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.content").value("Hello, Daemon !"));
    }
}