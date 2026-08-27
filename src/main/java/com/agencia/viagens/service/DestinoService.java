package com.agencia.viagens.service;

import com.agencia.viagens.dto.DestinoDTO;
import com.agencia.viagens.model.Destino;
import com.agencia.viagens.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DestinoService {

    private final DestinoRepository repository;

    public DestinoService(DestinoRepository repository) {
        this.repository = repository;
    }

    public Destino cadastrar(DestinoDTO dto) {
        Destino destino = new Destino(null, dto.getNome(), dto.getLocalizacao(), dto.getDescricao());
        return repository.salvar(destino);
    }

    public List<Destino> listarTodos() {
        return repository.buscarTodos();
    }

    public List<Destino> pesquisar(String termo) {
        String termoLower = termo.toLowerCase();
        return repository.buscarTodos().stream()
                .filter(d -> d.getNome().toLowerCase().contains(termoLower) ||
                             d.getLocalizacao().toLowerCase().contains(termoLower))
                .collect(Collectors.toList());
    }

    public Destino buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado com ID: " + id));
    }

    public Destino avaliar(Long id, int nota) {
        Destino destino = buscarPorId(id);
        destino.adicionarNota(nota);
        return repository.salvar(destino);
    }

    public void excluir(Long id) {
        buscarPorId(id); // Garante que existe antes de excluir
        repository.deletar(id);
    }
}