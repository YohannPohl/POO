package br.univille.Bmol.sistemaMusica.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_musica;
    private String titulo;
    private String artista;
    private String duracao;

    @ManyToMany(mappedBy = "musicas")
    private List<Playlist> playlists;
}