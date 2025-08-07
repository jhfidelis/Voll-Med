package com.henriquefidelis.med_voll.controller;

import com.henriquefidelis.med_voll.medico.DadosCadastroMedico;
import com.henriquefidelis.med_voll.medico.DadosListagemMedico;
import com.henriquefidelis.med_voll.medico.Medico;
import com.henriquefidelis.med_voll.medico.MedicoRepository;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(Pageable paginacao) {
        return repository.findAll(paginacao)
                .map(DadosListagemMedico::new);
    }

}
