package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Turma {

    private static long serial;
    private long id;
    private String nome;
    private Curso curso;
    private Escola escola;
    private int ano;
    private int periodo;
    private boolean status;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Turma() {
        this.id = ++Turma.serial;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDateTime.now();
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
        this.dataModificacao = LocalDateTime.now();
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
        this.dataModificacao = LocalDateTime.now();
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
        this.dataModificacao = LocalDateTime.now();
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
        this.dataModificacao = LocalDateTime.now();
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.curso);
        hash = 43 * hash + Objects.hashCode(this.escola);
        hash = 43 * hash + this.ano;
        hash = 43 * hash + this.periodo;
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
        final Turma other = (Turma) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.periodo != other.periodo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return Objects.equals(this.escola, other.escola);
    }

    @Override
    public String toString() {
        return String.format(
                "Turma ID: %d%nNome: %s | Curso: %s %d-%d | Escola: %s | Status: %s%nCriado em: %s | Última Modificação: %s%n",
                id, nome, curso != null ? curso.getSigla() : "Sem curso", ano,
                periodo, escola != null ? escola.getNome() : "Sem escola", status ? "Ativo" : "Inativo", 
                DTF.format(dataCriacao), DTF.format(dataModificacao)
        );
    }

}
