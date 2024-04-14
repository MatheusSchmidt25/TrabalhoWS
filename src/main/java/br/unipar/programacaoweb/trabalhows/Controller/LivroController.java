package br.unipar.programacaoweb.trabalhows.Controller;

import br.unipar.programacaoweb.trabalhows.Model.Livro;
import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import br.unipar.programacaoweb.trabalhows.Service.LivroService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/livro")
public class LivroController {
    @Inject
    private LivroService livroService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarLivro(Livro livro) {
        try {
            livroService.cadastrarLivro(livro);
            return Response.status(201).entity("Livro cadastrado com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getLivros() {
        try {
            return Response.ok(livroService.getLivros())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateLivro(Livro livro) {
        try {
            livroService.updateLivro(livro);
            return Response.status(Response.Status.CREATED)
                    .entity("Livro atualizado com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(ex.getMessage())
                    .build();
        }
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteLivro(Livro livro) {
        try {
            livroService.deleteLivro(livro.getId());
            return Response.status(Response.Status.OK)
                    .entity("Livro deletado com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(ex.getMessage())
                    .build();
        }
    }

}
