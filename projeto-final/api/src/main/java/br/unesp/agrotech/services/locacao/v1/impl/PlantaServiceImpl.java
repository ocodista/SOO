package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.dtos.PlantaDTO;
import br.unesp.agrotech.entities.PlantaEntity;
import br.unesp.agrotech.repositories.PlantaRepository;
import br.unesp.agrotech.services.locacao.v1.PlantaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PlantaServiceImpl extends BaseServiceImpl<PlantaDTO, PlantaEntity> implements PlantaService {
    public PlantaServiceImpl(ModelMapper modelMapper, PlantaRepository repository) {
        super(modelMapper, repository);
        this.entity = new PlantaEntity();
    }
}
