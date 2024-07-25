package com.cuentas.stream.repository;

import com.cuentas.stream.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity,Integer> {

    @Query(nativeQuery = true,value = "SELECT * FROM CUENTA WHERE USERNAME=:userName")
    CuentaEntity findAccount(String userName);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "DELETE FROM CUENTA WHERE USERNAME=:user")
    void deleteAccount(String user);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE CUENTA SET USERNAME=:username , PASSWORD=:pass" +
            ", EMAIL=:email , PHONE_NUMBER=:phone , ACCOUNT_TYPE=:accountType WHERE ID=:id")
    void modifyAccount(String username,String pass,String email,String phone,int accountType, int id);


}
