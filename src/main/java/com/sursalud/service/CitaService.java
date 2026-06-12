package com.sursalud.service;

import com.sursalud.model.Cita;
import com.sursalud.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CitaService {
    @Autowired
    private CitaRepository repo;

    public List<Cita> listar() { return repo.findAll(); }
    public Cita guardar(Cita c) { return repo.save(c); }
    public Optional<Cita> buscarPorId(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
    public List<Cita> porPaciente(Long id) { return repo.findByPacienteId(id); }
    public List<Cita> porMedico(Long id) { return repo.findByMedicoId(id); }
}
