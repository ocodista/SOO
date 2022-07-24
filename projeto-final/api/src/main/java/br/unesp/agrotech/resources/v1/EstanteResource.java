package br.unesp.agrotech.resources.v1;

import java.util.*;

import javax.validation.Valid;

import br.unesp.agrotech.dtos.*;
import br.unesp.agrotech.entities.EstanteEntity;
import br.unesp.agrotech.entities.PrateleiraEntity;
import br.unesp.agrotech.services.locacao.v1.EstanteService;

import br.unesp.agrotech.services.locacao.v1.NichoService;
import br.unesp.agrotech.services.locacao.v1.PrateleiraService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class EstanteResource {
    private static Logger logger = LogManager.getLogger(EstanteResource.class.toString());
    private final ModelMapper modelMapper;
    private final EstanteService estanteService;
    private final PrateleiraService prateleiraService;
    private final NichoService nichoService;

    private void criaNichos(Long estanteId, Long prateleiraId, int nichos) throws Exception {
        for(int j = 0; j < nichos; j++) {
            int posicaoHorizontal = j + 1;

            logger.info("Criando nicho " + posicaoHorizontal + " da estante " + estanteId + " prateleira " + prateleiraId);
            NichoDTO novoNicho = new NichoDTO(0L, posicaoHorizontal, prateleiraId, new HashSet<>(), new HashSet<>());
            Long nichoId = nichoService.cadastrar(novoNicho);
            logger.info("Nicho ID " + nichoId + " criado com sucesso!");
        }
    }

    private Long criaPrateleira(Long estanteId, int posicaoVertical) throws Exception {
        logger.info("Criando prateleira " + posicaoVertical + " da estante " + estanteId);
        PrateleiraDTO novaPrateleira = new PrateleiraDTO(0L, posicaoVertical, estanteId, new HashSet<>());
        Long prateleiraId = prateleiraService.cadastrar(novaPrateleira);
        logger.info("Prateleira ID " + prateleiraId + " criada com sucesso!");
        return prateleiraId;
    }

    private void populaEstante(Long estanteId, int prateleiras, int nichosPorPrateleiras) throws Exception {
        for (int i = 0; i < prateleiras; i++) {
            int posicaoVertical = i + 1;
            Long prateleiraId = criaPrateleira(estanteId, posicaoVertical);
            criaNichos(estanteId, prateleiraId, nichosPorPrateleiras);
        }
    }
    @ApiOperation(value = "Este serviço cadastra novas estantes")
    @PostMapping("/")
    public ResponseEntity<Long> cadastrarEstante(
        @ApiParam(value = "Dados da estante que será cadastrada", required = true)
        @Valid @RequestBody CreateEstanteDTO createEstanteDTO
    ) throws Exception {
        try {
            Long estanteId = estanteService.cadastrar(createEstanteDTO);
            logger.info("Estante " + estanteId + " criada com sucesso!");

            int prateleiras = createEstanteDTO.getQtdPrateleiras();
            int nichosPorPrateleira = createEstanteDTO.getQtdNichosPorPrateleira();
            populaEstante(estanteId, prateleiras, nichosPorPrateleira);
            return ResponseEntity.status(HttpStatus.CREATED).body(estanteId);
        } catch (Exception e) {
            logger.error("Erro ao criar estante!\n" + e.toString());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(0L);
        }
    }

    @ApiOperation(value = "Este serviço retorna uma lista de estantes")
    @GetMapping("/")
    public ResponseEntity<List<GetEstanteDto>> buscarEstantes() throws Exception {
        List<EstanteEntity> listEstante = estanteService.buscar();
        List<GetEstanteDto> estantesPopuladas = new ArrayList<>();
        for(EstanteEntity estante:listEstante) {
            estantesPopuladas.add(estanteEntityPopulada(estante));
        }

        return ResponseEntity.status(HttpStatus.OK).body(estantesPopuladas);
    }

    private GetEstanteDto estanteEntityPopulada(EstanteEntity estante) throws Exception {
        // Popula estante
        GetEstanteDto dto = new GetEstanteDto();
        modelMapper.map(estante, dto);

        // Popula prateleiras
        Long idEstante = estante.getId();
        List<PrateleiraEntity> prateleiras = prateleiraService.buscarPorEstante(idEstante);
        List<PrateleiraDTO> mappedPrateleiras = Arrays.asList(modelMapper.map(prateleiras, PrateleiraDTO[].class));
        modelMapper.map(prateleiras, mappedPrateleiras);
        dto.setPrateleiras(new HashSet<PrateleiraDTO>(mappedPrateleiras));
        return dto;
    }

    @ApiOperation(value = "Este serviço retorna uma determinada estante")
    @GetMapping("/{idEstante}")
    public ResponseEntity<GetEstanteDto> atualizarEstante(
        @ApiParam(value = "Id da estante a ser atualizada", required = true)
        @PathVariable("idEstante") Long idEstante
    ) throws Exception {
        EstanteEntity estante = estanteService.buscarPorId(idEstante);
        GetEstanteDto dto = estanteEntityPopulada(estante);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
    @ApiOperation(value = "Este serviço atualiza uma estante através do id")
    @PutMapping("/{idEstante}")
    public ResponseEntity<EstanteEntity> atualizarEstante(
        @ApiParam(value = "Id da estante a ser atualizada", required = true)
        @PathVariable("idEstante") String idEstante,
        @ApiParam(value = "Dados da estante que podem ser atualizados")
        @RequestBody CreateEstanteDTO createEstanteDTO
    ) throws Exception {
        EstanteEntity estanteAtualizada = estanteService.atualizar(Long.parseLong(idEstante), createEstanteDTO);
        return ResponseEntity.status(HttpStatus.OK).body(estanteAtualizada);
    }

    @ApiOperation(value = "Este serviço remove uma estante através do id")
    @DeleteMapping("/{idEstante}")
    public ResponseEntity<Void> deletarEstante(
        @ApiParam(value = "Id da estante a ser removida", required = true)
        @PathVariable("idEstante") String idEstante
    ) throws Exception {
        estanteService.deletar(Long.parseLong(idEstante));
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
