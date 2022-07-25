package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.dtos.CreatePlantaDTO;
import br.unesp.agrotech.entities.CategoriaPlantaEntity;
import br.unesp.agrotech.entities.PlantaEntity;
import br.unesp.agrotech.repositories.PlantaRepository;
import br.unesp.agrotech.services.locacao.v1.CategoriaPlantaService;
import br.unesp.agrotech.services.locacao.v1.PlantaService;
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
public class PlantaServiceImpl extends BaseServiceImpl<CreatePlantaDTO, PlantaEntity> implements PlantaService {
    public PlantaServiceImpl(ModelMapper modelMapper, PlantaRepository repository, EntityManager entityManager, CategoriaPlantaService categoriaPlantaService) {
        super(modelMapper, repository);
        this.entityManager = entityManager;
        this.categoriaPlantaService = categoriaPlantaService;
        this.modelMapper = modelMapper;
        this.entity = new PlantaEntity();
    }

    private final CategoriaPlantaService categoriaPlantaService;
    private final EntityManager entityManager;
    private final ModelMapper modelMapper;

    @Override
    public Long cadastrar(CreatePlantaDTO createPlantaDTO) throws Exception {
        CategoriaPlantaEntity categoriaPlantaEntity = categoriaPlantaService.buscarPorId(createPlantaDTO.getIdCategoriaPlanta());
        modelMapper.map(createPlantaDTO, entity);
        entity.setCategoriaPlanta(categoriaPlantaEntity);
        return this.repository.saveAndFlush(entity).getId();
    }

    public List<PlantaEntity> buscarPorNicho(Long nichoId) throws Exception {
        Session session = (Session) entityManager.getDelegate();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<PlantaEntity> criteria = builder.createQuery(PlantaEntity.class);
        Root<PlantaEntity> root = criteria.from(PlantaEntity.class);
        criteria.select(root).where(builder.equal(root.get("idNicho"), nichoId));
        Query<PlantaEntity> q = session.createQuery(criteria);
        List<PlantaEntity> entities = q.getResultList();
        for(PlantaEntity entity:entities) {
            entity.setNicho(null);
        }
        return entities;
    }
}
