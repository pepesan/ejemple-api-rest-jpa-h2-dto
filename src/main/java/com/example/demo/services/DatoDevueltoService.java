package com.example.demo.services;

import com.example.demo.dtos.DatosDevueltosSinID;
import com.example.demo.models.DatosDevueltos;
import com.example.demo.repositories.DatoDevueltoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatoDevueltoService {
    @Autowired
    private DatoDevueltoRepository repository;

    public List<DatosDevueltos> findAll() {
        return repository.findAll();
    }

    public DatosDevueltos save(DatosDevueltosSinID datosDevueltosSinID) {
        DatosDevueltos datosDevueltos = new DatosDevueltos(
                null,
                datosDevueltosSinID.getNombre(),
                datosDevueltosSinID.getEdad());
        return repository.save(datosDevueltos);
    }

    public Optional<DatosDevueltos> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public DatosDevueltos update(DatosDevueltos ret) {
        return repository.save(ret);
    }
}
