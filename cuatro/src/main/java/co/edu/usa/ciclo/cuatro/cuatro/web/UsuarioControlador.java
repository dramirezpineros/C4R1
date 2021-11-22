package co.edu.usa.ciclo.cuatro.cuatro.web;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usa.ciclo.cuatro.cuatro.modelo.Usuario;
import co.edu.usa.ciclo.cuatro.cuatro.servicio.UsuarioServicio;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/all")
    public List<Usuario> getAll() {
        return usuarioServicio.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario registrar(@RequestBody Usuario user) {
        return usuarioServicio.registrar(user);
    }
    
    @GetMapping("/{email}/{password}")
    public Usuario autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password) {
        return usuarioServicio.autenticarUsuario(email, password);
    }
    
    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email) {
        return usuarioServicio.existeEmail(email);
    }

    
}
