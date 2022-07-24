package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.entities.NichoEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.PrateleiraDTO;
import br.unesp.agrotech.entities.PrateleiraEntity;
import br.unesp.agrotech.repositories.PrateleiraRepository;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;

import java.util.HashSet;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class PrateleiraServiceImpl extends BaseServiceImpl<PrateleiraDTO, PrateleiraEntity> implements PrateleiraService {
    public PrateleiraServiceImpl (ModelMapper modelMapper, EntityManager entityManager, NichoServiceImpl nichoService, PrateleiraRepository repository) {
        super(modelMapper, repository);
        this.entityManager = entityManager;
        this.nichoService = nichoService;
        this.repository = repository;
        this.entity = new PrateleiraEntity();
    }

    private final EntityManager entityManager;
    private final NichoServiceImpl nichoService;
    private final PrateleiraRepository repository;

    public List<PrateleiraEntity> buscarPorEstante(Long estanteId) throws Exception {
        try {
            Session session = (Session) entityManager.getDelegate();
            PrateleiraEntity prateleira = new PrateleiraEntity();
            prateleira.setIdEstante(estanteId);

            // Create CriteriaBuilder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<PrateleiraEntity> criteria = builder.createQuery(PrateleiraEntity.class);
            Root<PrateleiraEntity> root = criteria.from(PrateleiraEntity.class);
            criteria.select(root).where(builder.equal(root.get("idEstante"), estanteId));
            Query<PrateleiraEntity> q = session.createQuery(criteria);

            List<PrateleiraEntity> entities = q.getResultList();
            for (PrateleiraEntity entity:entities) {
                Long id = entity.getId();
                List<NichoEntity> nichos = nichoService.buscarPorPrateleira(id);
                entity.setNichos(new HashSet(nichos));
                entity.setEstante(null);
            }
            return entities;

        } catch(Exception exception) {
            throw new Exception("Erro ao buscar dados", exception);
        }
    }
}
