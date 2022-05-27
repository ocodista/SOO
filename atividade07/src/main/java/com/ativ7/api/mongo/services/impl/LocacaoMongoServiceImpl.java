package com.ativ7.api.mongo.services.impl;

import java.util.List;
import java.util.Optional;

import com.ativ7.api.dtos.InputAtualizarLocacaoDTO;
import com.ativ7.api.dtos.InputLocacaoDTO;
import com.ativ7.api.mongo.documents.LocacaoDocument;
import com.ativ7.api.mongo.repositories.LocacaoMongoRepository;
import com.ativ7.api.mongo.services.LocacaoMongoService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoMongoServiceImpl implements LocacaoMongoService{

    private final LocacaoMongoRepository locacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception {
        Assert.notNull(inputLocacaoDTO.getStatus(), "O atributo 'status' é obrigatório");
        Assert.notNull(inputLocacaoDTO.getIdPessoa(), "O atributo 'idPessoa' é obrigatório");
        LocacaoDocument locacao = modelMapper.map(inputLocacaoDTO, LocacaoDocument.class);
        try {
            locacaoRepository.save(locacao);
        } catch(Exception exception) {
            throw new Exception("Erro ao salvar locação", exception);
        }
    }

    @Override
    public List<LocacaoDocument> buscarLocacoes() throws Exception {
        try {
            return locacaoRepository.findAll();
        } catch(Exception exception) {
            throw new Exception("Erro ao buscar locações", exception);
        }
    }

    @Override
    public LocacaoDocument atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception {
        try {
            Assert.notNull(idLocacao, "O identificador da locação é obrigatório");
            LocacaoDocument locacao = buscarLocacaoPorId(idLocacao);
            Assert.notNull(inputAtualizarLocacaoDTO, "É necessário passar alguma informação para atualizar a locação");
            if (inputAtualizarLocacaoDTO.getIdPessoa() != null) {
                locacao.setIdPessoa(inputAtualizarLocacaoDTO.getIdPessoa().get());
            }
            if(inputAtualizarLocacaoDTO.getStatus() != null) {
                locacao.setStatus(inputAtualizarLocacaoDTO.getStatus().get());
            }
            return locacaoRepository.save(locacao);
        } catch (Exception exception) {
            throw new Exception("Erro ao atualizar locação com o identificador: " + idLocacao, exception);
        }
    }

    @Override
    public void deletarLocacao(Long idLocacao) throws Exception {
        Assert.notNull(idLocacao, "O id da locação é obrigatório.");
        try {
            locacaoRepository.deleteById(idLocacao);
        } catch(Exception exception) {
            throw new Exception("Não foi possível deletar a locação com o identifcador: " + idLocacao, exception);
        }
    }

    private LocacaoDocument buscarLocacaoPorId(Long idLocacao) {
        Optional<LocacaoDocument> locacaoEncontrada = locacaoRepository.findById(idLocacao);
        Assert.notNull(locacaoEncontrada, "Não foi possível encontrar uma locação com o identificador: " + idLocacao);
        return locacaoEncontrada.get();
    }

}
