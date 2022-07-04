package br.unesp.agrotech.services.locacao.v1.impl;

import java.util.List;
import java.util.Optional;

import br.unesp.agrotech.dtos.InputAtualizarLocacaoDTO;
import br.unesp.agrotech.dtos.InputLocacaoDTO;
import br.unesp.agrotech.entities.LocacaoEntity;
import br.unesp.agrotech.repositories.LocacaoJpaRepository;
import br.unesp.agrotech.services.locacao.v1.LocacaoJpaService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocacaoJpaServiceImpl implements LocacaoJpaService{

    private final LocacaoJpaRepository locacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public void cadastrarLocacao(InputLocacaoDTO inputLocacaoDTO) throws Exception {
        Assert.notNull(inputLocacaoDTO.getStatus(), "O atributo 'status' é obrigatório");
        Assert.notNull(inputLocacaoDTO.getIdPessoa(), "O atributo 'idPessoa' é obrigatório");
        LocacaoEntity locacao = modelMapper.map(inputLocacaoDTO, LocacaoEntity.class);
        try {
            locacaoRepository.save(locacao);
        } catch(Exception exception) {
            throw new Exception("Erro ao salvar locação", exception);
        }
    }

    @Override
    public List<LocacaoEntity> buscarLocacoes() throws Exception {
        try {
            return locacaoRepository.findAll();
        } catch(Exception exception) {
            throw new Exception("Erro ao buscar locações", exception);
        }
    }

    @Override
    public LocacaoEntity atualizarLocacao(Long idLocacao, InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO) throws Exception {
        try {
            Assert.notNull(idLocacao, "O identificador da locação é obrigatório");
            LocacaoEntity locacao = buscarLocacaoPorId(idLocacao);
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

    private LocacaoEntity buscarLocacaoPorId(Long idLocacao) {
        Optional<LocacaoEntity> locacaoEncontrada = locacaoRepository.findById(idLocacao);
        Assert.notNull(locacaoEncontrada, "Não foi possível encontrar uma locação com o identificador: " + idLocacao);
        return locacaoEncontrada.get();
    }

}
