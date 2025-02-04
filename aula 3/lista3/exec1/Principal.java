public class Principal {
    public static void main(String[] args) {
        // a) Crie um array de objetos FormaGeometrica contendo instâncias de Circulo e Retangulo
        FormaGeometrica [] formas = new FormaGeometrica[4];
        formas[0] = new Circulo(5.0);
        formas[1] = new Circulo(3.0);
        formas[2] = new Retangulo(4.0, 7.0);
        formas[3] = new Retangulo(6.0, 2.0);

        System.out.println("Informações das formas geométreicas");
        // b) Percorra o array e imprima as informações de cada objeto usando toString()
        for (FormaGeometrica forma : formas){
            System.out.println(forma);
        }

        // c) Calcule e exiba as áreas e perímetros
        System.out.println("\nÁreas e Perímetros: ");
        for(FormaGeometrica forma : formas){
            System.out.printf("Forma: %s\nÁrea: %.2f\nPerímetro: %.2f\n\n",  forma.getClass().getSimpleName(), forma.calcularArea(), forma.calcularPerimetro());
        }


        // d) Crie dois objetos com as mesmas dimensões e compare-os usando equals()

        Circulo circ1 = new Circulo(5.3);
        Circulo circ2 = new Circulo(5.0);
        Retangulo ret1 = new Retangulo(9.0, 4.0);
        Retangulo ret2 = new Retangulo(9.0, 4.0);

        System.out.println("Equals (circ1) com (cric2): " +  circ1.equals(circ2));
        System.out.println("Equals (ret1) com (ret2): " +  ret1.equals(ret2));
        
        // Comparando objetos diferentes
        System.out.println("Equals (circ1) com (ret1): " +  circ1.equals(ret1));


    }

    
}
