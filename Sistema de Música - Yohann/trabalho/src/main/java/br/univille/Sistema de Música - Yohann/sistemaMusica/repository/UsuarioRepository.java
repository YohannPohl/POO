package br.univille.Bmol.sistemaMusica.repository;

import br.univille.Bmol.sistemaMusica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}