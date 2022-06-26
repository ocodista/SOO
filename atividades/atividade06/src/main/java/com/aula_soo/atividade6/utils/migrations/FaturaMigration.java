package com.aula_soo.atividade6.utils.migrations;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aula_soo.atividade6.utils.FabricaConexao;

public class FaturaMigration {
  private final String CREATE_TABELE = "CREATE TABLE Fatura (" +
    "idFatura BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
    "valorTotal DOUBLE, " +
    "tipoPagamento VARCHAR(65), " +
    "status BOOLEAN, " +
    "idLocacao BIGINT " +
  ");";

  public FaturaMigration() {
  }

  private boolean run(final String SQL_QUERY) {
    Connection con = FabricaConexao.getConexao();
    try {
      PreparedStatement statement = con.prepareStatement(SQL_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
      statement.executeUpdate();
      return true;
    } catch (Exception e) {
      System.err.println("[FaturaMigration] Erro ao executar SQL_QUERY");
      e.printStackTrace();
      return false;
    }
  }

  public boolean createTable() {
    return this.run(CREATE_TABELE);
  }
}
