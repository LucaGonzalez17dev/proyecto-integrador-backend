package com.example.demo.repository;

import com.example.demo.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OdontologoRepository extends JpaRepository<Odontologo, Long> {

    @Query("from Odontologo o where o.apellido like %:apellido%")
    List <Odontologo> odontologoApellido(String apellido);


    Optional<Odontologo> findById(Long id);
}
