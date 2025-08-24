package calculadorasalarioliquido.service.retencao.progressivo.irrf;

import calculadorasalarioliquido.service.retencao.progressivo.FaixaDeRetencao;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class IRRFService {

    private static List<FaixaDeRetencao> faixas;
    private static final int NUMERO_CASAS_DECIMAIS = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.DOWN;

    private void inicializarFaixas() {
        faixas = new ArrayList<>();
        faixas.add(new FaixaDeRetencao(BigDecimal.ZERO, BigDecimal.valueOf(2428.80), BigDecimal.ZERO));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(2428.81), BigDecimal.valueOf(2826.65), BigDecimal.valueOf(0.075)));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(2826.66), BigDecimal.valueOf(3751.05), BigDecimal.valueOf(0.15)));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(3751.06), BigDecimal.valueOf(4664.68), BigDecimal.valueOf(0.225)));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(4664.69), BigDecimal.valueOf(Double.MAX_VALUE), BigDecimal.valueOf(0.275)));
    }

    public BigDecimal calcularValorRetido(BigDecimal valorDeEntrada) {
        if(faixas == null) {
            inicializarFaixas();
        }
        BigDecimal valorTotalRetido = BigDecimal.ZERO;
        BigDecimal valorTributavelRestante = valorDeEntrada;

        for(FaixaDeRetencao faixa : faixas) {
            if(valorTributavelRestante.compareTo(faixa.getAmplitude()) >= 0) {
                BigDecimal valorRetidoNaFaixa = arredondar(faixa.getDeducaoTotalDaFaixa());
                valorTotalRetido = arredondar(valorTotalRetido.add(valorRetidoNaFaixa));
                valorTributavelRestante = arredondar(valorTributavelRestante.subtract(faixa.getAmplitude()));
            } else {
                BigDecimal valorRetidoNaFaixa = arredondar(valorTributavelRestante.multiply(faixa.getAliquota()));
                valorTotalRetido = arredondar(valorTotalRetido.add(valorRetidoNaFaixa));
                break;
            }
        }

        return valorTotalRetido;
    }

    private BigDecimal arredondar(BigDecimal valor) {
        return valor.setScale(NUMERO_CASAS_DECIMAIS, ROUNDING_MODE);
    }
}
