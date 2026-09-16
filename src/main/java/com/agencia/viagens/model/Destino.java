package com.agencia.viagens.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_destino")
public class Destino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String localizacao;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private Double precoMedio;

    private Double mediaAvaliacoes = 0.0;

    @OneToMany(mappedBy = "destino", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Destino() {}

    public Destino(String nome, String localizacao, String descricao, Double precoMedio) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.precoMedio = precoMedio;
    }

    public void adicionarAvaliacao(Avaliacao avaliacao) {
        avaliacao.setDestino(this);
        this.avaliacoes.add(avaliacao);
        recalcularMedia();
    }

    public void recalcularMedia() {
        if (avaliacoes.isEmpty()) {
            this.mediaAvaliacoes = 0.0;
            return;
        }
        double soma = 0;
        for (Avaliacao a : avaliacoes) {
            soma += a.getNota();
        }
        this.mediaAvaliacoes = soma / avaliacoes.size();
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
    public Double getPrecoMedio() { return precoMedio; }
    public void setPrecoMedio(Double precoMedio) { this.precoMedio = precoMedio; }
    public Double getMediaAvaliacoes() { return mediaAvaliacoes; }
    public void setMediaAvaliacoes(Double mediaAvaliacoes) { this.mediaAvaliacoes = mediaAvaliacoes; }
    public List<Avaliacao> getAvaliacoes() { return avaliacoes; }
    public void setAvaliacoes(List<Avaliacao> avaliacoes) { this.avaliacoes = avaliacoes; }
}