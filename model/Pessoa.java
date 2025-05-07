package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Pessoa {

    private static long serial;
    private long id;
    private String nome;
    private LocalDate nascimento;
    private String telefone;
    private String login;
    private String senha;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa() {
        this.id = ++Pessoa.serial;
        this.dataCriacao = LocalDateTime.now();
        this.dataModificacao = this.dataCriacao;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        this.dataModificacao = LocalDateTime.now();
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimentoStr) {
        this.nascimento = LocalDate.parse(nascimentoStr, DF);
        this.dataModificacao = LocalDateTime.now();
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        this.dataModificacao = LocalDateTime.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
        this.dataModificacao = LocalDateTime.now();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
        this.dataModificacao = LocalDateTime.now();
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + Objects.hashCode(this.nascimento);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.nascimento, other.nascimento);
    }

    

    @Override
    public String toString() {
        return String.format(
                "Pessoa ID: %d%nNome: %s | Nascimento: %s | Telefone: %s%nCriado em: %s | Última Modificação: %s%n",
                id, nome, nascimento.format(DF), telefone, dataCriacao.format(DTF), dataModificacao.format(DTF)
        );
    }
    
    
    

}

