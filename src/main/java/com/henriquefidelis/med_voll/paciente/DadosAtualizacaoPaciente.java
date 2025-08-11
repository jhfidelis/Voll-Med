package com.henriquefidelis.med_voll.paciente;

import com.henriquefidelis.med_voll.endereco.DadosEndereco;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
    @NotNull
    Long id,

    String nome,
    String telefone,
    DadosEndereco endereco
) {
    
}
