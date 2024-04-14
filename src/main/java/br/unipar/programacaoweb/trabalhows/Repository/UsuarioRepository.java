package br.unipar.programacaoweb.trabalhows.Repository;

import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless
public class UsuarioRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void UsuarioDAO(EntityManager em, UserTransaction utx) {
        this.em = em;
        this.utx = utx;
    }


    public void cadastrarUsuario(Usuario usuario) throws Exception {
        try {
            em.persist(usuario);
        } catch (Exception ex) {
            throw new Exception("Livro não pode ser cadastrado");
        }
    }

    public List<Usuario> getUsuarios() {
        String jpql = "SELECT l FROM Usuario l";
        return em.createQuery(jpql, Usuario.class).getResultList();
    }

    public void updateUsuario() {
        updateUsuario(null);
    }

    public void updateUsuario(Usuario usuario) {
        try {
            Usuario usuarioAtualizado = em.find(Usuario.class, usuario.getId());
            if (usuarioAtualizado != null) {
                usuarioAtualizado.setNome(usuario.getNome());
                usuarioAtualizado.setIdade(usuario.getIdade());
                em.merge(usuarioAtualizado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void deleteUsuario(Integer id) {
        try {
            Usuario usuario = em.find(Usuario.class, id);
            if (usuario != null) {
                em.remove(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
