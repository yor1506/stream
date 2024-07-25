package com.cuentas.stream.service;

import com.cuentas.stream.dto.DTOCuenta;

import java.util.List;

public interface CuentaService {

    List<DTOCuenta> listar();

    DTOCuenta buscarCuenta(String username);

    void insertarCuenta(DTOCuenta dtoCuenta);

    void deleteCuenta(String username);

    void modificarCuenta(DTOCuenta dc, int id);
}
