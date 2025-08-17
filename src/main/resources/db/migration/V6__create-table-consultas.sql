CREATE TABLE tb_consultas(
    id BIGINT NOT NULL auto_increment,
    medico_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    data DATETIME NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_consultas_medico_id FOREIGN KEY(medico_id) REFERENCES tb_medicos(id),
    CONSTRAINT fk_consultas_paciente_id FOREIGN KEY(paciente_id) REFERENCES tb_pacientes(id)
);