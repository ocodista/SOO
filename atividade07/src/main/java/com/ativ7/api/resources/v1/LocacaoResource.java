package com.ativ7.api.resources.v1;

import java.util.List;

import javax.validation.Valid;

import com.ativ7.api.dtos.InputAtualizarLocacaoDTO;
import com.ativ7.api.dtos.InputLocacaoDTO;
import com.ativ7.api.entities.Locacao;
import com.ativ7.api.services.locacao.v1.LocacaoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = { "Locação" })
@RestController
@RequestMapping("locacao")
@RequiredArgsConstructor
public class LocacaoResource {

    private final LocacaoService locacaoService;

    @ApiOperation(value = "Este serviço cadastra novas locações")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarLocacao(
        @ApiParam(value = "Dados da locação que será cadastrada", required = true)
        @Valid @RequestBody InputLocacaoDTO inputLocacaoDTO
    ) throws Exception {
        locacaoService.cadastrarLocacao(inputLocacaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Locacao>> buscarLocacoes() throws Exception {
        List<Locacao> listLocacao = locacaoService.buscarLocacoes();
        return ResponseEntity.status(HttpStatus.OK).body(listLocacao);
    }

    @PutMapping("/{idLocacao}")
    public ResponseEntity<Locacao> atualizarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idLocacao") Long idLocacao,
        @ApiParam(value = "Dados da locação que podem ser atualizados")
        @RequestBody InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO
    ) throws Exception {
        Locacao locacaoAtualizada = locacaoService.atualizarLocacao(idLocacao, inputAtualizarLocacaoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoAtualizada);
    }
}
