package com.example.demo.models;

import lombok.Data;
import lombok.NonNull;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Data
@Entity
public class DatosDevueltos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NonNull
    private String nombre;
    @Min(0)
    private Integer edad;

    public DatosDevueltos(){
        this.id = 0L;
        this.edad = 0;
        this.nombre = "";
    }
    public DatosDevueltos(Long id, String nombre, Integer edad){
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
    }

}
