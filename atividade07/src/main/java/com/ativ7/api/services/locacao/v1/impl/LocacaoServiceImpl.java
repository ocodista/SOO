package com.ativ7.api.services.locacao.v1.impl;

import java.util.List;
import java.util.Optional;

import com.ativ7.api.dtos.InputAtualizarLocacaoDTO;
import com.ativ7.api.dtos.InputLocacaoDTO;
import com.ativ7.api.entities.Locacao;
import com.ativ7.api.repositories.jpa.LocacaoJpaRepository;
import com.ativ7.api.services.locacao.v1.LocacaoService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoServiceImpl implements LocacaoService{

    private final LocacaoJpaRepository locacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception {
        Assert.notNull(inputLocacaoDTO.getStatus(), "O atributo 'status' é obrigatório");
        Assert.notNull(inputLocacaoDTO.getIdPessoa(), "O atributo 'idPessoa' é obrigatório");

        Locacao locacao = modelMapper.map(inputLocacaoDTO, Locacao.class);

        try {
            locacaoRepository.save(locacao);
        } catch(Exception exception) {
            throw new Exception("Erro ao salvar locação", exception);
        }
    }

    @Override
    public List<Locacao> buscarLocacoes() throws Exception {
        try {
            return locacaoRepository.findAll();
        } catch(Exception exception) {
            throw new Exception("Erro ao buscar locações", exception);
        }
    }

    @Override
    public Locacao atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception {
        try {
            Assert.notNull(idLocacao, "O identificador da locação é obrigatório");

            Optional<Locacao> locacaoEncontrada = locacaoRepository.findById(idLocacao);

            Assert.isTrue(!locacaoEncontrada.isEmpty(), "Não foi possível encontrar uma locação com o identificador: " + idLocacao);
            Assert.notNull(inputAtualizarLocacaoDTO, "É necessário passar alguma informação para atualizar a locação");

            Locacao locacao = locacaoEncontrada.get();

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

}
