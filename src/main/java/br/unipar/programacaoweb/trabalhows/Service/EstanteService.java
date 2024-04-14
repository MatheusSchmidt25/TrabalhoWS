package br.unipar.programacaoweb.trabalhows.Service;

import br.unipar.programacaoweb.trabalhows.Model.Estante;
import br.unipar.programacaoweb.trabalhows.Model.Livro;
import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import br.unipar.programacaoweb.trabalhows.Repository.EstanteRepository;
import br.unipar.programacaoweb.trabalhows.Repository.LivroRepository;
import br.unipar.programacaoweb.trabalhows.Repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class EstanteService {
    @Inject
    private EstanteRepository estanteRepository;

    public void cadastrarEstante(Estante estante) throws Exception {
        estanteRepository.cadastrarEstante(estante);
    }

    public List<Estante> getEstante() {
        return estanteRepository.getEstantes();
    }

}
