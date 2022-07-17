package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.NichoDTO;
import br.unesp.agrotech.entities.NichoEntity;
import br.unesp.agrotech.entities.PrateleiraEntity;
import br.unesp.agrotech.repositories.NichoRepository;
import br.unesp.agrotech.services.locacao.v1.NichoService;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;

@Service
public class NichoServiceImpl extends BaseServiceImpl<NichoDTO, NichoEntity> implements NichoService {
    private final static NichoEntity entity = new NichoEntity();
    private final PrateleiraService prateleiraService;

    public NichoServiceImpl(ModelMapper modelMapper, NichoRepository repository, PrateleiraService prateleiraService) {
        super(modelMapper, repository, entity);
        this.prateleiraService = prateleiraService;
    }

    @Override
    public void cadastrar(NichoDTO nichoDto) throws Exception {
        PrateleiraEntity prateleiraEntity = prateleiraService.buscarPorId(nichoDto.getIdPrateleira());
        entity.setPrateleira(prateleiraEntity);
        entity.setPosicaoHorizontal(nichoDto.getPosicaoHorizontal());
    }
}
