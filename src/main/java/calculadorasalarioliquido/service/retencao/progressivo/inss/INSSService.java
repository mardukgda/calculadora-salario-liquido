package calculadorasalarioliquido.service.retencao.progressivo.inss;

import calculadorasalarioliquido.service.retencao.progressivo.FaixaDeRetencao;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class INSSService {

    private static List<FaixaDeRetencao> faixas;
    private static final int NUMERO_CASAS_DECIMAIS = 2;
    private static final RoundingMode ROUNDING_MODE = RoundingMode.DOWN;

    private void inicializarFaixas() {
        faixas = new ArrayList<>();
        faixas.add(new FaixaDeRetencao(BigDecimal.ZERO, BigDecimal.valueOf(1518.00), BigDecimal.valueOf(0.075)));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(1518.01), BigDecimal.valueOf(2793.88), BigDecimal.valueOf(0.09)));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(2793.89), BigDecimal.valueOf(4190.83), BigDecimal.valueOf(0.12)));
        faixas.add(new FaixaDeRetencao(BigDecimal.valueOf(4190.84), BigDecimal.valueOf(8157.41), BigDecimal.valueOf(0.14)));
    }

    public BigDecimal calcularValorRetido(BigDecimal valorDeEntrada) {
        if(faixas == null) {
            inicializarFaixas();
        }
        BigDecimal valorTotalRetido = BigDecimal.ZERO;
        BigDecimal valorTributavelRestante = BigDecimal.valueOf(valorDeEntrada.doubleValue());

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
