package com.example.demo.dtos;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Data
public class DatosDevueltosSinID {

    @NonNull
    private String nombre;
    @Min(0)
    private Integer edad;

    public DatosDevueltosSinID(){
        this.edad = 0;
        this.nombre = "";
    }
    public DatosDevueltosSinID(String nombre, Integer edad){
        this.edad = edad;
        this.nombre = nombre;
    }

}
