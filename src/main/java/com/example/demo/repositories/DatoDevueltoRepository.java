package com.example.demo.repositories;

import com.example.demo.models.DatosDevueltos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatoDevueltoRepository extends JpaRepository<DatosDevueltos, Long> {
}
