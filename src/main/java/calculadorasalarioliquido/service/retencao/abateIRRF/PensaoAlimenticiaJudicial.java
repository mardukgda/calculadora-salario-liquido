package calculadorasalarioliquido.service.retencao.abateIRRF;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PensaoAlimenticiaJudicial implements AbateIRRF {

    private BigDecimal valor;

    @Override
    public BigDecimal calcularValor() {
        if(valor != null) {
            return valor.setScale(2, RoundingMode.DOWN);
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
