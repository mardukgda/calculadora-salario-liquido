package calculadorasalarioliquido.model.dto;

import java.math.BigDecimal;

public record SalarioLiquidoResponse(
        BigDecimal salarioBruto,
        BigDecimal inss,
        BigDecimal deducaoDependente,
        BigDecimal pensaoAlimenticiaJudicial,
        BigDecimal previdenciaPrivadaPGBL,
        BigDecimal impostoDeRenda,
        BigDecimal planoDeSaude,
        BigDecimal sindicato,
        BigDecimal valeTransporte,
        BigDecimal salarioLiquido
        ) {
}
