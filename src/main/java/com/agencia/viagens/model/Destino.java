package com.agencia.viagens.model;

import java.util.ArrayList;
import java.util.List;

public class Destino {

    private Long id;
    private String nome;
    private String localizacao;
    private String descricao;
    private Double mediaAvaliacao = 0.0;
    private List<Integer> notas = new ArrayList<>();

    public Destino() {}

    public Destino(Long id, String nome, String localizacao, String descricao) {
        this.id = id;
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
    }

public void adicionarNota(int nota) {
    this.notas.add(nota);
    this.mediaAvaliacao = notas.stream()
            .mapToInt(n -> n)
            .average()
            .orElse(0.0);
}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getMediaAvaliacao() { return mediaAvaliacao; }
    public List<Integer> getNotas() { return notas; }
}