package com.cuentas.stream.rest.api;

import com.cuentas.stream.StreamApplication;
import com.cuentas.stream.dto.DTOCuenta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {        StreamApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CuentaRestTest {


    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    RestTemplate restTemplate;

    private MockRestServiceServer mockRestServiceServer;

    @BeforeEach
    public  void init() {
        mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void basic() throws Exception {
       mockRestServiceServer.expect(once(),requestTo("http://localhost:8085/correo")).andRespond(withSuccess());
       mockRestServiceServer.expect(once(),requestTo("http://localhost:8086/prize")).andRespond(withSuccess());

        DTOCuenta dtoCuenta = new DTOCuenta(null,"Jose","abcdef","Jose@hotmail.com","9989898211",1);
        mvc.perform(MockMvcRequestBuilders.
                post("/cuenta").
                content(objectMapper.writeValueAsString(dtoCuenta)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void standar() throws Exception {
        mockRestServiceServer.expect(once(),requestTo("http://localhost:8085/correo")).andRespond(withSuccess());
        mockRestServiceServer.expect(once(),requestTo("http://localhost:8086/prize")).andRespond(withSuccess());


        DTOCuenta dtoCuenta = new DTOCuenta(null,"Gabriel","abcdefg","Gabriel@hotmail.com","9989898332",2);
        mvc.perform(MockMvcRequestBuilders.
                post("/cuenta").
                content(objectMapper.writeValueAsString(dtoCuenta)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void premium() throws Exception {
        mockRestServiceServer.expect(once(),requestTo("http://localhost:8085/correo")).andRespond(withSuccess());
        mockRestServiceServer.expect(once(),requestTo("http://localhost:8087/benefit")).andRespond(withSuccess());



        DTOCuenta dtoCuenta = new DTOCuenta(null,"Arturo","abcdefhg","Arturo@hotmail.com","99898982332",3);
        mvc.perform(MockMvcRequestBuilders.
                post("/cuenta").
                content(objectMapper.writeValueAsString(dtoCuenta)).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}