package com.aula_soo.atividade6.models;

public class FaturaDto {
  private double valorTotal;
  private String tipoPagamento;
  private boolean status;
  private Locacao locacao;

  public FaturaDto() {
  }

  public double getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(double valorTotal) {
    this.valorTotal = valorTotal;
  }

  public String getTipoPagamento() {
    return this.tipoPagamento;
  }

  public void setTipoPagamento(String tipoPagamento) {
    this.tipoPagamento = tipoPagamento;
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

  public Locacao getLocacao() {
    return this.locacao;
  }

  public void setLocacao(Locacao locacao) {
    this.locacao = locacao;
  }

  @Override
  public String toString() {
    return "{" +
      " valorTotal='" + getValorTotal() + "'" +
      ", tipoPagamento='" + getTipoPagamento() + "'" +
      ", status='" + isStatus() + "'" +
      ", locacao='" + getLocacao() + "'" +
      "}";
  }
}
