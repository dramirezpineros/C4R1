package co.edu.usa.ciclo.cuatro.cuatro.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.usa.ciclo.cuatro.cuatro.modelo.Usuario;
import co.edu.usa.ciclo.cuatro.cuatro.repositorio.crud.UsuarioCRUDRepositorio;

@Repository
public class UsuarioRepositorio {

    @Autowired
    private UsuarioCRUDRepositorio usuarioCRUDRepositorio;

    public List<Usuario> getAll(){
        return (List<Usuario>)usuarioCRUDRepositorio.findAll();
    }

    public Optional<Usuario> getUser(int id){
        return usuarioCRUDRepositorio.findById(id);
    }

    public Usuario save(Usuario usuario){
        return usuarioCRUDRepositorio.save(usuario);
    }

    public boolean existeEmail(String email){
        Optional<Usuario> usuario= usuarioCRUDRepositorio.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<Usuario> autenticarUsuario(String email, String password){
        
        return usuarioCRUDRepositorio.findByEmailAndPassword(email, password);
    }
    
}
