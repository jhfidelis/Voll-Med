package com.henriquefidelis.med_voll.medico;

import com.henriquefidelis.med_voll.endereco.DadosEndereco;

public record DadosCadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
