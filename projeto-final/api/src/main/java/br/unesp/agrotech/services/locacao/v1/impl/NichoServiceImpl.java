package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.entities.DispositivoEntity;
import br.unesp.agrotech.entities.PlantaEntity;
import br.unesp.agrotech.services.locacao.v1.DispositivoService;
import br.unesp.agrotech.services.locacao.v1.PlantaService;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.NichoDTO;
import br.unesp.agrotech.entities.NichoEntity;
import br.unesp.agrotech.repositories.NichoRepository;
import br.unesp.agrotech.services.locacao.v1.NichoService;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;

@Service
public class NichoServiceImpl extends BaseServiceImpl<NichoDTO, NichoEntity> implements NichoService {

    public NichoServiceImpl(ModelMapper modelMapper, NichoRepository repository, EntityManager entityManager, DispositivoService dispositivoService, PlantaService plantaService) {
        super(modelMapper, repository);
        this.entityManager = entityManager;
        this.dispositivoService = dispositivoService;
        this.plantaService = plantaService;
        this.entity = new NichoEntity();
    }

    private final EntityManager entityManager;
    private final DispositivoService dispositivoService;

    private final PlantaService plantaService;
    public List<NichoEntity> buscarPorPrateleira(Long prateleiraId) throws Exception {
        Session session = (Session) entityManager.getDelegate();

        // Create CriteriaBuilder
        CriteriaBuilder builder = session.getCriteriaBuilder();

        // Create CriteriaQuery
        CriteriaQuery<NichoEntity> criteria = builder.createQuery(NichoEntity.class);
        Root<NichoEntity> root = criteria.from(NichoEntity.class);
        criteria.select(root).where(builder.equal(root.get("idPrateleira"), prateleiraId));
        Query<NichoEntity> q = session.createQuery(criteria);
        List<NichoEntity> entities = q.getResultList();
        for (NichoEntity nicho : entities) {
            Long id = nicho.getId();
            List<DispositivoEntity> dispositivos = dispositivoService.buscarPorNicho(id);
            nicho.setDispositivos(new HashSet<>(dispositivos));
            List<PlantaEntity> plantas = plantaService.buscarPorNicho(id);
            nicho.setPlantas(new HashSet<>(plantas));
            nicho.setPrateleira(null);
        }
        return entities;
    }

    /*@Override
    public Long cadastrar(NichoDTO nichoDto) throws Exception {
        PrateleiraEntity prateleiraEntity = prateleiraService.buscarPorId(nichoDto.getIdPrateleira());
        entity.setPrateleira(prateleiraEntity);
        entity.setPosicaoHorizontal(nichoDto.getPosicaoHorizontal());
        return repository.saveAndFlush(prateleiraEntity)
    }*/
}
