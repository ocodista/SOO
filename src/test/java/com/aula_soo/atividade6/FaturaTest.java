package com.aula_soo.atividade6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aula_soo.atividade6.models.FaturaDto;
import com.aula_soo.atividade6.models.Locacao;
import com.aula_soo.atividade6.service.Fatura.FaturaServiceImpl;
import com.aula_soo.atividade6.service.Fatura.ServiceFactory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FaturaTest {

    @Test
    void cadastrarFaturaTest() throws Exception {
        ServiceFactory serviceFactoryMock = Mockito.mock(ServiceFactory.class);
        FaturaServiceImpl faturaServiceImplMock = Mockito.mock(FaturaServiceImpl.class);
        Mockito.when(serviceFactoryMock.getFaturaService()).thenReturn(faturaServiceImplMock);
        Mockito.when(serviceFactoryMock.getFaturaService().cadastrarFatura(Mockito.any(FaturaDto.class))).thenReturn(true);
    
        boolean isSuccessServiceExecute = serviceFactoryMock.getFaturaService().cadastrarFatura(mockFaturaDto());
        assertTrue(isSuccessServiceExecute);
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
