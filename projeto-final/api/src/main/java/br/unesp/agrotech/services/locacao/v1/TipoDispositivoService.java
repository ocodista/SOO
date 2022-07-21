package br.unesp.agrotech.services.locacao.v1;

import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.TipoDispositivoDTO;
import br.unesp.agrotech.entities.TipoDispositivo;

@Service
public interface TipoDispositivoService extends BaseService<TipoDispositivoDTO, TipoDispositivo> {
}
