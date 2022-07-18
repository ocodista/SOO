package br.unesp.agrotech.services.locacao.v1;

import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.PrateleiraDTO;
import br.unesp.agrotech.entities.PrateleiraEntity;

@Service
public interface PrateleiraService extends BaseService<PrateleiraDTO, PrateleiraEntity> {
}
