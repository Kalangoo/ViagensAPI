package com.agencia.viagens.repository;

import com.agencia.viagens.model.Destino;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DestinoRepository {

    private final Map<Long, Destino> bancoDados = new ConcurrentHashMap<>();
    private final AtomicLong geradorId = new AtomicLong(1);

    public Destino salvar(Destino destino) {
        if (destino.getId() == null) {
            destino.setId(geradorId.getAndIncrement());
        }
        bancoDados.put(destino.getId(), destino);
        return destino;
    }

    public List<Destino> buscarTodos() {
        return new ArrayList<>(bancoDados.values());
    }

    public Optional<Destino> buscarPorId(Long id) {
        return Optional.ofNullable(bancoDados.get(id));
    }

    public boolean deletar(Long id) {
        return bancoDados.remove(id) != null;
    }
}