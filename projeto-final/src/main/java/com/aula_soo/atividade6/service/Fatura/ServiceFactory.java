package com.aula_soo.atividade6.service.Fatura;

public class ServiceFactory {

  public ServiceFactory() {
  }
  
  public FaturaServiceImpl getFaturaService() {
    return new FaturaServiceImpl();
  }  
}
