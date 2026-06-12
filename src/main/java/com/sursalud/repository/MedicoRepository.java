package com.sursalud.repository;

import com.sursalud.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MedicoRepository extends JpaRepository<Medico, Long> {}
