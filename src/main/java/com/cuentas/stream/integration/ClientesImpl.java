package com.cuentas.stream.integration;

import com.cuentas.stream.dto.DTOCuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientesImpl implements Clientes{

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void Correo(String correo) {
        HttpEntity<String> correoEntity = new HttpEntity<>(correo);
        restTemplate.postForLocation("http://localhost:8085/correo",correoEntity);
    }

    @Override
    public void Prize(DTOCuenta dtoCuenta) {
        HttpEntity<DTOCuenta> cuenta = new HttpEntity<>(dtoCuenta);
        restTemplate.postForLocation("http://localhost:8086/prize",cuenta);
    }

    @Override
    public void Benefit(DTOCuenta dtoCuenta) {
        HttpEntity<DTOCuenta> cuenta = new HttpEntity<>(dtoCuenta);
        restTemplate.postForLocation("http://localhost:8087/benefit",cuenta);
    }
}
