package br.unipar.programacaoweb.trabalhows.Repository;

import br.unipar.programacaoweb.trabalhows.Model.Estante;
import br.unipar.programacaoweb.trabalhows.Model.Livro;
import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.UserTransaction;

import java.util.List;

@Stateless
public class EstanteRepository {
    @PersistenceContext(unitName = "HibernateMaven")
    private EntityManager em;
    private UserTransaction utx;

    public void cadastrarEstante(Estante estante) throws Exception {
        try {
            em.persist(estante);
        } catch (Exception ex) {
            throw new Exception("Estante não pode ser cadastrado");
        }
    }

    public List<Estante> getEstantes() {
        String jpql = "SELECT l FROM Estante l";
        return em.createQuery(jpql, Estante.class).getResultList();
    }
}
