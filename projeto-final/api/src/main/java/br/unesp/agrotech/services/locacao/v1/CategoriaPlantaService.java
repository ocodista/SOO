package br.unesp.agrotech.services.locacao.v1;

import br.unesp.agrotech.dtos.CategoriaPlantaDTO;
import br.unesp.agrotech.entities.CategoriaPlantaEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoriaPlantaService extends BaseService<CategoriaPlantaDTO, CategoriaPlantaEntity> {
}
