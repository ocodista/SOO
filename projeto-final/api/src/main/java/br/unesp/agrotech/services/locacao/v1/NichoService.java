package br.unesp.agrotech.services.locacao.v1;

import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.NichoDTO;
import br.unesp.agrotech.entities.Nicho;

@Service
public interface NichoService extends BaseService<NichoDTO, Nicho> {
}
