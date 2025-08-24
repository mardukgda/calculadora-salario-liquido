package calculadorasalarioliquido.service.retencao.naoAbateIRRF;

import java.math.BigDecimal;

public interface NaoAbateIRRF {

    BigDecimal calcularValor(BigDecimal baseDeCalculo);
}
