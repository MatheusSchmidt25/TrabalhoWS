package br.unipar.programacaoweb.trabalhows.Service;

import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import br.unipar.programacaoweb.trabalhows.Repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;
    public void cadastrarUsuario(Usuario user) throws Exception {
        usuarioRepository.cadastrarUsuario(user);
    }

    public List<Usuario> getUsuarios(){
        return  usuarioRepository.getUsuarios();
    }

    public  void updateUsuario(Usuario user ){
        usuarioRepository.updateUsuario(user);
    }

    public void deleteUsuario(Integer id){
        usuarioRepository.deleteUsuario(id);
    }


}
