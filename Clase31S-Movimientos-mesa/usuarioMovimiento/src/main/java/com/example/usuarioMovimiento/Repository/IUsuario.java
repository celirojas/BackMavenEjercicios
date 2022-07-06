package com.example.usuarioMovimiento.Repository;

import com.example.usuarioMovimiento.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario, Long> {

}
