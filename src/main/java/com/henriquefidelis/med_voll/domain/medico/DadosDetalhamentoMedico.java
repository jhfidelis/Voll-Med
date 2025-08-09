package com.henriquefidelis.med_voll.domain.medico;

import com.henriquefidelis.med_voll.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(
    Long id,
    String nome,
    String email,
    String crm,
    String telefone,
    Especialidade especialidade,
    Endereco endereco
) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
