package calculadorasalarioliquido.model.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.math.BigDecimal;

@RegisterForReflection
public class SalarioLiquidoResponse {
        private BigDecimal salarioBruto;
        private BigDecimal inss;
        private BigDecimal deducaoDependente;
        private BigDecimal pensaoAlimenticiaJudicial;
        private BigDecimal previdenciaPrivadaPGBL;
        private BigDecimal impostoDeRenda;
        private BigDecimal planoDeSaude;
        private BigDecimal sindicato;
        private BigDecimal valeTransporte;
        private BigDecimal salarioLiquido;

        public SalarioLiquidoResponse() {
        }

        public BigDecimal getSalarioBruto() {
                return salarioBruto;
        }

        public void setSalarioBruto(BigDecimal salarioBruto) {
                this.salarioBruto = salarioBruto;
        }

        public BigDecimal getInss() {
                return inss;
        }

        public void setInss(BigDecimal inss) {
                this.inss = inss;
        }

        public BigDecimal getDeducaoDependente() {
                return deducaoDependente;
        }

        public void setDeducaoDependente(BigDecimal deducaoDependente) {
                this.deducaoDependente = deducaoDependente;
        }

        public BigDecimal getPensaoAlimenticiaJudicial() {
                return pensaoAlimenticiaJudicial;
        }

        public void setPensaoAlimenticiaJudicial(BigDecimal pensaoAlimenticiaJudicial) {
                this.pensaoAlimenticiaJudicial = pensaoAlimenticiaJudicial;
        }

        public BigDecimal getPrevidenciaPrivadaPGBL() {
                return previdenciaPrivadaPGBL;
        }

        public void setPrevidenciaPrivadaPGBL(BigDecimal previdenciaPrivadaPGBL) {
                this.previdenciaPrivadaPGBL = previdenciaPrivadaPGBL;
        }

        public BigDecimal getImpostoDeRenda() {
                return impostoDeRenda;
        }

        public void setImpostoDeRenda(BigDecimal impostoDeRenda) {
                this.impostoDeRenda = impostoDeRenda;
        }

        public BigDecimal getPlanoDeSaude() {
                return planoDeSaude;
        }

        public void setPlanoDeSaude(BigDecimal planoDeSaude) {
                this.planoDeSaude = planoDeSaude;
        }

        public BigDecimal getSindicato() {
                return sindicato;
        }

        public void setSindicato(BigDecimal sindicato) {
                this.sindicato = sindicato;
        }

        public BigDecimal getValeTransporte() {
                return valeTransporte;
        }

        public void setValeTransporte(BigDecimal valeTransporte) {
                this.valeTransporte = valeTransporte;
        }

        public BigDecimal getSalarioLiquido() {
                return salarioLiquido;
        }

        public void setSalarioLiquido(BigDecimal salarioLiquido) {
                this.salarioLiquido = salarioLiquido;
        }
}
