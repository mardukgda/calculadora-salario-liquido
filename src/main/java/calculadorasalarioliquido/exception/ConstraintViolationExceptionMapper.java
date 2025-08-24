package calculadorasalarioliquido.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.List;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        List<Erro> erros = e.getConstraintViolations().stream()
                .map(constraintViolation -> {
                    Erro erro = new Erro();
                    erro.setMensagem(constraintViolation.getMessage() + ": " + constraintViolation.getInvalidValue());
                    return erro;
                }).toList();

        return Response.ok().entity(erros).build();
    }
}
