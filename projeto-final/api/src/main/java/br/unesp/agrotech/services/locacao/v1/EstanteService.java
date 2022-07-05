package br.unesp.agrotech.services.locacao.v1;

import br.unesp.agrotech.dtos.EstanteDTO;
import br.unesp.agrotech.entities.EstanteEntity;

import org.springframework.stereotype.Service;

@Service
public interface EstanteService extends BaseService<EstanteDTO, EstanteEntity> {
}
