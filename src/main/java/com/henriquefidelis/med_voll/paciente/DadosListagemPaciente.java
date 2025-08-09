package com.henriquefidelis.med_voll.paciente;

public record DadosListagemPaciente(
    String nome,
    String email,
    String cpf
) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
    }
    
}
