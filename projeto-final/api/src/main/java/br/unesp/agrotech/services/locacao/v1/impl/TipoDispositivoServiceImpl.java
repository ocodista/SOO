package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.TipoDispositivoDTO;
import br.unesp.agrotech.entities.TipoDispositivoEntity;
import br.unesp.agrotech.repositories.TipoDispositivoRepository;
import br.unesp.agrotech.services.locacao.v1.TipoDispositivoService;

@Service
public class TipoDispositivoServiceImpl extends BaseServiceImpl<TipoDispositivoDTO, TipoDispositivoEntity> implements TipoDispositivoService {
    final static TipoDispositivoEntity entity = new TipoDispositivoEntity();

    public TipoDispositivoServiceImpl(ModelMapper modelMapper, TipoDispositivoRepository repository) {
        super(modelMapper, repository, entity);
    }
}
