package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VidaAcademica {

    private static long serial;
    private long id;
    private String tipo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public VidaAcademica() {
        this.id = ++VidaAcademica.serial;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
        this.dataModificacao = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
        final VidaAcademica other = (VidaAcademica) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return String.format(
                "Notificação ID: %d%nTipo: %s | Descrição: %s%nCriado em: %s | Última Modificação: %s%n",
                id, tipo, descricao, dataCriacao.format(DTF), dataModificacao.format(DTF)
        );

    }
}
