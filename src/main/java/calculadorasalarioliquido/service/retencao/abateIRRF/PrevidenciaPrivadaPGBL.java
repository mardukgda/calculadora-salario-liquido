package calculadorasalarioliquido.service.retencao.abateIRRF;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PrevidenciaPrivadaPGBL {

    private BigDecimal porcentagem;
    private final BigDecimal PERCENTUAL_MAXIMO = BigDecimal.valueOf(0.12);

    public BigDecimal calcularValor(BigDecimal baseDeCalculo) {
        if(porcentagem.compareTo(PERCENTUAL_MAXIMO) <= 0) {
            return baseDeCalculo.multiply(porcentagem).setScale(2, RoundingMode.DOWN);
        }
        return baseDeCalculo.multiply(PERCENTUAL_MAXIMO).setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getPorcentagem() {
        return porcentagem;
    }

    public void setPorcentagem(BigDecimal porcentagem) {
        this.porcentagem = porcentagem;
    }
}
