package calculadorasalarioliquido.service;

import calculadorasalarioliquido.model.dto.SalarioLiquidoRequest;
import calculadorasalarioliquido.model.dto.SalarioLiquidoResponse;
import calculadorasalarioliquido.service.retencao.progressivo.inss.INSSService;
import calculadorasalarioliquido.service.retencao.progressivo.irrf.IRRFService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.math.BigDecimal;

@ApplicationScoped
public class SalarioLiquidoService {

    private final INSSService inssService;
    private final IRRFService irrfService;

    @Inject
    public SalarioLiquidoService(INSSService inssService, IRRFService irrfService) {
        this.inssService = inssService;
        this.irrfService = irrfService;
    }

    public SalarioLiquidoResponse calcularSalarioLiquido(SalarioLiquidoRequest salarioLiquidoRequest) {

        BigDecimal baseDeCalculoIRRF = salarioLiquidoRequest.getSalarioBruto();

        BigDecimal retencaoINSS = inssService.calcularValorRetido(salarioLiquidoRequest.getSalarioBruto());
        baseDeCalculoIRRF = baseDeCalculoIRRF.subtract(retencaoINSS);

        BigDecimal deducaoDependentes = salarioLiquidoRequest.getDeducaoDependente().calcularValor();
        baseDeCalculoIRRF = baseDeCalculoIRRF.subtract(deducaoDependentes);

        BigDecimal deducaoPensaoAlimenticia = salarioLiquidoRequest.getPensaoAlimenticiaJudicial().calcularValor();
        baseDeCalculoIRRF = baseDeCalculoIRRF.subtract(deducaoPensaoAlimenticia);

        BigDecimal previdenciaPrivadaPGBL = salarioLiquidoRequest.getPrevidenciaPrivadaPGBL().calcularValor(salarioLiquidoRequest.getSalarioBruto());
        baseDeCalculoIRRF = baseDeCalculoIRRF.subtract(previdenciaPrivadaPGBL);

        BigDecimal retencaoIRRF = irrfService.calcularValorRetido(baseDeCalculoIRRF);

        BigDecimal planoDeSaude = salarioLiquidoRequest.getPlanoDeSaude().calcularValor(salarioLiquidoRequest.getSalarioBruto());

        BigDecimal sindicato = salarioLiquidoRequest.getSindicato().calcularValor(salarioLiquidoRequest.getSalarioBruto());

        BigDecimal valeTransporte = salarioLiquidoRequest.getValeTransporte().calcularValor(salarioLiquidoRequest.getSalarioBruto());

        BigDecimal salarioLiquido = salarioLiquidoRequest.getSalarioBruto()
                .subtract(retencaoINSS)
                .subtract(deducaoPensaoAlimenticia)
                .subtract(previdenciaPrivadaPGBL)
                .subtract(retencaoIRRF)
                .subtract(planoDeSaude)
                .subtract(sindicato)
                .subtract(valeTransporte);

        SalarioLiquidoResponse response = new SalarioLiquidoResponse(
                salarioLiquidoRequest.getSalarioBruto(),
                retencaoINSS,
                deducaoDependentes,
                deducaoPensaoAlimenticia,
                previdenciaPrivadaPGBL,
                retencaoIRRF,
                planoDeSaude,
                sindicato,
                valeTransporte,
                salarioLiquido
        );

        return response;
    }
}
