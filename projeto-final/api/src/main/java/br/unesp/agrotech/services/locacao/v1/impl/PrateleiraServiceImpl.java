package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.PrateleiraDTO;
import br.unesp.agrotech.entities.Prateleira;
import br.unesp.agrotech.repositories.PrateleiraRepository;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;

@Service
public class PrateleiraServiceImpl extends BaseServiceImpl<PrateleiraDTO, Prateleira> implements PrateleiraService {
    private final static Prateleira entity = new Prateleira();

    public PrateleiraServiceImpl (ModelMapper modelMapper, PrateleiraRepository repository) {
        super(modelMapper, repository, entity);
    }
}
