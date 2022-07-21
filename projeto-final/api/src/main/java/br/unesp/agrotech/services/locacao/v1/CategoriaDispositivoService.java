package br.unesp.agrotech.services.locacao.v1;

import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.CategoriaDispositivoDTO;
import br.unesp.agrotech.entities.CategoriaDispositivo;

@Service
public interface CategoriaDispositivoService extends BaseService<CategoriaDispositivoDTO, CategoriaDispositivo> {
}
