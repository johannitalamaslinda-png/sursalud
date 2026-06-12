package com.sursalud.service;

import com.sursalud.model.Medico;
import com.sursalud.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository repo;

    public List<Medico> listar() { return repo.findAll(); }
    public Medico guardar(Medico m) { return repo.save(m); }
    public Optional<Medico> buscarPorId(Long id) { return repo.findById(id); }
    public void eliminar(Long id) { repo.deleteById(id); }
}
