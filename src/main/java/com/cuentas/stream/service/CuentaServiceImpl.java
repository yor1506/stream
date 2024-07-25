package com.cuentas.stream.service;

import com.cuentas.stream.dto.DTOCuenta;
import com.cuentas.stream.entity.CuentaEntity;
import com.cuentas.stream.integration.ClientesImpl;
import com.cuentas.stream.mapper.CuentaMapper;
import com.cuentas.stream.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private CuentaMapper cuentaMapper;


    @Autowired
    private ClientesImpl clientes;

    @Override
    public List<DTOCuenta> listar() {
        List<DTOCuenta> listDTO = cuentaMapper.toListDTOCuenta(cuentaRepository.findAll());
        return listDTO;
    }

    @Override
    public DTOCuenta buscarCuenta(String username) {
        DTOCuenta dtoCuenta = cuentaMapper.toDTOCuenta(cuentaRepository.findAccount(username));
        return dtoCuenta;
    }

    @Override
    public void insertarCuenta(DTOCuenta dtoCuenta) {
        CuentaEntity ce = cuentaMapper.toCuentaEntity(dtoCuenta);
        cuentaRepository.save(ce);
        clientes.Correo(dtoCuenta.getEmail());
        if (dtoCuenta.getAccountType()==2 ||dtoCuenta.getAccountType()==1){
            clientes.Prize(dtoCuenta);
        }
        if (dtoCuenta.getAccountType()==3){
            clientes.Benefit(dtoCuenta);
        }
    }

    @Override
    public void deleteCuenta(String username) {
        cuentaRepository.deleteAccount(username);
    }

    @Override
    public void modificarCuenta(DTOCuenta dc, int id) {
        cuentaRepository.modifyAccount(dc.getUsername(),dc.getPassword(),dc.getEmail(),dc.getPhoneNumber()
        ,dc.getAccountType(),id);
    }
}
