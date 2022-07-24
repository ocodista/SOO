package br.unesp.agrotech.resources.v1;

import br.unesp.agrotech.dtos.CategoriaPlantaDTO;
import br.unesp.agrotech.entities.CategoriaPlantaEntity;
import br.unesp.agrotech.services.locacao.v1.CategoriaPlantaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = { "CategoriaPlanta" })
@RestController
@RequestMapping("/categoriaPlanta")
@RequiredArgsConstructor
public class CategoriaPlantaResource {

    private final CategoriaPlantaService categoriaPlantaService;

    @ApiOperation(value = "Este serviço cadastra novas categorias de plantas")
    @PostMapping("/")
    public ResponseEntity<Void> cadastrarCategoriaPlanta(
        @ApiParam(value = "Dados da categoria que será cadastrada", required = true)
        @Valid @RequestBody CategoriaPlantaDTO categoriaPlantaDto
    ) throws Exception {
        categoriaPlantaService.cadastrar(categoriaPlantaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ApiOperation(value = "Este serviço retorna uma lista de categorias de plantas")
    @GetMapping("/")
    public ResponseEntity<List<CategoriaPlantaEntity>> buscarCategoriaPlanta() throws Exception {
        List<CategoriaPlantaEntity> categoriaPlantas = categoriaPlantaService.buscar();
        return ResponseEntity.status(HttpStatus.OK).body(categoriaPlantas);
    }

    @ApiOperation(value = "Este serviço atualiza uma categoria de planta através do id")
    @PutMapping("/{idCategoriaPlanta}")
    public ResponseEntity<CategoriaPlantaEntity> atualizarCategoriaPlanta(
        @ApiParam(value = "Id da categoriaPlanta a ser atualizada", required = true)
        @PathVariable("idCategoriaPlanta") String idCategoriaPlanta,
        @ApiParam(value = "Dados do categoriaPlanta que podem ser atualizados")
        @RequestBody CategoriaPlantaDTO categoriaPlantaDto
    ) throws Exception {
        CategoriaPlantaEntity categoriaPlantaAtualizado = categoriaPlantaService.atualizar(Long.parseLong(idCategoriaPlanta), categoriaPlantaDto);
        return ResponseEntity.status(HttpStatus.OK).body(categoriaPlantaAtualizado);
    }

    @ApiOperation(value = "Este serviço remove uma categoria de planta através do id")
    @DeleteMapping("/{idCategoriaPlanta}")
    public ResponseEntity<Void> deletarCategoriaPlanta(
        @ApiParam(value = "Id da categoriaPlanta a ser removido", required = true)
        @PathVariable("idCategoriaPlanta") String idCategoriaPlanta
    ) throws Exception {
        categoriaPlantaService.deletar(Long.parseLong(idCategoriaPlanta));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
