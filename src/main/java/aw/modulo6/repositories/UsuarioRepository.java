package aw.modulo6.repositories;

import aw.modulo6.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

    @Query(value = "SELECT user_id, nombre, correo_electronico, contrasenia, saldo FROM usuario WHERE correo_electronico = :email", nativeQuery = true)
    UsuarioEntity findByEmail(@Param("email") String email);
}
