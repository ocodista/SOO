package br.unesp.agrotech.services.locacao.v1;

import java.util.List;

import br.unesp.agrotech.dtos.InputAtualizarLocacaoDTO;
import br.unesp.agrotech.dtos.InputLocacaoDTO;
import br.unesp.agrotech.entities.LocacaoEntity;

import org.springframework.stereotype.Service;

@Service
public interface LocacaoJpaService {
    void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception;
    List<LocacaoEntity> buscarLocacoes() throws Exception;
    LocacaoEntity atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception;
    void deletarLocacao(Long idLocacao) throws Exception;
}
