package br.unipar.programacaoweb.trabalhows.Service;

import br.unipar.programacaoweb.trabalhows.Model.Livro;
import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import br.unipar.programacaoweb.trabalhows.Repository.LivroRepository;
import br.unipar.programacaoweb.trabalhows.Repository.UsuarioRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class LivroService {
    @Inject
    private LivroRepository livroRepository;

    public void cadastrarLivro(Livro livro) throws Exception {
        livroRepository.cadastrarLivro(livro);
    }

    public List<Livro> getLivros() {
        return livroRepository.getLivros();
    }

    public void updateLivro(Livro livro) throws Exception{
        livroRepository.updateLivro(livro);
    }

    public void deleteLivro(Integer id){
        livroRepository.deleteLivro(id);
    }
}
