package com.aula_soo.atividade6.service.Fatura;

import java.sql.SQLException;

import com.aula_soo.atividade6.dao.DaoFactory;
import com.aula_soo.atividade6.models.Fatura;
import com.aula_soo.atividade6.models.FaturaDto;

public class FaturaServiceImpl implements FaturaService {

  private DaoFactory daoFactory = new DaoFactory(); 
  
  @Override
  public boolean cadastrarFatura(FaturaDto faturaDto) throws SQLException {
    final Fatura fatura = new Fatura();
    fatura.setLocacao(faturaDto.getLocacao());
    fatura.setStatus(faturaDto.getStatus());
    fatura.setTipoPagamento(faturaDto.getTipoPagamento());
    fatura.setValorTotal(faturaDto.getValorTotal());

    try {
      return daoFactory.getFatruaDao().cadastrarFatura(fatura);
    } catch(Exception e) {
      System.err.println("[FaturaService] Erro ao executar cadastro de fatura: " + e.getMessage());
      return false;
    }
  }

  @Override
  public Fatura getAllFatuas() throws SQLException {
    return daoFactory.getFatruaDao().getAllFaturas();
  }
  
}
