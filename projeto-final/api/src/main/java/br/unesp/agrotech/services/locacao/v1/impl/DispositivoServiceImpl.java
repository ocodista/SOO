package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.dtos.CreateDispositivoDTO;
import br.unesp.agrotech.entities.CategoriaDispositivoEntity;
import br.unesp.agrotech.entities.DispositivoEntity;
import br.unesp.agrotech.entities.TipoDispositivoEntity;
import br.unesp.agrotech.repositories.DispositivoRepository;
import br.unesp.agrotech.services.locacao.v1.CategoriaDispositivoService;
import br.unesp.agrotech.services.locacao.v1.DispositivoService;

import br.unesp.agrotech.services.locacao.v1.TipoDispositivoService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class DispositivoServiceImpl extends BaseServiceImpl<CreateDispositivoDTO, DispositivoEntity> implements DispositivoService {
    public DispositivoServiceImpl(ModelMapper modelMapper,
                                  DispositivoRepository dispositivoRepository, EntityManager entityManager, TipoDispositivoService tipoDispositivoService, CategoriaDispositivoService categoriaDispositivoService) {

        super(modelMapper, dispositivoRepository);
        this.entityManager = entityManager;
        this.tipoDispositivoService = tipoDispositivoService;
        this.categoriaDispositivoService = categoriaDispositivoService;
        this.entity = new DispositivoEntity();
    }
    private final EntityManager entityManager;
    private final TipoDispositivoService tipoDispositivoService;
    private final CategoriaDispositivoService categoriaDispositivoService;

    @Override
     public Long cadastrar(CreateDispositivoDTO createDispositivoDTO) throws Exception {
        TipoDispositivoEntity tipoDispositivoEntity = tipoDispositivoService.buscarPorId(createDispositivoDTO.getIdTipoDispositivo());
        CategoriaDispositivoEntity categoriaDispositivoEntity = categoriaDispositivoService.buscarPorId(createDispositivoDTO.getIdCategoriaDispositivo());

        entity.setCategoriaDispositivo(categoriaDispositivoEntity);
        entity.setTipoDispositivo(tipoDispositivoEntity);
        entity.setIdNicho(createDispositivoDTO.getIdNicho());
        entity.setValue(createDispositivoDTO.getValue());

        try {
            return this.repository.saveAndFlush(entity).getId();
        } catch(Exception exception) {
            throw new Exception("Erro ao salvar dados", exception);
        }
    }

    public List<DispositivoEntity> buscarPorNicho(Long nichoId) throws Exception {
        Session session = (Session) entityManager.getDelegate();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<DispositivoEntity> criteria = builder.createQuery(DispositivoEntity.class);
        Root<DispositivoEntity> root = criteria.from(DispositivoEntity.class);
        criteria.select(root).where(builder.equal(root.get("idNicho"), nichoId));
        Query<DispositivoEntity> q = session.createQuery(criteria);
        List<DispositivoEntity> entities = q.getResultList();
        for(DispositivoEntity dispositivo:entities) {
            dispositivo.setNicho(null);
        }
        return entities;
    }
}
