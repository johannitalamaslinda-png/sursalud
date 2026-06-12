package com.sursalud.repository;

import com.sursalud.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface CitaRepository extends JpaRepository<Cita, Long> {
    List<Cita> findByPacienteId(Long pacienteId);
    List<Cita> findByMedicoId(Long medicoId);
}
