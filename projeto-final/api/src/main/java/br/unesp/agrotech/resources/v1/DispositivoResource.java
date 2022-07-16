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
    public ResponseEntity<Void> cadastrarEstante(
        @ApiParam(value = "Dados da estante que será cadastrada", required = true)
        @Valid @RequestBody DispositivoEntity dispositivo
    ) throws Exception {
        dispositivoService.cadastrar(dispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de estantes")
    @GetMapping("/")
    public ResponseEntity<List<DispositivoEntity>> buscarEstantes() throws Exception {
        List<DispositivoEntity> dispositivos = dispositivoService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(dispositivos);
    }

    @ApiOperation(value = "Este serviço atualiza uma estante através do id")
    @PutMapping("/{idDispositivo}")
    public ResponseEntity<DispositivoEntity> atualizarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idDispositivo") String idDispositivo,
        @ApiParam(value = "Dados da locação que podem ser atualizados")
        @RequestBody DispositivoEntity dispositivoEntity
    ) throws Exception {
        DispositivoEntity locacaoAtualizada = dispositivoService.atualizar(Long.parseLong(idDispositivo), dispositivoEntity);
        return ResponseEntity.status(HttpStatus.OK).body(locacaoAtualizada);
    }

    @ApiOperation(value = "Este serviço remove uma estante através do id")
    @DeleteMapping("/{idDispositivo}")
    public ResponseEntity<Void> deletarLocacao(
        @ApiParam(value = "Id da locação a ser atualizada", required = true)
        @PathVariable("idDispositivo") String idDispositivo
    ) throws Exception {
        dispositivoService.deletar(Long.parseLong(idDispositivo));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
