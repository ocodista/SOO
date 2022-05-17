package com.aula_soo.atividade6.models;

import java.util.Date;

public class ItemFatura {
    private int idItemFatura;
    private Date dataVencimento;
    private Date dataPagamento;
    private int numeroParcela;
    private double valor;
    private double multa;
    private double juros;
    private Fatura fatura;

    public ItemFatura() {
    }

    public int getIdItemFatura() {
        return this.idItemFatura;
    }

    public void setIdItemFatura(int idItemFatura) {
        this.idItemFatura = idItemFatura;
    }

    public Date getDataVencimento() {
        return this.dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return this.dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public int getNumeroParcela() {
        return this.numeroParcela;
    }

    public void setNumeroParcela(int numeroParcela) {
        this.numeroParcela = numeroParcela;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getMulta() {
        return this.multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }

    public double getJuros() {
        return this.juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public Fatura getFatura() {
        return this.fatura;
    }

    public void setFatura(Fatura fatura) {
        this.fatura = fatura;
    }

    @Override
    public String toString() {
        return "{" +
                " idItemFatura='" + getIdItemFatura() + "'" +
                ", dataVencimento='" + getDataVencimento() + "'" +
                ", dataPagamento='" + getDataPagamento() + "'" +
                ", numeroParcela='" + getNumeroParcela() + "'" +
                ", valor='" + getValor() + "'" +
                ", multa='" + getMulta() + "'" +
                ", juros='" + getJuros() + "'" +
                ", fatura='" + getFatura() + "'" +
                "}";
    }

}
