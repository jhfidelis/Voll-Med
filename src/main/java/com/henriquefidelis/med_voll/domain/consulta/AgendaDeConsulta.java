package com.henriquefidelis.med_voll.domain.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquefidelis.med_voll.domain.ValidacaoException;
import com.henriquefidelis.med_voll.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import com.henriquefidelis.med_voll.domain.medico.Medico;
import com.henriquefidelis.med_voll.domain.medico.MedicoRepository;
import com.henriquefidelis.med_voll.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public void agendarConsulta(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())) {
            throw new ValidacaoException("Id do médico informado não existe");
        }
        
        if (!pacienteRepository.existsById(dados.idPaciente())) {
            throw new ValidacaoException("Id do paciente informado não existe");
        }

        validadores.forEach(v -> v.validar(dados));
        
        var medico = escolherMedico(dados);
        var paciente = pacienteRepository.getReferenceById(dados.idPaciente());

        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new ValidacaoException("A especialidade é obrigatória quando o médico não for escolhido");
        }

        return medicoRepository.escolherMedicoAleatoriamente(dados.especialidade(), dados.data());
    }
    
}
