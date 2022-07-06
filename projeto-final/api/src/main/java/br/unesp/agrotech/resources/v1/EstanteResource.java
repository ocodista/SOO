package br.unesp.agrotech.resources.v1;

import java.util.List;

import javax.validation.Valid;

import br.unesp.agrotech.dtos.EstanteDTO;
import br.unesp.agrotech.entities.EstanteEntity;
import br.unesp.agrotech.services.locacao.v1.EstanteService;

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

@Api(tags = { "Estante" })
@RestController
@RequestMapping("/estante")
@RequiredArgsConstructor
public class EstanteResource {

    private final EstanteService estanteService;

    @ApiOperation(value = "Este serviço cadastra novas estantes")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarEstante(
        @ApiParam(value = "Dados da estante que será cadastrada", required = true)
        @Valid @RequestBody EstanteDTO estanteDTO
    ) throws Exception {
        estanteService.cadastrar(estanteDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de estantes")
    @GetMapping("/")
    public ResponseEntity<List<EstanteEntity>> buscarEstantes() throws Exception {
        List<EstanteEntity> listEstante = estanteService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(listEstante);
    }

    @ApiOperation(value = "Este serviço atualiza uma estante através do id")
    @PutMapping("/{idEstante}")
    public ResponseEntity<EstanteEntity> atualizarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idEstante") String idEstante,
        @ApiParam(value = "Dados da locação que podem ser atualizados")
        @RequestBody EstanteDTO estanteDTO
    ) throws Exception {
        EstanteEntity locacaoAtualizada = estanteService.atualizar(Long.parseLong(idEstante), estanteDTO);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoAtualizada);
    }

    @ApiOperation(value = "Este serviço remove uma estante através do id")
    @DeleteMapping("/{idEstante}")
    public ResponseEntity<Void> deletarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idEstante") String idEstante
    ) throws Exception {
        estanteService.deletar(Long.parseLong(idEstante));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
