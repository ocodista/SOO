package com.aula_soo.atividade6.dao.Fatura;

import java.sql.SQLException;

import com.aula_soo.atividade6.models.Fatura;

public interface FaturaDao {
    final String INSERT_FATURA = "INSERT INTO Fatura( " +
            "valorTotal, tipoPagamento, status, idLocacao)" +
            " VALUES(?, ?, ?, ?)";

    final String SELECT_FATURAS = "SELECT * FROM Fatura";
    boolean cadastrarFatura(Fatura fatura) throws SQLException;
    Fatura getAllFaturas() throws SQLException;
}
