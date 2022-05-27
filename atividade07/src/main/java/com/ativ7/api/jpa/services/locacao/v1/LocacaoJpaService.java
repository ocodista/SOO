package com.ativ7.api.jpa.services.locacao.v1;

import java.util.List;

import com.ativ7.api.dtos.InputAtualizarLocacaoDTO;
import com.ativ7.api.dtos.InputLocacaoDTO;
import com.ativ7.api.jpa.entities.LocacaoEntity;

import org.springframework.stereotype.Service;

@Service
public interface LocacaoJpaService {
    void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception;
    List<LocacaoEntity> buscarLocacoes() throws Exception;
    LocacaoEntity atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception;
    void deletarLocacao(Long idLocacao) throws Exception;
}
