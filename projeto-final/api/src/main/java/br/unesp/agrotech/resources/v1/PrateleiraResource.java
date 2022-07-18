package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.dtos.PrateleiraDTO;
import br.unesp.agrotech.entities.PrateleiraEntity;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = { "Prateleira" })
@RestController
@RequestMapping("/prateleira")
@RequiredArgsConstructor
public class PrateleiraResource {

    private final PrateleiraService prateleiraService;

    @ApiOperation(value = "Este serviço cadastra novas prateleiras")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarPrateleira(
        @ApiParam(value = "Dados da prateleira que será cadastrada", required = true)
        @Valid @RequestBody PrateleiraDTO prateleiraDto
    ) throws Exception {
        prateleiraService.cadastrar(prateleiraDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de prateleiras")
    @GetMapping("/")
    public ResponseEntity<List<PrateleiraEntity>> buscarPrateleira() throws Exception {
        List<PrateleiraEntity> prateleiras = prateleiraService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(prateleiras);
    }

    @ApiOperation(value = "Este serviço atualiza uma prateleira através do id")
    @PutMapping("/{idPrateleira}")
    public ResponseEntity<PrateleiraEntity> atualizarPrateleira(
        @ApiParam(value = "Id da prateleira a ser atualizada", required = true)
        @PathVariable("idPrateleira") String idPrateleira,
        @ApiParam(value = "Dados da prateleira que podem ser atualizados")
        @RequestBody PrateleiraDTO prateleiraDto
    ) throws Exception {
        PrateleiraEntity prateleiraAtualizado = prateleiraService.atualizar(Long.parseLong(idPrateleira), prateleiraDto);
        return ResponseEntity.status(HttpStatus.OK).body(prateleiraAtualizado);
    }

    @ApiOperation(value = "Este serviço remove uma prateleira através do id")
    @DeleteMapping("/{idPrateleira}")
    public ResponseEntity<Void> deletarPrateleira(
        @ApiParam(value = "Id da prateleira a ser removida", required = true)
        @PathVariable("idPrateleira") String idPrateleira
    ) throws Exception {
        prateleiraService.deletar(Long.parseLong(idPrateleira));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
