package com.aula_soo.atividade6.service.Fatura;

import java.sql.SQLException;
import java.util.List;

import com.aula_soo.atividade6.models.Fatura;
import com.aula_soo.atividade6.models.FaturaDto;

public interface FaturaService {
  boolean cadastrarFatura(FaturaDto faturaDto) throws SQLException;
  List<Fatura> getAllFatuas() throws SQLException;
}
