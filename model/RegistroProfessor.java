package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroProfessor {

    private static long serial;
    private long id;
    private Usuario professor;
    private String disciplina;
    private String periodo;
    private Turma turma;
    private String revisaoDaTurma;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public RegistroProfessor() {
        this.id = ++RegistroProfessor.serial;
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

    public Usuario getProfessor() {
        return professor;
    }

    public void setProfessor(Usuario professor) {
        this.professor = professor;
        this.dataModificacao = LocalDateTime.now();

    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
        this.dataModificacao = LocalDateTime.now();

    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
        this.dataModificacao = LocalDateTime.now();

    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        this.dataModificacao = LocalDateTime.now();

    }

    public String getRevisaoDaTurma() {
        return revisaoDaTurma;
    }

    public void setRevisaoDaTurma(String revisaoDaTurma) {
        this.revisaoDaTurma = revisaoDaTurma;
        this.dataModificacao = LocalDateTime.now();

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final RegistroProfessor other = (RegistroProfessor) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return String.format(
                "RegistroProfessor ID: %d%nProfessor: %s | Disciplina: %s | Período: %s%n"
                + "Revisão da Turma %s: %s%nCriado em: %s | Última Modificação: %s%n",
                id, professor != null ? professor.getPessoa().getNome() : "N/A", disciplina != null ? disciplina : "N/A", periodo != null ? periodo : "N/A",
                turma != null ? turma.getNome() : "N/A", revisaoDaTurma, dataCriacao.format(DTF), dataModificacao.format(DTF)
        );
    }

}
