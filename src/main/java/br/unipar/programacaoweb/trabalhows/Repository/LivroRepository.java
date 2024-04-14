package br.unipar.programacaoweb.trabalhows.Repository;

import br.unipar.programacaoweb.trabalhows.Model.Livro;
import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.Comparator;
import java.util.List;

@Stateless
public class LivroRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarLivro(Livro livro) throws Exception {
        try {
            em.persist(livro);
        } catch (Exception ex) {
            throw new Exception("Livro não pode ser cadastrado");
        }
    }

    public List<Livro> getLivros() {
        String jpql = "SELECT l FROM Livro l";
        List<Livro> lista = em.createQuery(jpql, Livro.class).getResultList();
        lista.sort(Comparator.comparing(Livro::getEstou_lendo).reversed());
        return lista;
    }

    public void updateLivro(Livro livro) {
        try {
            Livro livroAtualizado = em.find(Livro.class, livro.getId());
            if (livroAtualizado != null) {
                livroAtualizado.setTitulo(livro.getTitulo());
                livroAtualizado.setArquivo_pdf(livro.getArquivo_pdf());
                livroAtualizado.setAutor(livro.getAutor());
                livroAtualizado.setClasificacao_etaria(livro.getClasificacao_etaria());
                livroAtualizado.setEstante_id(livro.getEstante_id());
                livroAtualizado.setEstou_lendo(livro.getEstou_lendo());
                em.merge(livroAtualizado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteLivro(Integer id) {
        try {
            Livro livro = em.find(Livro.class, id);
            if (livro != null) {
                em.remove(livro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
