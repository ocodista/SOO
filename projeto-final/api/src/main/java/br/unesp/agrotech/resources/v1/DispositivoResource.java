package br.unesp.agrotech.resources.v1;

import java.util.List;

import javax.validation.Valid;

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

import br.unesp.agrotech.dtos.DispositivoDTO;
import br.unesp.agrotech.entities.DispositivoEntity;
import br.unesp.agrotech.services.locacao.v1.DispositivoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;

@Api(tags = { "Dispositivos" })
@RestController
@RequestMapping("/dispositivo")
@RequiredArgsConstructor
public class DispositivoResource {

    private final DispositivoService dispositivoService;

    @ApiOperation(value = "Este serviço cadastra novas estantes")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarDispositivo(
        @ApiParam(value = "Dados da estante que será cadastrada", required = true)
        @Valid @RequestBody DispositivoDTO dispositivoDto
    ) throws Exception {
        dispositivoService.cadastrar(dispositivoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de estantes")
    @GetMapping("/")
    public ResponseEntity<List<DispositivoEntity>> buscarDispositivo() throws Exception {
        List<DispositivoEntity> dispositivos = dispositivoService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(dispositivos);
    }

    @ApiOperation(value = "Este serviço atualiza um dispositivo através do id")
    @PutMapping("/{idDispositivo}")
    public ResponseEntity<DispositivoEntity> atualizarDispositivo(
        @ApiParam(value = "Id do dispositivo a ser atualizada", required = true)
        @PathVariable("idDispositivo") String idDispositivo,
        @ApiParam(value = "Dados do dispositivo que podem ser atualizados")
        @RequestBody DispositivoDTO dispositivoDto
    ) throws Exception {
        DispositivoEntity dispositivoAtualizado = dispositivoService.atualizar(Long.parseLong(idDispositivo), dispositivoDto);
        return ResponseEntity.status(HttpStatus.OK).body(dispositivoAtualizado);
    }

    @ApiOperation(value = "Este serviço remove uma estante através do id")
    @DeleteMapping("/{idDispositivo}")
    public ResponseEntity<Void> deletarDispositivo(
        @ApiParam(value = "Id do dispositivo a ser removid", required = true)
        @PathVariable("idDispositivo") String idDispositivo
    ) throws Exception {
        dispositivoService.deletar(Long.parseLong(idDispositivo));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
