package co.edu.usa.ciclo.cuatro.cuatro.repositorio.crud;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import co.edu.usa.ciclo.cuatro.cuatro.modelo.Usuario;

public interface UsuarioCRUDRepositorio extends CrudRepository<Usuario,Integer>{

    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByEmailAndPassword(String email, String password);
    
}
