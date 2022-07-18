package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.dtos.CategoriaPlantaDTO;
import br.unesp.agrotech.entities.CategoriaPlantaEntity;
import br.unesp.agrotech.repositories.CategoriaPlantaRepository;
import br.unesp.agrotech.services.locacao.v1.CategoriaPlantaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CategoriaPlantaServiceImpl extends BaseServiceImpl<CategoriaPlantaDTO, CategoriaPlantaEntity> implements CategoriaPlantaService {
    final static CategoriaPlantaEntity entity = new CategoriaPlantaEntity();

    public CategoriaPlantaServiceImpl(ModelMapper modelMapper, CategoriaPlantaRepository categoriaPlantaRepository) {
        super(modelMapper, categoriaPlantaRepository, entity);
    }
}
