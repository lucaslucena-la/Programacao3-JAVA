package Exec5;

// Crie um programa que:
// 1. Contenha duas exce ̧coes personalizadas: LoginInvalidoException e ContaBloqueadaException,
// ambas derivadas de Exception.
// 2. Simule um sistema de login onde:
// •Um usu ́ario insere um login e senha.
// •Se o login for incorreto, dispare LoginInvalidoException.
// •Se o usu ́ario errar trˆes vezes seguidas, dispare ContaBloqueadaException.
// 3. O programa deve capturar e exibir mensagens de erro apropriadas.

import java.util.Scanner;

class LoginInvalidoException extends Exception{
    public LoginInvalidoException(String mensagem){
        super("Login inválido");
    }
}

class ContaBloqueadaException extends Exception{
    public ContaBloqueadaException(String mensagem){
        super(  "Conta bloqueada");
    }
}

public class Hierarquia {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String login = "admin";
        String senha = "admin";

        int tentativas= 0;

        
        while(tentativas < 3){
            try{
                System.out.println("Login: ");
                String LoginUsurario = scanner.nextLine();
                System.out.println("Login: ");
                String SenhaUsuario = scanner.nextLine();

                if (login.equals(LoginUsurario) && senha.equals(SenhaUsuario)){
                    System.out.println("Login efetuado com sucesso!");
                    break;
                }else{
                    throw new LoginInvalidoException("Login inválido");
                }
            }catch(LoginInvalidoException e){
                System.out.println("Erro: " + e.getMessage());
            }

            tentativas++;

        }

        if(tentativas == 3){
            try{
                throw new ContaBloqueadaException("Conta bloqueada");
            }catch(ContaBloqueadaException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}


