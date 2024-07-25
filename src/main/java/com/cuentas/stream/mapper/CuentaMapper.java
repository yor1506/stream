package com.cuentas.stream.mapper;



import com.cuentas.stream.dto.DTOCuenta;
import com.cuentas.stream.entity.CuentaEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CuentaMapper{

    CuentaEntity toCuentaEntity(DTOCuenta d);
    DTOCuenta toDTOCuenta(CuentaEntity c);
    List<CuentaEntity> toListCuentaEntity(List<DTOCuenta> ld);
    List<DTOCuenta> toListDTOCuenta(List<CuentaEntity> le);

}
