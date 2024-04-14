package br.unipar.programacaoweb.trabalhows.Controller;

import br.unipar.programacaoweb.trabalhows.Model.Usuario;
import br.unipar.programacaoweb.trabalhows.Service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioController {
    @Inject
    private UsuarioService usuarioService;

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario user) {
        try {
            usuarioService.cadastrarUsuario(user);
            return Response.status(201)
                    .entity("Usuario cadastrado com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        try {
            return Response.ok(usuarioService.getUsuarios())
                    .build();
        } catch (Exception ex) {
            return Response.status(403).entity(ex.getMessage()).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuario(Usuario usuario) {
        try {
            usuarioService.updateUsuario(usuario);
            return Response.status(Response.Status.CREATED)
                    .entity("Usuário atualizado com sucesso")
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
    public Response deleteUsuario(Usuario usuario) {
        try {
            usuarioService.deleteUsuario(usuario.getId());
            return Response.status(Response.Status.OK)
                    .entity("Usuário deletado com sucesso")
                    .build();
        } catch (Exception ex) {
            return Response.status(Response.Status.FORBIDDEN)
                    .entity(ex.getMessage())
                    .build();
        }
    }
}
