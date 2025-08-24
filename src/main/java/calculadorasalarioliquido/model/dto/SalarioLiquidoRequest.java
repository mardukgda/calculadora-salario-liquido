package calculadorasalarioliquido.model.dto;

import calculadorasalarioliquido.service.retencao.abateIRRF.DeducaoDependente;
import calculadorasalarioliquido.service.retencao.abateIRRF.PensaoAlimenticiaJudicial;
import calculadorasalarioliquido.service.retencao.abateIRRF.PrevidenciaPrivadaPGBL;
import calculadorasalarioliquido.service.retencao.naoAbateIRRF.PlanoDeSaude;
import calculadorasalarioliquido.service.retencao.naoAbateIRRF.Sindicato;
import calculadorasalarioliquido.service.retencao.naoAbateIRRF.ValeTransporte;

import java.math.BigDecimal;

public class SalarioLiquidoRequest {

    private BigDecimal salarioBruto;
    private DeducaoDependente deducaoDependente;
    private PensaoAlimenticiaJudicial pensaoAlimenticiaJudicial;
    private PrevidenciaPrivadaPGBL previdenciaPrivadaPGBL;
    private PlanoDeSaude planoDeSaude;
    private Sindicato sindicato;
    private ValeTransporte valeTransporte;

    public SalarioLiquidoRequest() {
    }

    public BigDecimal getSalarioBruto() {
        return salarioBruto;
    }

    public void setSalarioBruto(BigDecimal salarioBruto) {
        this.salarioBruto = salarioBruto;
    }

    public PrevidenciaPrivadaPGBL getPrevidenciaPrivadaPGBL() {
        return previdenciaPrivadaPGBL;
    }

    public void setPrevidenciaPrivadaPGBL(PrevidenciaPrivadaPGBL previdenciaPrivadaPGBL) {
        this.previdenciaPrivadaPGBL = previdenciaPrivadaPGBL;
    }

    public PensaoAlimenticiaJudicial getPensaoAlimenticiaJudicial() {
        return pensaoAlimenticiaJudicial;
    }

    public void setPensaoAlimenticiaJudicial(PensaoAlimenticiaJudicial pensaoAlimenticiaJudicial) {
        this.pensaoAlimenticiaJudicial = pensaoAlimenticiaJudicial;
    }

    public DeducaoDependente getDeducaoDependente() {
        return deducaoDependente;
    }

    public void setDeducaoDependente(DeducaoDependente deducaoDependente) {
        this.deducaoDependente = deducaoDependente;
    }

    public PlanoDeSaude getPlanoDeSaude() {
        return planoDeSaude;
    }

    public void setPlanoDeSaude(PlanoDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public Sindicato getSindicato() {
        return sindicato;
    }

    public void setSindicato(Sindicato sindicato) {
        this.sindicato = sindicato;
    }

    public ValeTransporte getValeTransporte() {
        return valeTransporte;
    }

    public void setValeTransporte(ValeTransporte valeTransporte) {
        this.valeTransporte = valeTransporte;
    }
}
