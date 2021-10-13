package com.example.demo.controllers;

import com.example.demo.dtos.DatosDevueltosDTO;
import com.example.demo.dtos.DatosDevueltosSinID;
import com.example.demo.dtos.DatosListDTO;
import com.example.demo.models.DatosDevueltos;
import com.example.demo.services.DatoDevueltoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
public class DatoController {
    @Autowired
    private DatoDevueltoService service;

    @GetMapping("/api/dato")
    public DatosListDTO getAll(){
        List<DatosDevueltos> listado = service.findAll();
        if (listado == null){
            return new DatosListDTO(true, null, "Ha habido un problema con la BBDD");
        }
        return new DatosListDTO(false, listado, "");
    }
    @PostMapping("/api/dato")
    public DatosDevueltosDTO postDato(@RequestBody @Valid DatosDevueltosSinID datosDevueltosSinID){
        DatosDevueltos ret = service.save(datosDevueltosSinID);
        if (ret == null){
            return new DatosDevueltosDTO(true, null, "Problema al añadir");
        }
        return new DatosDevueltosDTO(false, ret, "");
    }
    @GetMapping("/api/dato/{id}")
    public DatosDevueltosDTO getByID(@PathVariable Long id){
        try {
            DatosDevueltos ret= service.findById(id).get();
            return new DatosDevueltosDTO(false,ret, "");
        }catch (NoSuchElementException e){
            return new DatosDevueltosDTO(true, null, "Objeto no encontrado");
        }
    }

    @PutMapping("/api/dato/{id}")
    public DatosDevueltosDTO updateById(
            @PathVariable Long id,
            @RequestBody @Valid DatosDevueltos datosModificar){
        try {
            DatosDevueltos ret= service.findById(id).get();
            ret.setEdad(datosModificar.getEdad());
            ret.setNombre(datosModificar.getNombre());
            service.update(ret);
            return new DatosDevueltosDTO(false,ret, "");
        }catch (NoSuchElementException e){
            return new DatosDevueltosDTO(true, null, "Objeto no encontrado");
        }
    }
    @DeleteMapping("/api/dato/{id}")
    public DatosDevueltosDTO deleteByID(@PathVariable Long id){
        try {
            DatosDevueltos ret= service.findById(id).get();
            service.deleteById(id);
            return new DatosDevueltosDTO(false,ret, "");
        }catch (NoSuchElementException e){
            return new DatosDevueltosDTO(true, null, "Objeto no encontrado");
        }
    }
}
