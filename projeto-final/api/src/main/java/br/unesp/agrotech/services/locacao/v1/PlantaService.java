package br.unesp.agrotech.services.locacao.v1;

import br.unesp.agrotech.dtos.PlantaDTO;
import br.unesp.agrotech.entities.PlantaEntity;
import org.springframework.stereotype.Service;

@Service
public interface PlantaService extends BaseService<PlantaDTO, PlantaEntity> {
}
