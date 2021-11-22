package co.edu.usa.ciclo.cuatro.cuatro.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usa.ciclo.cuatro.cuatro.modelo.Usuario;
import co.edu.usa.ciclo.cuatro.cuatro.repositorio.UsuarioRepositorio;


@Service
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> getAll(){
        return usuarioRepositorio.getAll();
    }

    public Optional<Usuario> getUsuario(int id){
        return usuarioRepositorio.getUser(id);
    }

    public Usuario registrar(Usuario user) {
        if (user.getId() == null) {
            if (existeEmail(user.getEmail()) == false) {
                return usuarioRepositorio.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean existeEmail(String email) {
        return usuarioRepositorio.existeEmail(email);
    }

    public Usuario autenticarUsuario(String email, String password) {
        Optional<Usuario> usuario = usuarioRepositorio.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            //return new Usuario(email,password,"NO DEFINIDO");
            return new Usuario();
        } else {
            return usuario.get();
        }
    }


   
}
