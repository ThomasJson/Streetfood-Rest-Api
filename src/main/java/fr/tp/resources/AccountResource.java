package fr.tp.resources;

import fr.tp.dto.AccountDto;
import fr.tp.services.AccountService;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@Path("/account")
public class AccountResource {

    @Inject
    AccountService accountService;

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GET
    @Path("/{id}")
    @RolesAllowed({"Admin","User"})
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccountById(@PathParam("id") UUID id) {
        AccountDto accountDto = accountService.getAccountById(id);
        if (accountDto != null) {
            return Response.ok(accountDto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Account not found").build();
        }
    }
}