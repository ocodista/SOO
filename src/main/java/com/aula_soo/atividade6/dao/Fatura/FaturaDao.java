package com.aula_soo.atividade6.dao.Fatura;

import java.sql.SQLException;

import com.aula_soo.atividade6.models.Fatura;

public interface FaturaDao {
    final String INSERT_FATURA = "INSERT INTO Fatura( " +
            "valorTotal, tipoPagamento, status, Locacao_idLocacao)" +
            " VALUES(?, ?, ?, ?)";

    boolean cadastrarFatura(Fatura fatura) throws SQLException;
}
