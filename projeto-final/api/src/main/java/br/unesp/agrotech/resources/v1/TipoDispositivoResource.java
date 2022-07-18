package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.dtos.TipoDispositivoDTO;
import br.unesp.agrotech.entities.TipoDispositivoEntity;
import br.unesp.agrotech.services.locacao.v1.TipoDispositivoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = { "TipoDispositivo" })
@RestController
@RequestMapping("/tipoDispositivo")
@RequiredArgsConstructor
public class TipoDispositivoResource {

    private final TipoDispositivoService tipoDispositivoService;

    @ApiOperation(value = "Este serviço cadastra novos tipos de dispositivos")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarTipoDispositivo(
        @ApiParam(value = "Dados do tipoDispositivo que será cadastrado", required = true)
        @Valid @RequestBody TipoDispositivoDTO tipoDispositivoDto
    ) throws Exception {
        tipoDispositivoService.cadastrar(tipoDispositivoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de tipos de dispositivos")
    @GetMapping("/")
    public ResponseEntity<List<TipoDispositivoEntity>> buscarTipoDispositivo() throws Exception {
        List<TipoDispositivoEntity> tipoDispositivos = tipoDispositivoService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(tipoDispositivos);
    }

    @ApiOperation(value = "Este serviço atualiza um tipoDispositivo através do id")
    @PutMapping("/{idTipoDispositivo}")
    public ResponseEntity<TipoDispositivoEntity> atualizarTipoDispositivo(
        @ApiParam(value = "Id do tipoDispositivo a ser atualizado", required = true)
        @PathVariable("idTipoDispositivo") String idTipoDispositivo,
        @ApiParam(value = "Dados do tipoDispositivo que podem ser atualizados")
        @RequestBody TipoDispositivoDTO tipoDispositivoDto
    ) throws Exception {
        TipoDispositivoEntity tipoDispositivoAtualizado = tipoDispositivoService.atualizar(Long.parseLong(idTipoDispositivo), tipoDispositivoDto);
        return ResponseEntity.status(HttpStatus.OK).body(tipoDispositivoAtualizado);
    }

    @ApiOperation(value = "Este serviço remove um tipo de dispositivo através do id")
    @DeleteMapping("/{idTipoDispositivo}")
    public ResponseEntity<Void> deletarTipoDispositivo(
        @ApiParam(value = "Id do tipoDispositivo a ser removido", required = true)
        @PathVariable("idTipoDispositivo") String idTipoDispositivo
    ) throws Exception {
        tipoDispositivoService.deletar(Long.parseLong(idTipoDispositivo));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
