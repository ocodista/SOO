package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.dtos.EstanteDTO;
import br.unesp.agrotech.entities.EstanteEntity;
import br.unesp.agrotech.repositories.EstanteRepository;
import br.unesp.agrotech.services.locacao.v1.EstanteService;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EstanteServiceImpl extends BaseServiceImpl<EstanteDTO, EstanteEntity> implements EstanteService{

    public EstanteServiceImpl(ModelMapper modelMapper, EstanteRepository repository) {
        super(modelMapper, repository);
    }
}
