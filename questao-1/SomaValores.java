public class SomaValores {
    public static void main(String[] args) {
        int indice = 13; // Define até onde a soma vai
        int soma = 0;    // Variável para armazenar o resultado da soma

        // Loop para somar os números de 1 até 13
        for (int k = 1; k <= indice; k++) {
            soma = soma + k; // Adiciona o valor de k à soma
        }

        // Imprime o resultado final da soma
        System.out.println(soma);
    }
}