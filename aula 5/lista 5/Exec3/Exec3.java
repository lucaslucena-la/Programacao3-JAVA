package Exec3;
// Crie um programa que peça ao usuario para inserir dois n ́umeros e exiba o resultado da divis ̃ao entre eles. O programa deve:
// 1. Tratar a divisao por zero (ArithmeticException).
// 2. Tratar entradas nao esperadas pelo Scanner (InputMismatchException).
// 3. Exibir uma mensagem final informando que a execucao foi concluıda.


import java.util.InputMismatchException;
import java.util.Scanner;

public class Exec3 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Digite o numerador:");
            int numerador = scanner.nextInt();
            System.out.println("Digite o denominador");
            int denominador = scanner.nextInt();
            int resultado = numerador/denominador;
            System.out.println("Resultado da divisão: " + resultado);

        }catch (ArithmeticException e){
            System.out.println(("Erro:" + e.getMessage()));
        }catch(InputMismatchException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            System.out.println("Execução concluída.");
        }
        
    }
}
