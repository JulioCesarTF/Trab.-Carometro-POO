package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroProfessorDescricao {

    private static long serial;
    private long id;
    private RegistroProfessor registro;
    private Aluno aluno;
    private String observacao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public RegistroProfessorDescricao() {
        this.id = ++RegistroProfessorDescricao.serial;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public RegistroProfessor getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroProfessor registro) {
        this.registro = registro;
        this.dataModificacao = LocalDateTime.now();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        this.dataModificacao = LocalDateTime.now();
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RegistroProfessorDescricao other = (RegistroProfessorDescricao) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return String.format(
                "RegistroProfessorDescricao ID: %d%nAluno: %s%n"
                + "RegistroProfessor: Professor: %s | Disciplina: %s | Turma: %s | Período: %s%n"
                + "Observação: %s%n"
                + "Criado em: %s | Última Modificação: %s%n",
                id,
                aluno != null ? aluno.getNome() : "N/A",
                registro != null && registro.getProfessor() != null && registro.getProfessor().getPessoa() != null
                ? registro.getProfessor().getPessoa().getNome() : "N/A",
                registro != null ? registro.getDisciplina() : "N/A",
                registro != null && registro.getTurma() != null ? registro.getTurma().getNome() : "N/A",
                registro != null ? registro.getPeriodo() : "N/A",
                observacao != null ? observacao : "Nenhuma observação",
                dataCriacao.format(DTF), dataModificacao.format(DTF));

    }

}
