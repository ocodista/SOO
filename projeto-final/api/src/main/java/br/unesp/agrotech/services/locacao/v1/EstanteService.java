package br.unesp.agrotech.services.locacao.v1;

import br.unesp.agrotech.dtos.CreateEstanteDTO;
import br.unesp.agrotech.entities.EstanteEntity;

import org.springframework.stereotype.Service;

@Service
public interface EstanteService extends BaseService<CreateEstanteDTO, EstanteEntity> {
}
