package com.agencia.viagens.dto;

public class DestinoDTO {

    private String nome;
    private String localizacao;
    private String descricao;
    private Double precoMedio;

    public DestinoDTO() {}

    public DestinoDTO(String nome, String localizacao, String descricao, Double precoMedio) {
        this.nome = nome;
        this.localizacao = localizacao;
        this.descricao = descricao;
        this.precoMedio = precoMedio;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPrecoMedio() { return precoMedio; }
    public void setPrecoMedio(Double precoMedio) { this.precoMedio = precoMedio; }
}