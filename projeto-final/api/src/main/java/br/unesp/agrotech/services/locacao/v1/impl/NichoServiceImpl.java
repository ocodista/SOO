package br.unesp.agrotech.services.locacao.v1.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.NichoDTO;
import br.unesp.agrotech.entities.NichoEntity;
import br.unesp.agrotech.repositories.NichoRepository;
import br.unesp.agrotech.services.locacao.v1.NichoService;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class NichoServiceImpl extends BaseServiceImpl<NichoDTO, NichoEntity> implements NichoService {
    private final PrateleiraService prateleiraService;

    public NichoServiceImpl(ModelMapper modelMapper, NichoRepository repository, PrateleiraService prateleiraService, EntityManager entityManager) {
        super(modelMapper, repository);
        this.prateleiraService = prateleiraService;
        this.entityManager = entityManager;
        this.entity = new NichoEntity();
    }

    private final EntityManager entityManager;

    public List<NichoEntity> buscarPorPrateleira(Long prateleiraId) throws Exception {
        try {
            Session session = (Session) entityManager.getDelegate();

            // Create CriteriaBuilder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            // Create CriteriaQuery
            CriteriaQuery<NichoEntity> criteria = builder.createQuery(NichoEntity.class);
            Root<NichoEntity> root = criteria.from(NichoEntity.class);
            criteria.select(root).where(builder.equal(root.get("idPrateleira"), prateleiraId));
            Query<NichoEntity> q = session.createQuery(criteria);

            List<NichoEntity> entities = q.getResultList();
            return entities;

        } catch(Exception exception) {
            throw new Exception("Erro ao buscar dados", exception);
        }
    }

    /*@Override
    public Long cadastrar(NichoDTO nichoDto) throws Exception {
        PrateleiraEntity prateleiraEntity = prateleiraService.buscarPorId(nichoDto.getIdPrateleira());
        entity.setPrateleira(prateleiraEntity);
        entity.setPosicaoHorizontal(nichoDto.getPosicaoHorizontal());
        return repository.saveAndFlush(prateleiraEntity)
    }*/
}
