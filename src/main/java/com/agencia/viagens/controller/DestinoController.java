package com.agencia.viagens.controller;

import com.agencia.viagens.dto.AvaliacaoDTO;
import com.agencia.viagens.dto.DestinoDTO;
import com.agencia.viagens.model.Destino;
import com.agencia.viagens.service.DestinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
@Tag(name = "Destinos Turísticos", description = "Endpoints para gerenciamento do catálogo de viagens")
public class DestinoController {

    private final DestinoService service;

    public DestinoController(DestinoService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo destino")
    public ResponseEntity<Destino> cadastrar(@Valid @RequestBody DestinoDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar todos os destinos")
    public ResponseEntity<List<Destino>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar destino por ID")
    public ResponseEntity<Destino> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/pesquisa")
    @Operation(summary = "Pesquisar destinos por nome ou localização")
    public ResponseEntity<List<Destino>> pesquisar(@RequestParam String termo) {
        return ResponseEntity.ok(service.pesquisar(termo));
    }

    @PostMapping("/{id}/avaliar")
    @Operation(summary = "Avaliar um destino (Nota de 1 a 10)")
    public ResponseEntity<Destino> avaliar(@PathVariable Long id, @Valid @RequestBody AvaliacaoDTO dto) {
        return ResponseEntity.ok(service.avaliar(id, dto.getNota()));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um destino")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}