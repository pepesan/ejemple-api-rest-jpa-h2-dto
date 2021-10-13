package com.example.demo.dtos;

import com.example.demo.models.DatosDevueltos;
import lombok.Data;

import java.util.List;

@Data
public class DatosListDTO {
    private Boolean errors;
    private List<DatosDevueltos> data;
    private String message;

    public DatosListDTO(Boolean b, List<DatosDevueltos> listado, String message){
        this.errors = b;
        this.data = listado;
        this.message = message;
    }
}
