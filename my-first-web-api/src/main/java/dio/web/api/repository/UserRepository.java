package dio.web.api.repository;

import dio.web.api.handler.BusinessException;
import dio.web.api.handler.CampoObrigatorioException;
import dio.web.api.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class UserRepository {
    List<Usuario> usuarios = new ArrayList<>(){{
        add(new Usuario(100,"gleyson","password"));
        add(new Usuario(101,"frank","masterpass"));
    }};
    public void deleteById(Integer id){
        System.out.printf("DELETE/id - Recebendo o id: %d para excluir um usuário%n", id);
        System.out.println(id);
    }
    public List<Usuario> findAll(){
        System.out.println("LIST - Listando os usários do sistema");
        return usuarios;
    }
    public Usuario findById(Usuario usuario,Integer id){
        System.out.printf("FIND/id - Recebendo o id '%d' para localizar um usuário%n", id);
        for(Usuario usuario1 : usuarios){
            Integer prox = usuario1.getId();
            if (id.equals(prox)) return usuario1;
        }
        System.out.println("Usuário não existe");
        return usuario;
    }
    public Usuario findByUsername(Usuario usuario,String username) {
        System.out.printf("FIND/username - Recebendo o username '%s' para localizar um usuário%n", username);
        for(Usuario usuario1 : usuarios){
            String prox = usuario1.getLogin();
            if (username.equals(prox)) return usuario1;
        }
        System.out.println("Usuário não existe");
        return usuario;
    }
    public void save(Usuario usuario) {
        if (usuario.getLogin() == null)
            throw new CampoObrigatorioException("login");

        if (usuario.getPassword() == null)
            throw new BusinessException("password");

        if (usuario.getId() == null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
            usuarios.add(usuario);
        }
        else{
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
            usuarios.add(usuario);
        }
        System.out.println(usuario);
    }
}
