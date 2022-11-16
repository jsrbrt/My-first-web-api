package dio.web.api.controller;

import dio.web.api.repository.UserRepository;
import dio.web.api.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository repository;
    @GetMapping()
    public List<Usuario> getUsers(){
        return repository.findAll();
    }
    @GetMapping("id/{id}")
    public Usuario getOneById(@PathVariable("id") Integer id){
        return repository.findById(new Usuario(),id);
    }
    @GetMapping("user/{username}")
    public Usuario getOneByUser(@PathVariable("username") String username){
        return repository.findByUsername(new Usuario(),username);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }
    @PostMapping()
    public void postUser(@RequestBody Usuario usuario) { repository.save(usuario);}
    @PutMapping()
    public void putUser(@RequestBody Usuario usuario) { repository.save(usuario);}
}
