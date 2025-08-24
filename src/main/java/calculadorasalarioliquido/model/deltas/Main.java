package calculadorasalarioliquido.model.deltas;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static org.jboss.resteasy.reactive.server.core.parameters.MultipartFormParamExtractor.Type.InputStream;

public class Main {

    public static void main(String[] args) {
        File inputPassado = new File("./src/main/java/calculadorasalarioliquido/deltas/csv/deltas2024.csv");
        int anoPassado = Integer.parseInt(inputPassado.getName().substring(6, 10));
        Map<Integer, BigDecimal> deltasPassado = new HashMap<>();
        BigDecimal va2025 = BigDecimal.valueOf(874.78);
        BigDecimal vr2025 = BigDecimal.valueOf(1110.12);

        try(BufferedReader br = new BufferedReader(new FileReader(inputPassado))){
            String linha = br.readLine();
            while(linha != null && !linha.isEmpty()) {
                String[] campos = linha.split(",");
                Integer nivel = Integer.parseInt(campos[0].trim());
                BigDecimal salario = new BigDecimal(campos[1].trim());
                deltasPassado.put(nivel, salario);
                linha = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Integer nivel : deltasPassado.keySet()) {
            BigDecimal taxa2025 = BigDecimal.valueOf(1.0464);
            BigDecimal salarioCorrigido2025 = deltasPassado.get(nivel).multiply(taxa2025).setScale(0, RoundingMode.CEILING);
            BigDecimal taxa2026 = BigDecimal.valueOf(1.055);
            BigDecimal salarioCorrigido2026 = salarioCorrigido2025.multiply(taxa2026).setScale(0, RoundingMode.CEILING);
            BigDecimal vaCorrigido2026 = va2025.multiply(taxa2026).setScale(2, RoundingMode.HALF_UP);
            BigDecimal vrCorrigido2026 = vr2025.multiply(taxa2026).setScale(2, RoundingMode.HALF_UP);
            StringBuilder sb = new StringBuilder();
            sb.append(nivel);
            sb.append(" ");
            sb.append(deltasPassado.get(nivel).toString());
            sb.append(" [");
            sb.append(salarioCorrigido2025.toString());
            sb.append(" - ");
            sb.append(va2025);
            sb.append(" - ");
            sb.append(vr2025);
            sb.append("] [");
            sb.append(salarioCorrigido2026.toString());
            sb.append(" - ");
            sb.append(vaCorrigido2026);
            sb.append(" - ");
            sb.append(vrCorrigido2026);
            sb.append("]");
            System.out.println(sb.toString());
        }


        int anoAtual = anoPassado + 1;


    }
}
