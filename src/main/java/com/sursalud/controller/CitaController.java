package com.sursalud.controller;

import com.sursalud.model.Cita;
import com.sursalud.model.Medico;
import com.sursalud.model.Paciente;
import com.sursalud.service.CitaService;
import com.sursalud.service.MedicoService;
import com.sursalud.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/citas")
public class CitaController {

    @Autowired private CitaService citaService;
    @Autowired private PacienteService pacienteService;
    @Autowired private MedicoService medicoService;

    @GetMapping
    public List<Cita> listar() { return citaService.listar(); }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscar(@PathVariable Long id) {
        return citaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/paciente/{id}")
    public List<Cita> porPaciente(@PathVariable Long id) { return citaService.porPaciente(id); }

    @GetMapping("/medico/{id}")
    public List<Cita> porMedico(@PathVariable Long id) { return citaService.porMedico(id); }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Map<String, Object> body) {
        try {
            Long pacienteId = Long.valueOf(body.get("pacienteId").toString());
            Long medicoId = Long.valueOf(body.get("medicoId").toString());
            String fecha = body.get("fecha").toString();
            String hora = body.get("hora").toString();

            Paciente paciente = pacienteService.buscarPorId(pacienteId).orElseThrow();
            Medico medico = medicoService.buscarPorId(medicoId).orElseThrow();

            Cita cita = new Cita(fecha, hora, "PROGRAMADA", paciente, medico);
            return ResponseEntity.ok(citaService.guardar(cita));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Cita> cancelar(@PathVariable Long id) {
        return citaService.buscarPorId(id).map(c -> {
            c.setEstado("CANCELADA");
            return ResponseEntity.ok(citaService.guardar(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
