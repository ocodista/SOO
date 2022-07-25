package br.unesp.agrotech.services.locacao.v1;

import br.unesp.agrotech.dtos.CreatePlantaDTO;
import br.unesp.agrotech.entities.PlantaEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlantaService extends BaseService<CreatePlantaDTO, PlantaEntity> {
    List<PlantaEntity> buscarPorNicho(Long nichoId) throws Exception;
}
