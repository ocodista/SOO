package com.aula_soo.atividade6.dao;

import com.aula_soo.atividade6.dao.Fatura.FaturaDaoImpl;

public class DaoFactory {

  public DaoFactory() {
  }

  public FaturaDaoImpl getFatruaDao() {
    return new FaturaDaoImpl();
  }
  
}
