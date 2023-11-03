package com.example.demo.service;

import com.example.demo.model.Odontologo;
import com.example.demo.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private final OdontologoRepository repository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.repository = odontologoRepository;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return repository.save(odontologo);
    }
    public void actualizar(Odontologo odontologo) {
        repository.save(odontologo);
    }
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    public Optional<Odontologo> buscar(Long id) {
        return repository.findById(id);
    }
    public List<Odontologo> buscarTodo() {
        return repository.findAll();
    }

}
