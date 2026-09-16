package com.agencia.viagens.service;

import com.agencia.viagens.dto.DestinoDTO;
import com.agencia.viagens.model.Avaliacao;
import com.agencia.viagens.model.Destino;
import com.agencia.viagens.repository.DestinoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository repository;

    public DestinoService(DestinoRepository repository) {
        this.repository = repository;
    }

    public Destino cadastrar(DestinoDTO dto) {
        Destino destino = new Destino(dto.getNome(), dto.getLocalizacao(), dto.getDescricao(), dto.getPrecoMedio());
        return repository.save(destino);
    }

    public List<Destino> listarTodos() {
        return repository.findAll();
    }

    public List<Destino> pesquisar(String termo) {
        if (termo == null || termo.isBlank()) {
            return repository.findAll();
        }
        return repository.findByNomeContainingIgnoreCaseOrLocalizacaoContainingIgnoreCase(termo, termo);
    }

    public Destino buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destino não encontrado com ID: " + id));
    }

    public Destino atualizar(Long id, DestinoDTO dto) {
        Destino destino = buscarPorId(id);
        destino.setNome(dto.getNome());
        destino.setLocalizacao(dto.getLocalizacao());
        destino.setDescricao(dto.getDescricao());
        destino.setPrecoMedio(dto.getPrecoMedio());
        return repository.save(destino);
    }

    public Destino avaliar(Long id, Integer nota, String comentario) {
        if (nota == null || nota < 1 || nota > 5) {
            throw new IllegalArgumentException("A nota deve ser entre 1 e 5.");
        }

        Destino destino = buscarPorId(id);
        Avaliacao avaliacao = new Avaliacao(nota, comentario, destino);
        destino.adicionarAvaliacao(avaliacao);
        return repository.save(destino);
    }

    public void excluir(Long id) {
        Destino destino = buscarPorId(id);
        repository.delete(destino);
    }
}