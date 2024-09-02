import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class FaturamentoSimplificado {

    public static void main(String[] args) {
        String filePath = ".\faturamento.json"; // Nome do arquivo JSON

        try {
            // Ler o arquivo JSON
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Obter o JSON principal
            JSONObject jsonObject = new JSONObject(content);

            // Obter o array de faturamento
            JSONArray faturamentoArray = jsonObject.getJSONArray("faturamento");

            // Inicializa variáveis
            double menorValor = Double.MAX_VALUE;
            double maiorValor = Double.MIN_VALUE;
            double somaValores = 0;
            int diasComFaturamento = 0;

            // Processa os dados de faturamento
            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject item = faturamentoArray.getJSONObject(i);
                double valor = item.getDouble("valor");

                if (valor > 0) {
                    // Atualiza menor e maior valor
                    if (valor < menorValor) {
                        menorValor = valor;
                    }
                    if (valor > maiorValor) {
                        maiorValor = valor;
                    }

                    // Atualiza soma e contador de dias com faturamento
                    somaValores += valor;
                    diasComFaturamento++;
                }
            }

            // Calcula a média de faturamento
            double mediaMensal = diasComFaturamento > 0 ? somaValores / diasComFaturamento : 0;
            int diasAcimaDaMedia = 0;

            // Conta os dias com faturamento superior à média
            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject item = faturamentoArray.getJSONObject(i);
                double valor = item.getDouble("valor");

                if (valor > mediaMensal) {
                    diasAcimaDaMedia++;
                }
            }

            // Exibe os resultados
            System.out.println("Menor valor de faturamento: " + menorValor);
            System.out.println("Maior valor de faturamento: " + maiorValor);
            System.out.println("Número de dias com faturamento superior à média mensal: " + diasAcimaDaMedia);

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
