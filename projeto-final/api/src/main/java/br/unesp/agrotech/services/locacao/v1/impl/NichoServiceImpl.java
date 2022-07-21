package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.NichoDTO;
import br.unesp.agrotech.entities.Nicho;
import br.unesp.agrotech.entities.Prateleira;
import br.unesp.agrotech.repositories.NichoRepository;
import br.unesp.agrotech.services.locacao.v1.NichoService;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;

@Service
public class NichoServiceImpl extends BaseServiceImpl<NichoDTO, Nicho> implements NichoService {
    private final static Nicho entity = new Nicho();
    private final PrateleiraService prateleiraService;

    public NichoServiceImpl(ModelMapper modelMapper, NichoRepository repository, PrateleiraService prateleiraService) {
        super(modelMapper, repository, entity);
        this.prateleiraService = prateleiraService;
    }

    @Override
    public void cadastrar(NichoDTO nichoDto) throws Exception {
        Prateleira prateleiraEntity = prateleiraService.buscarPorId(nichoDto.getIdPrateleira());
        entity.setPrateleira(prateleiraEntity);
        entity.setPosicaoHorizontal(nichoDto.getPosicaoHorizontal());
    }
}
