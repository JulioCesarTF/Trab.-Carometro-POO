package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Usuario {

    private static long serial;
    private long id;
    private Pessoa pessoa;
    private Escola escola;
    private String tipo;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Usuario() {
        this.id = ++Usuario.serial;
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

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.dataModificacao = LocalDateTime.now();
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
        this.dataModificacao = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.dataModificacao = LocalDateTime.now();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.pessoa);
        hash = 97 * hash + Objects.hashCode(this.escola);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return Objects.equals(this.escola, other.escola);
    }

    @Override
    public String toString() {
 
        return String.format("Usuario ID: %d%nTipo: %s | Pessoa: %s | Escola: %s%nCriado em: %s | Última Modificação: %s%n",
                id, tipo, pessoa.getNome(), escola.getNome(), dataCriacao.format(DTF), dataModificacao.format(DTF)
        );
    }

}
