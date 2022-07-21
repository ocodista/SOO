package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.dtos.NichoDTO;
import br.unesp.agrotech.entities.Nicho;
import br.unesp.agrotech.services.locacao.v1.NichoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = { "Nicho" })
@RestController
@RequestMapping("/nicho")
@RequiredArgsConstructor
public class NichoResource {

    private final NichoService nichoService;

    @ApiOperation(value = "Este serviço cadastra novos nichos")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarNicho(
        @ApiParam(value = "Dados do nicho que será cadastrado", required = true)
        @Valid @RequestBody NichoDTO nichoDto
    ) throws Exception {
        nichoService.cadastrar(nichoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de nichos")
    @GetMapping("/")
    public ResponseEntity<List<Nicho>> buscarNicho() throws Exception {
        List<Nicho> nichos = nichoService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(nichos);
    }

    @ApiOperation(value = "Este serviço atualiza um nicho através do id")
    @PutMapping("/{idNicho}")
    public ResponseEntity<Nicho> atualizarNicho(
        @ApiParam(value = "Id do nicho a ser atualizado", required = true)
        @PathVariable("idNicho") String idNicho,
        @ApiParam(value = "Dados do nicho que podem ser atualizados")
        @RequestBody NichoDTO nichoDto
    ) throws Exception {
        Nicho nichoAtualizado = nichoService.atualizar(Long.parseLong(idNicho), nichoDto);
        return ResponseEntity.status(HttpStatus.OK).body(nichoAtualizado);
    }

    @ApiOperation(value = "Este serviço remove um nicho através do id")
    @DeleteMapping("/{idNicho}")
    public ResponseEntity<Void> deletarNicho(
        @ApiParam(value = "Id do nicho a ser removido", required = true)
        @PathVariable("idNicho") String idNicho
    ) throws Exception {
        nichoService.deletar(Long.parseLong(idNicho));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
