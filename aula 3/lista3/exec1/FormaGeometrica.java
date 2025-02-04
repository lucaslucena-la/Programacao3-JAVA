abstract class FormaGeometrica {
    double area;

    // Método abstrato para calcular a área
    abstract double calcularArea();

    //método concreto para retornar o perímetro
    public double calcularPerimetro(){
        double perimetro = 0.0;
        return perimetro;
    }

    // Sobrescrevendo o método toString para exibir informações sobre a forma
    @Override 
    public String toString(){
        return "FormaGeométrica{ " + " Área: " + calcularArea() + ", Perrímetro: " + calcularPerimetro() + " }";
    }

}
