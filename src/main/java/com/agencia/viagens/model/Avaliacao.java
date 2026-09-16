package com.agencia.viagens.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_avaliacao")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer nota; // Nota de 1 a 5

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;

    public Avaliacao() {}

    public Avaliacao(Integer nota, String comentario, Destino destino) {
        this.nota = nota;
        this.comentario = comentario;
        this.destino = destino;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getNota() { return nota; }
    public void setNota(Integer nota) { this.nota = nota; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public Destino getDestino() { return destino; }
    public void setDestino(Destino destino) { this.destino = destino; }
}