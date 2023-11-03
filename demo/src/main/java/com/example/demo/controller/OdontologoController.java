package com.example.demo.controller;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Odontologo;
import com.example.demo.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos() {
        return ResponseEntity.ok(odontologoService.buscarTodo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarOdontologo(@PathVariable Long id) {
        Optional<Odontologo> resultado = odontologoService.buscar(id);
        if (resultado.isPresent()) {
            return ResponseEntity.ok(resultado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException {
        return ResponseEntity.ok(odontologoService.guardar(odontologo));
    }

    @PutMapping
    public ResponseEntity<String> actualizarOdontologo(@RequestBody Odontologo odontologo) throws ResourceNotFoundException, BadRequestException {
        Optional<Odontologo> buscado = odontologoService.buscar(odontologo.getId());
        if (buscado.isPresent()) {
            odontologoService.actualizar(odontologo);
            return ResponseEntity.ok("El odontologo con el id: " + odontologo.getId() + " fue actualizado");
        } else {
            return ResponseEntity.badRequest().build();
        }

    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity <String> eliminarOdontologo (@PathVariable Long id) throws ResourceNotFoundException, BadRequestException {
//        Optional<Odontologo> resultado = odontologoService.buscar(id);
//        if (resultado.isPresent()) {
//            odontologoService.eliminar(id);
//            return ResponseEntity.ok("Se eliminó el odontologo correctamente");
//        } else {
//            return ResponseEntity.notFound().build();
//    }
//}
@DeleteMapping("/{id}")
public ResponseEntity<String> eliminarOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
    odontologoService.eliminar(id);
    return ResponseEntity.ok("Se eliminó al odontologo con id= "+id);
}
}
