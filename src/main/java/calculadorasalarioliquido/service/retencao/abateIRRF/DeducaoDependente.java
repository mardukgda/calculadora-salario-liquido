package calculadorasalarioliquido.service.retencao.abateIRRF;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DeducaoDependente implements AbateIRRF{

    private int quantidadeDependentes;
    private final BigDecimal DEDUCAO_POR_DEPENDENTE = BigDecimal.valueOf(189.59);

    @Override
    public BigDecimal calcularValor() {
        return DEDUCAO_POR_DEPENDENTE.multiply(BigDecimal.valueOf(quantidadeDependentes)).setScale(2, RoundingMode.DOWN);
    }

    public int getQuantidadeDependentes() {
        return quantidadeDependentes;
    }

    public void setQuantidadeDependentes(int quantidadeDependentes) {
        this.quantidadeDependentes = quantidadeDependentes;
    }
}
