package com.ativ7.api.dtos;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InputAtualizarLocacaoDTO {
    private Optional<Boolean> status;
    private Optional<Integer> idPessoa;
}
