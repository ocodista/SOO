package com.aula_soo.atividade6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import com.aula_soo.atividade6.dao.DaoFactory;
import com.aula_soo.atividade6.dao.Fatura.FaturaDaoImpl;
import com.aula_soo.atividade6.models.Fatura;
import com.aula_soo.atividade6.models.FaturaDto;
import com.aula_soo.atividade6.models.Locacao;
import com.aula_soo.atividade6.service.Fatura.ServiceFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FaturaTest {

    private DaoFactory daoFactoryMock;
    
    private FaturaDaoImpl faturaDaoImplMock;

    @BeforeEach void setUp() throws SQLException{
        daoFactoryMock = Mockito.mock(DaoFactory.class);
        faturaDaoImplMock = Mockito.mock(FaturaDaoImpl.class);
        Mockito.when(faturaDaoImplMock.cadastrarFatura(Mockito.any(Fatura.class))).thenReturn(true);
        Mockito.when(daoFactoryMock.getFatruaDao()).thenReturn(faturaDaoImplMock);
    }

    @Test
    void cadastrarFaturaTest() throws Exception {
        ServiceFactory serviceFactory = new ServiceFactory();

        boolean isSuccessServiceExecute = serviceFactory.getFaturaService().cadastrarFatura(mockFaturaDto());

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
