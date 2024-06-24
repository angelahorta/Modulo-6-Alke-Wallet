package aw.modulo6.service.Impl;

import aw.modulo6.entity.UsuarioEntity;
import aw.modulo6.repositories.UsuarioRepository;
import aw.modulo6.service.UsuarioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UsuarioEntity user = usuarioRepository.findByEmail(email);

        if(user == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("USER")));
        return user;

    }
}
