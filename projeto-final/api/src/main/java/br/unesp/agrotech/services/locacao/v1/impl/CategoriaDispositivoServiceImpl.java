package br.unesp.agrotech.services.locacao.v1.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.unesp.agrotech.dtos.CategoriaDispositivoDTO;
import br.unesp.agrotech.entities.CategoriaDispositivo;
import br.unesp.agrotech.repositories.CategoriaDispositivoRepository;
import br.unesp.agrotech.services.locacao.v1.CategoriaDispositivoService;

@Service
public class CategoriaDispositivoServiceImpl extends BaseServiceImpl<CategoriaDispositivoDTO, CategoriaDispositivo> implements CategoriaDispositivoService {
    final static CategoriaDispositivo entity = new CategoriaDispositivo();

    public CategoriaDispositivoServiceImpl (ModelMapper modelMapper, CategoriaDispositivoRepository categoriaDispositivoRepository) {
        super(modelMapper, categoriaDispositivoRepository, entity);
    }
}
