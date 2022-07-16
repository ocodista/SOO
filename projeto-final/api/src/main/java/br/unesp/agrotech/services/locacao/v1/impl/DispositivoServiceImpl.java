package br.unesp.agrotech.services.locacao.v1.impl;

import br.unesp.agrotech.entities.DispositivoEntity;
import br.unesp.agrotech.repositories.DispositivoRepository;
import br.unesp.agrotech.services.locacao.v1.DispositivoService;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class DispositivoServiceImpl extends BaseServiceImpl<DispositivoEntity, DispositivoEntity> implements DispositivoService {
    final static DispositivoEntity entity = new DispositivoEntity();

    public DispositivoServiceImpl(ModelMapper modelMapper, DispositivoRepository repository) {
        super(modelMapper, repository, entity);
    }
}
