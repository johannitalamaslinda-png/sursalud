package com.sursalud;

import com.sursalud.model.Medico;
import com.sursalud.model.Paciente;
import com.sursalud.repository.MedicoRepository;
import com.sursalud.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SurSaludApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurSaludApplication.class, args);
    }

    @Bean
    CommandLineRunner initData(PacienteRepository pacientes, MedicoRepository medicos) {
        return args -> {
            pacientes.save(new Paciente("Carlos Pérez", "1234567890", "3001234567", "carlos@email.com"));
            pacientes.save(new Paciente("Ana Gómez", "0987654321", "3109876543", "ana@email.com"));
            pacientes.save(new Paciente("Luis Torres", "1122334455", "3201122334", "luis@email.com"));

            medicos.save(new Medico("Dra. María López", "Medicina General", "101"));
            medicos.save(new Medico("Dr. Juan Rodríguez", "Cardiología", "202"));
            medicos.save(new Medico("Dra. Sofia Martínez", "Pediatría", "303"));
        };
    }
}
