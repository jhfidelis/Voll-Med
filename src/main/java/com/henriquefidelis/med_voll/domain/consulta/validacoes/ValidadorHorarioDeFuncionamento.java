package com.henriquefidelis.med_voll.domain.consulta.validacoes;

import java.time.DayOfWeek;

import org.springframework.stereotype.Component;

import com.henriquefidelis.med_voll.domain.ValidacaoException;
import com.henriquefidelis.med_voll.domain.consulta.DadosAgendamentoConsulta;

@Component
public class ValidadorHorarioDeFuncionamento implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();

        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDas7Horas = dataConsulta.getHour() < 7;
        var depoisDas18Horas = dataConsulta.getHour() > 18;

        if (domingo || antesDas7Horas || depoisDas18Horas) {
            throw new ValidacaoException("Consulta fora do horário de atendimento");
        }
    }
    
}
