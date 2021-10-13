package com.example.demo.dtos;

import com.example.demo.models.DatosDevueltos;
import lombok.Data;


@Data
public class DatosDevueltosDTO {
    private Boolean errors;
    private DatosDevueltos data;
    private String message;

    public DatosDevueltosDTO(Boolean b, DatosDevueltos data, String message){
        this.errors = b;
        this.data = data;
        this.message = message;
    }
}
