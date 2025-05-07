package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class AlunoTurma {

    private static long serial;
    private long id;
    private Aluno aluno;
    private Turma turma;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public AlunoTurma() {
        this.id = ++AlunoTurma.serial;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = this.dataCriacao;
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

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
        this.dataModificacao = LocalDateTime.now();
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        this.dataModificacao = LocalDateTime.now();
    }

    public AlunoTurma copiarParaNovaTurma(Turma novaTurma) {
        AlunoTurma copia = new AlunoTurma();
        copia.setAluno(this.aluno);
        copia.setTurma(novaTurma);
        return copia;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.aluno);
        hash = 23 * hash + Objects.hashCode(this.turma);
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
        final AlunoTurma other = (AlunoTurma) obj;
        if (!Objects.equals(this.aluno, other.aluno)) {
            return false;
        }
        return Objects.equals(this.turma, other.turma);
    }

    @Override
    public String toString() {
        return String.format("AlunoTurma ID: %d%nAluno: %s%n"
                + "Turma: %s%n Criado em: %s | Última Modificação: %s%n",
                id, aluno != null ? aluno.toString() : "null", turma != null ? turma.toString() : "null", dataCriacao.format(DTF), dataModificacao.format(DTF)
        );
    }

}
