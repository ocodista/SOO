package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.dtos.CategoriaDispositivoDTO;
import br.unesp.agrotech.entities.CategoriaDispositivoEntity;
import br.unesp.agrotech.services.locacao.v1.CategoriaDispositivoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = { "CategoriaDispositivo" })
@RestController
@RequestMapping("/categoriaDispositivo")
@RequiredArgsConstructor
public class CategoriaDispositivoResource {

    private final CategoriaDispositivoService categoriaDispositivoService;

    @ApiOperation(value = "Este serviço cadastra novas categorias de dispositivos")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarCategoriaDispositivo(
        @ApiParam(value = "Dados da categoria que será cadastrada", required = true)
        @Valid @RequestBody CategoriaDispositivoDTO categoriaDispositivoDto
    ) throws Exception {
        categoriaDispositivoService.cadastrar(categoriaDispositivoDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de categorias de dispositivos")
    @GetMapping("/")
    public ResponseEntity<List<CategoriaDispositivoEntity>> buscarCategoriaDispositivo() throws Exception {
        List<CategoriaDispositivoEntity> categoriaDispositivos = categoriaDispositivoService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDispositivos);
    }

    @ApiOperation(value = "Este serviço atualiza uma categoria de dispositivo através do id")
    @PutMapping("/{idCategoriaDispositivo}")
    public ResponseEntity<CategoriaDispositivoEntity> atualizarCategoriaDispositivo(
        @ApiParam(value = "Id do categoriaDispositivo a ser atualizada", required = true)
        @PathVariable("idCategoriaDispositivo") String idCategoriaDispositivo,
        @ApiParam(value = "Dados do categoriaDispositivo que podem ser atualizados")
        @RequestBody CategoriaDispositivoDTO categoriaDispositivoDto
    ) throws Exception {
        CategoriaDispositivoEntity categoriaDispositivoAtualizado = categoriaDispositivoService.atualizar(Long.parseLong(idCategoriaDispositivo), categoriaDispositivoDto);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaDispositivoAtualizado);
    }

    @ApiOperation(value = "Este serviço remove uma categoria de dispositivo através do id")
    @DeleteMapping("/{idCategoriaDispositivo}")
    public ResponseEntity<Void> deletarCategoriaDispositivo(
        @ApiParam(value = "Id do categoriaDispositivo a ser removido", required = true)
        @PathVariable("idCategoriaDispositivo") String idCategoriaDispositivo
    ) throws Exception {
        categoriaDispositivoService.deletar(Long.parseLong(idCategoriaDispositivo));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
