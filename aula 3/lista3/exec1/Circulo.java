public class Circulo extends FormaGeometrica {
    double raio;

    Circulo (double raio){
        this.raio = raio;
    }

    @Override
    public double calcularArea(){
        return Math.PI * (raio * raio);
    }

    @Override
    public double calcularPerimetro(){
        return 2 * Math.PI * raio;

    }

    //getter para raio
    public double getraio(){
        return raio;
    }

    //setter para raio
    public void setRaio(double raio){
        this.raio = raio;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if((obj == null) || getClass() != obj.getClass()){
            return false;
        }

        Circulo circulo = (Circulo) obj;
        return this.raio == circulo.raio;
    }

    @Override
    public String toString(){
        return "Dimensões: {" + "Area: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + "}";
    }

}
