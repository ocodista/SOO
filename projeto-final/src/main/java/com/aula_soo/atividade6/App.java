package com.aula_soo.atividade6;

import java.sql.SQLException;

import com.aula_soo.atividade6.models.FaturaDto;
import com.aula_soo.atividade6.service.Fatura.ServiceFactory;

public class App {
    public static void main(String[] args) throws SQLException {
        ServiceFactory serviceFactory = new ServiceFactory();
        FaturaDto faturaDto = new FaturaDto();
        
        serviceFactory.getFaturaService().cadastrarFatura(faturaDto);
    }
}
