package com.sursalud.service;

import com.sursalud.model.Paciente;
import com.sursalud.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository repo;

    public List<Paciente> listar() { return repo.findAll(); }
    public Paciente guardar(Paciente p) { return repo.save(p); }
    public Optional<Paciente> buscarPorId(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
}
