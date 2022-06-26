package com.ativ7.api.mongo.services;

import java.util.List;

import com.ativ7.api.dtos.InputAtualizarLocacaoDTO;
import com.ativ7.api.dtos.InputLocacaoDTO;
import com.ativ7.api.mongo.documents.LocacaoDocument;

import org.springframework.stereotype.Service;

@Service
public interface LocacaoMongoService {
    void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception;
    List<LocacaoDocument> buscarLocacoes() throws Exception;
    LocacaoDocument atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception;
    void deletarLocacao(Long idLocacao) throws Exception;
}
