package com.ativ7.api.services.locacao.v1;

import java.util.List;

import com.ativ7.api.dtos.InputAtualizarLocacaoDTO;
import com.ativ7.api.dtos.InputLocacaoDTO;
import com.ativ7.api.entities.Locacao;

import org.springframework.stereotype.Service;

@Service
public interface LocacaoService {
    void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception;
    List<Locacao> buscarLocacoes() throws Exception;
    Locacao atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception;
}
