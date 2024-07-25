package com.cuentas.stream.rest.api;

import com.cuentas.stream.dto.DTOCuenta;
import com.cuentas.stream.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.cuentas.stream.rest.commons.EndPointConstant.*;

@RestController
public class CuentaRest {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping(CUENTA)
    public ResponseEntity<List<DTOCuenta>> listar() {

        return ResponseEntity.ok(cuentaService.listar());
    }

    @GetMapping(CUENTAACCION)
    public ResponseEntity<DTOCuenta> buscarCuenta(@PathVariable String username) {
        return ResponseEntity.ok(cuentaService.buscarCuenta(username));
    }

    @PostMapping(CUENTA)
    public void insertarCuenta(@RequestBody DTOCuenta dtoCuenta) {
        cuentaService.insertarCuenta(dtoCuenta);
        ResponseEntity.noContent().build();
    }

    @DeleteMapping(CUENTAACCION)
    public void deleteCuenta(@PathVariable String username){
        cuentaService.deleteCuenta(username);
        ResponseEntity.noContent().build();
    }

    @PutMapping(CUENTAMODI)
    public void modificarCuenta(@RequestBody DTOCuenta dc,@PathVariable int id){
        cuentaService.modificarCuenta(dc,id);
        ResponseEntity.noContent().build();
    }

}
