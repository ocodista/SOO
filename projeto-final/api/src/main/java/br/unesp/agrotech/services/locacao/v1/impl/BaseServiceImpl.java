package br.unesp.agrotech.services.locacao.v1.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import br.unesp.agrotech.services.locacao.v1.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BaseServiceImpl<DTO, E> implements BaseService<DTO, E>{
    private final ModelMapper modelMapper;
    protected final JpaRepository<E, Long> repository;
    protected E entity;

    protected void cleanEntity() throws  Exception{
        entity = (E) entity.getClass().getDeclaredConstructor().newInstance();
    }
    @Override
    public Long cadastrar(DTO dto) throws Exception {
        cleanEntity();
        modelMapper.map(dto, entity);
        try {
            Object createdEntity = repository.saveAndFlush(entity);
            Field fieldId = createdEntity.getClass().getDeclaredField("id");
            fieldId.setAccessible(true);
            Long id = (Long) fieldId.get(createdEntity);
            return id;
        } catch(Exception exception) {
            throw new Exception("Erro ao salvar dados", exception);
        }
    }

    @Override
    public List<E> buscar() throws Exception {
        try {
            return repository.findAll();
        } catch(Exception exception) {
            throw new Exception("Erro ao buscar dados", exception);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public E buscarPorId(Long id) throws Exception {
        Assert.notNull(id, "O id é obrigatório");
        Optional<E> findedEntity = repository.findById(id);
        if (!findedEntity.isPresent()) {
            throw new Exception("Não há dados com o id informado");
        }
        return findedEntity.get();
    }

    @Transactional(readOnly = true)
    public List<E> buscarPorIds(List<Long> ids) throws Exception {
        Assert.notEmpty(ids, "Ids são obrigatórios");
        List<E> entities = repository.findAllById(ids);
        if (entities.size() == 0) {
            throw new Exception("Não há dados com o id informado");
        }
        return entities;
    }

    public E atualizar(Long id, DTO dto) throws Exception {
        try {
            Assert.notNull(id, "O identificador é obrigatório");
            E entity = this.buscarPorId(id);
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
