package com.henriquefidelis.med_voll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquefidelis.med_voll.paciente.DadosCadastroPaciente;
import com.henriquefidelis.med_voll.paciente.Paciente;
import com.henriquefidelis.med_voll.paciente.PacienteRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }
    
}
