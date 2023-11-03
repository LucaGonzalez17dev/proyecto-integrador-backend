package com.example.demo.security;

import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioRole;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargarDatosUsuario implements ApplicationRunner {
    private UsuarioRepository usuarioRepository;

    public CargarDatosUsuario (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
        String passCifrada = cifrador.encode("digital");
        Usuario usuario =  new Usuario("Luca", "luca", "luca@gmail.com", passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
        usuario=new Usuario("Luk","luk","luk@gmail.com",
                passCifrada, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario);

    }
}
