package br.unesp.agrotech.services.locacao.v1;

import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.CreateDispositivoDTO;
import br.unesp.agrotech.entities.DispositivoEntity;

import java.util.List;

@Service
public interface DispositivoService extends BaseService<CreateDispositivoDTO, DispositivoEntity> {
    List<DispositivoEntity> buscarPorNicho(Long nichoId) throws Exception;
}
