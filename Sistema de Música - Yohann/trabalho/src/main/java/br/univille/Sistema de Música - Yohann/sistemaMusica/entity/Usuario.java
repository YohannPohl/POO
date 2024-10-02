package br.univille.Bmol.sistemaMusica.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_usuario;

    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Playlist> playlists;
}