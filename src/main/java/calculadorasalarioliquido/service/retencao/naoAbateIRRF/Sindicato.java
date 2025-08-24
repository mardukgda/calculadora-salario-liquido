package calculadorasalarioliquido.service.retencao.naoAbateIRRF;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Sindicato implements NaoAbateIRRF {
    private BigDecimal percentual;

    @Override
    public BigDecimal calcularValor(BigDecimal baseDeCalculo) {
        return percentual.multiply(baseDeCalculo).setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }
}
