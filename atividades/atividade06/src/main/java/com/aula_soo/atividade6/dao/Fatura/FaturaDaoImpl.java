package com.aula_soo.atividade6.dao.Fatura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aula_soo.atividade6.models.Fatura;
import com.aula_soo.atividade6.models.Locacao;
import com.aula_soo.atividade6.utils.FabricaConexao;

public class FaturaDaoImpl implements FaturaDao {

    @Override
    public boolean cadastrarFatura(Fatura fatura) throws SQLException {
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

                return true;
            } catch (SQLException e) {
                System.err.println("Erro[Cadastro fatura]: " + e);
                return false;
            }
        } else {
            throw new SQLException("Erro[Cadastro fatura]: sem conexão");
        }
    }

    @Override
    public List<Fatura> getAllFaturas() throws SQLException {
        Connection con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                con.setAutoCommit(false);

                PreparedStatement pstm = con.prepareStatement(SELECT_FATURAS,
                        PreparedStatement.RETURN_GENERATED_KEYS);

                List<Fatura> faturas = new ArrayList<>();
                Locacao locacao = new Locacao();
                ResultSet result = pstm.executeQuery();

                while (result.next()) {
                    Fatura fatura = new Fatura();
                    fatura.setIdFatura(result.getInt("idFatura"));
                    fatura.setStatus(result.getBoolean("status"));
                    fatura.setTipoPagamento(result.getString("tipoPagamento"));
                    fatura.setValorTotal(result.getDouble("valorTotal"));
                    locacao.setIdLocacao(result.getInt("idLocacao"));
                    fatura.setLocacao(locacao);
                    faturas.add(fatura);
                }

                con.commit();

                con.close();

                return faturas;
            } catch (SQLException e) {
                System.err.println("Erro[Recuperar faturas]: " + e);
                return null;
            }
        } else {
            throw new SQLException("Erro[Recuperar faturas]: sem conexão");
        }
    }
}
