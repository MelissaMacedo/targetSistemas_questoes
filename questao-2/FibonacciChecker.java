import java.util.Scanner;

public class FibonacciChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite um número para verificar se ele pertence à sequência de Fibonacci: ");
        int numero = scanner.nextInt();
        
        // Verifica se o número pertence à sequência de Fibonacci
        if (pertenceFibonacci(numero)) {
            System.out.println(numero + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println(numero + " não pertence à sequência de Fibonacci.");
        }
        
        scanner.close();
    }
    
    // Método que verifica se um número pertence à sequência de Fibonacci
    private static boolean pertenceFibonacci(int num) {
        if (num < 0) return false; 

        int a = 0, b = 1;
        while (a < num) {
            int temp = a;
            a = b;
            b = temp + b;
        }
        
        return a == num;
    }
}
