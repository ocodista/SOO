package com.aula_soo.atividade6.dao.Fatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aula_soo.atividade6.models.Fatura;
import com.aula_soo.atividade6.utils.FabricaConexao;

public class FaturaDaoImpl implements FaturaDao {

    @Override
    public void cadastrarFatura(Fatura fatura) throws SQLException {
        Connection con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);

                PreparedStatement pstm = con.prepareStatement(INSERT_FATURA,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                pstm.setDouble(1, fatura.getValorTotal());
                pstm.setString(2, fatura.getTipoPagamento());
                pstm.setBoolean(3, fatura.getStatus());
                pstm.setInt(4, fatura.getLocacao().getIdLocacao());
                pstm.executeUpdate();

                con.commit();

                con.close();
            } catch (SQLException e) {
                System.err.println("Erro[Cadastro fatura]: " + e);
            }
        } else {
            throw new SQLException("Erro[Cadastro fatura]: sem conexão");
        }
    }
}
