package br.unesp.agrotech.services.locacao.v1.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import br.unesp.agrotech.repositories.BaseRepository;
import br.unesp.agrotech.services.locacao.v1.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseServiceImpl<DTO, Entity> implements BaseService<DTO, Entity>{

    private final ModelMapper modelMapper;
    private final BaseRepository<Entity> repository;

    private Class<Entity> instance;

    @Override
    public void cadastrar(DTO dto) throws Exception {
        Entity entity = instance.getDeclaredConstructor().newInstance();

        modelMapper.map(dto, entity);
        try {
            repository.save(entity);
        } catch(Exception exception) {
            throw new Exception("Erro ao salvar dados", exception);
        }
    }

    @Override
    public List<Entity> buscar() throws Exception {
        try {
            return repository.findAll();
        } catch(Exception exception) {
            throw new Exception("Erro ao buscar dados", exception);
        }
    }

    @Override
    public Entity buscarPorId(Long id) throws Exception {
        Assert.notNull(id, "O id é obrigatório");
        try {
            Optional<Entity> findedEntity = repository.findById(id);
            Assert.notNull(findedEntity, "Não existe nenhum dado com esse id");
            return findedEntity.get();
        } catch (Exception exception) {
           throw new Exception("Erro ao buscar dados pelo id passado", exception);
        }
    }

    @Override
    public Entity atualizar(Long id, DTO dto) throws Exception {
        try {
            Assert.notNull(id, "O identificador é obrigatório");
            Entity entity = this.buscarPorId(id);
            Assert.notNull(dto, "É necessário passar alguma informação para atualizar os dados");

            modelMapper.map(dto, entity);

            return repository.save(entity);
        } catch (Exception exception) {
            throw new Exception("Erro ao atualizar os dados com o identificador: " + id, exception);
        }
    }

    @Override
    public void deletar(Long id) throws Exception {
        Assert.notNull(id, "O identificador é obrigatório");
        try {
            repository.deleteById(id);
        } catch(Exception exception) {
            throw new Exception("Não foi possível deletar com o identifcador: " + id, exception);
        }

    }
}
