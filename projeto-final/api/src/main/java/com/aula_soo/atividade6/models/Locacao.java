package com.aula_soo.atividade6.models;

public class Locacao {
    private int idLocacao;
    private boolean status;

    public Locacao() {
    }

    public int getIdLocacao() {
        return this.idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "{" +
                " idLocacao='" + getIdLocacao() + "'" +
                ", status='" + isStatus() + "'" +
                "}";
    }
}
