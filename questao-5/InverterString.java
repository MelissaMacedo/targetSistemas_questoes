import java.util.Scanner;

public class InverterString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicita ao usuário que informe a string
        System.out.print("Digite a string a ser invertida: ");
        String input = scanner.nextLine();
        
        // Chama o método que inverte a string
        String resultado = inverterString(input);
        
        // Imprime a string invertida
        System.out.println("String invertida: " + resultado);
        
        scanner.close();
    }
    
    // Método que inverte os caracteres de uma string
    private static String inverterString(String str) {
        char[] caracteres = str.toCharArray(); // Converte a string em um array de caracteres
        int esquerda = 0;
        int direita = caracteres.length - 1;
        
        // Inverte os caracteres trocando os elementos do array
        while (esquerda < direita) {
            char temp = caracteres[esquerda];
            caracteres[esquerda] = caracteres[direita];
            caracteres[direita] = temp;
            
            esquerda++;
            direita--;
        }
        
        // Converte o array de volta para uma string e retorna
        return new String(caracteres);
    }
}
