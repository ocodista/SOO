package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.PrateleiraDTO;
import br.unesp.agrotech.entities.PrateleiraEntity;
import br.unesp.agrotech.repositories.PrateleiraRepository;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;

@Service
public class PrateleiraServiceImpl extends BaseServiceImpl<PrateleiraDTO, PrateleiraEntity> implements PrateleiraService {
    private final static PrateleiraEntity entity = new PrateleiraEntity();

    public PrateleiraServiceImpl (ModelMapper modelMapper, PrateleiraRepository repository) {
        super(modelMapper, repository, entity);
    }
}
