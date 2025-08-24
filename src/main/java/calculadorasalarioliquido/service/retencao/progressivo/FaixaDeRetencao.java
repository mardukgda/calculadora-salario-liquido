package calculadorasalarioliquido.service.retencao.progressivo;

import java.math.BigDecimal;

public class FaixaDeRetencao {

    private BigDecimal limiteInferior;
    private BigDecimal limiteSuperior;
    private BigDecimal aliquota;

    public FaixaDeRetencao(BigDecimal limiteInferior, BigDecimal limiteSuperior, BigDecimal aliquota) {
        this.limiteInferior = limiteInferior;
        this.limiteSuperior = limiteSuperior;
        this.aliquota = aliquota;
    }

    public BigDecimal getLimiteInferior() {
        return limiteInferior;
    }

    public void setLimiteInferior(BigDecimal limiteInferior) {
        this.limiteInferior = limiteInferior;
    }

    public BigDecimal getLimiteSuperior() {
        return limiteSuperior;
    }

    public void setLimiteSuperior(BigDecimal limiteSuperior) {
        this.limiteSuperior = limiteSuperior;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }

    public void setAliquota(BigDecimal aliquota) {
        this.aliquota = aliquota;
    }

    public BigDecimal getAmplitude() {
        return limiteSuperior.subtract(limiteInferior);
    }

    public BigDecimal getDeducaoTotalDaFaixa() {
        return getAmplitude().multiply(aliquota);
    }
}
