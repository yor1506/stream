package com.cuentas.stream.integration;

import com.cuentas.stream.dto.DTOCuenta;

public interface Clientes {

    void Correo(String correo);

    void Prize(DTOCuenta dtoCuenta);

    void Benefit(DTOCuenta dtoCuenta);
}
