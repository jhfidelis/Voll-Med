package com.henriquefidelis.med_voll.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import com.henriquefidelis.med_voll.domain.ValidacaoException;
import com.henriquefidelis.med_voll.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMinutosDeAntecedencia {

    public void validarAntecedencia(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("A Consulta deve ser marcada com pelo menos 30 minutos de antecedência");
        }
    }
    
}
