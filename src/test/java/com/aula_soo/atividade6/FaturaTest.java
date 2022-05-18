package com.aula_soo.atividade6;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aula_soo.atividade6.models.Fatura;
import com.aula_soo.atividade6.models.FaturaDto;
import com.aula_soo.atividade6.models.Locacao;
import com.aula_soo.atividade6.service.Fatura.ServiceFactory;

import org.junit.jupiter.api.Test;

public class FaturaTest {

    @Test
    void cadastrarFaturaTest() throws Exception {
        ServiceFactory serviceFactory = new ServiceFactory();
        boolean isSuccessServiceExecute = serviceFactory.getFaturaService().cadastrarFatura(mockFaturaDto());
        assertTrue(isSuccessServiceExecute);
    }

    @Test 
    void getAllFaturas() throws Exception {
        ServiceFactory serviceFactory = new ServiceFactory();
        Fatura fatura = serviceFactory.getFaturaService().getAllFatuas();
        assertNotNull(fatura);
    }
    
    private FaturaDto mockFaturaDto() {
        FaturaDto faturaDto = new FaturaDto();

        faturaDto.setLocacao(mockLocacao());
        faturaDto.setStatus(true);
        faturaDto.setTipoPagamento("Cartão");
        faturaDto.setValorTotal(200.00);

        return faturaDto;
    }

    private Locacao mockLocacao() {
        Locacao locacao = new Locacao();
        locacao.setIdLocacao(2);
        locacao.setStatus(true);

        return locacao;
    }
}
