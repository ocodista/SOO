package br.unesp.agrotech.services.locacao.v1;

import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.DispositivoDTO;
import br.unesp.agrotech.entities.DispositivoEntity;

@Service
public interface DispositivoService extends BaseService<DispositivoDTO, DispositivoEntity> {
}
