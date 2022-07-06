package com.example.usuarioMovimiento.Service;

import com.example.usuarioMovimiento.Repository.IUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private IUsuario iUsuario;

    public UsuarioService(IUsuario iUsuario) {
        this.iUsuario = iUsuario;
    }


}
