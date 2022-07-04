package br.unesp.agrotech.resources.v1;

import java.util.List;

import javax.validation.Valid;

import br.unesp.agrotech.dtos.InputAtualizarLocacaoDTO;
import br.unesp.agrotech.dtos.InputLocacaoDTO;
import br.unesp.agrotech.entities.LocacaoEntity;
import br.unesp.agrotech.services.locacao.v1.LocacaoJpaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@Api(tags = { "Locação - JPA" })
@RestController
@RequestMapping("locacao/jpa")
@RequiredArgsConstructor
public class LocacaoJpaResource {

    private final LocacaoJpaService locacaoService;

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
    public ResponseEntity<List<LocacaoEntity>> buscarLocacoes() throws Exception {
        List<LocacaoEntity> listLocacao = locacaoService.buscarLocacoes();
        return ResponseEntity.status(HttpStatus.OK).body(listLocacao);
    }

    @PutMapping("/{idLocacao}")
    public ResponseEntity<LocacaoEntity> atualizarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idLocacao") String idLocacao,
        @ApiParam(value = "Dados da locação que podem ser atualizados")
        @RequestBody InputAtualizarLocacaoDTO inputAtualizarLocacaoDTO
    ) throws Exception {
        LocacaoEntity locacaoAtualizada = locacaoService.atualizarLocacao(Long.parseLong(idLocacao), inputAtualizarLocacaoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoAtualizada);
    }

    @DeleteMapping("/{idLocacao}")
    public ResponseEntity<Void> deletarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idLocacao") String idLocacao
    ) throws Exception {
        locacaoService.deletarLocacao(Long.parseLong(idLocacao));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
