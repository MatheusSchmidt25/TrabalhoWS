package br.unipar.programacaoweb.trabalhows.Controller;
import br.unipar.programacaoweb.trabalhows.Model.Estante;
import br.unipar.programacaoweb.trabalhows.Model.Livro;
import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import br.unipar.programacaoweb.trabalhows.Service.EstanteService;
import br.unipar.programacaoweb.trabalhows.Service.LivroService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/estante")
public class EstanteController {
    @Inject
    private EstanteService estanteService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarEstante(Estante estante) {
        try {
            estanteService.cadastrarEstante(estante);
            return Response.status(201).entity("Estante Cadastrada com sucesso").build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getEstantes() {
        try {
            return Response.ok(estanteService.getEstante())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }


}
