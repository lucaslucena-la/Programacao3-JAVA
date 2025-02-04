public class Retangulo extends FormaGeometrica{
    double base;
    double altura;

    Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea(){
        return base * altura;
    }

    @Override
    public double calcularPerimetro(){
        return 2 * (base + altura);
    }

    public double getAltura(){
        return altura;
    } 
    
    public double getBase(){
        return base;
    } 

    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public void setBase(double base){
        this.base = base;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }

        if((this == null) || getClass() != obj.getClass()){
            return false;
        }

        Retangulo retangulo = (Retangulo) obj;
        return this.altura == retangulo.altura && this.base == retangulo.base;
    
    }

    @Override 
    public String toString(){
        return "Dimensões: {" + "Area: " + calcularArea() + ", Perímetro: " + calcularPerimetro() + "}";
    }


}
