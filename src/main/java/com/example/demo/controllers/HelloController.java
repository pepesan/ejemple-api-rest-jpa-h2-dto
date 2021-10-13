package com.example.demo.controllers;

import com.example.demo.models.DatosDevueltos;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class HelloController {
    @GetMapping("/api")
    public String apiHome (){
        return "Hola";
    }
    @GetMapping("/api/datos")
    public DatosDevueltos getDatosDevueltos (){
        return new DatosDevueltos(1L, "Pepe", 12);
    }
    @PostMapping("/api/datos")
    public DatosDevueltos postDatosDevueltos (@RequestBody DatosDevueltos datosDevueltos){
        return datosDevueltos;
    }

}
