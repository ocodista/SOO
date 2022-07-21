package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.TipoDispositivoDTO;
import br.unesp.agrotech.entities.TipoDispositivo;
import br.unesp.agrotech.repositories.TipoDispositivoRepository;
import br.unesp.agrotech.services.locacao.v1.TipoDispositivoService;

@Service
public class TipoDispositivoServiceImpl extends BaseServiceImpl<TipoDispositivoDTO, TipoDispositivo> implements TipoDispositivoService {
    final static TipoDispositivo entity = new TipoDispositivo();

    public TipoDispositivoServiceImpl(ModelMapper modelMapper, TipoDispositivoRepository repository) {
        super(modelMapper, repository, entity);
    }
}
