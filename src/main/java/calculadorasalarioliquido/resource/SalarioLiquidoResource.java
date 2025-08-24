package calculadorasalarioliquido.resource;

import calculadorasalarioliquido.model.dto.SalarioLiquidoRequest;
import calculadorasalarioliquido.service.SalarioLiquidoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/calculos/salario-liquido")
public class SalarioLiquidoResource {

    private final SalarioLiquidoService salarioLiquidoService;

    @Inject
    public SalarioLiquidoResource(SalarioLiquidoService salarioLiquidoService) {
        this.salarioLiquidoService = salarioLiquidoService;
    }

    @POST
    public Response calcularSalarioLiquido(SalarioLiquidoRequest salarioLiquidoRequest) {
        return Response.ok(salarioLiquidoService.calcularSalarioLiquido(salarioLiquidoRequest)).build();
    }
}
