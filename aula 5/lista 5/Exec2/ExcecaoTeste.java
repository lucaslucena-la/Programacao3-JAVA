package Exec2;
public class ExcecaoTeste {
    public static void main(String [] args) {

        int[] numeros = {1, 2, 3};
        try{
            System.out.println(numeros [5]); // O que acontece aqui?

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Erro: " + e.getMessage());
        }

        String texto = null;
        try{
            System.out.println(texto.length ()); // E aqui?

        }catch(NullPointerException e){
            System.out.println("Erro: " + e.getMessage());
        }

        int  numerador = 10;
        int denominador = 0;
        try {
            int resultado = numerador/denominador; // E aqui?
        }catch(ArithmeticException e){
            System.out.println("Erro " + e.getMessage());
        }
            
    }   
}