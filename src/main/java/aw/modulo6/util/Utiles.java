package aw.modulo6.util;

import aw.modulo6.entity.UsuarioEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Utiles {

    public static UsuarioEntity getUser() {
        UsuarioEntity user = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        Object myUser = (auth != null) ? auth.getPrincipal() : null;

        if (myUser instanceof UsuarioEntity) {
            user = (UsuarioEntity) myUser;
        }

        return user;
    }

}
