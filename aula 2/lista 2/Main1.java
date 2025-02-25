class Car{
    private String marca;
    private String modelo;
    private int ano;

    Car(String marca, String modelo, int ano ){
        this.marca = marca;
        this.modelo =  modelo;
        this.ano = ano;
    }

    Car(String marca, String modelo){
        this.marca = marca;
        this.modelo = modelo;
        ano = 2000 ;
    }

    Car(){
        marca = "padrão";
        modelo = "padrão";
        ano = 0000;
    }

    void exibirDetalhes(){
        System.out.println("Marca: " + marca + " Modelo: " + modelo + " Ano: "+ ano);
        
    }
    //construtor de cópia 
    public Car ( Car outroCar){
        this.marca = outroCar.marca;
        this.modelo = outroCar.modelo;
        this.ano = outroCar.ano;
    }


    String getMarca (){
        return marca;
    }
    String getModelo (){
        return modelo;
    }
    int getAno (){
        return ano;
    }
}

class Garage{
    
    private int count = 0;
    private int countVW = 0;
    private int countFord = 0;
    private Car [] carros;

    //construtor da garagem
    public Garage(int capacidade){
        carros = new Car[capacidade];
        count = 0;
        countFord = 0;
        countVW = 0;
    }

    public void adicionarCarro(Car carro){
        if( count < carros.length){
            carros[count] = carro;

            if(carro.getMarca() == "VW"){
                countVW++;
            }else if(carro.getMarca() == "Ford"){
                countFord++;
            }
            count ++;
        }else{
            System.out.println("Coleção de carros está cheia");
        }
    }

    public void exibirCarros(){
        System.out.println("Detalhes de todos os carros armazenados:");
        for (int i = 0; i < carros.length; i++){
            carros[i].exibirDetalhes();
        }
    }

    public void exibirContagens(){
        System.out.println("Total de carros: "+ count);
        System.out.println("Carros ford: " + countFord);
        System.out.println("Carros VW: " + countVW);
    }    
    
}


public class Main1 {
    public static void main(String[] args) {
        // Cria alguns carros usando os diferentes construtores
        Car carro1 = new Car("VW", "Gol", 2020);
        Car carro2 = new Car("Ford", "Fiesta", 2018);
        Car carro3 = new Car("Honda", "Civic", 2022);
        Car carro4 = new Car("Ford", "Fusion");

        // Cria uma garagem com capacidade para 5 carros
        Garage garagem = new Garage(5);

        // Adiciona os carros à garagem
        garagem.adicionarCarro(carro1);
        garagem.adicionarCarro(carro2);
        garagem.adicionarCarro(carro3);
        garagem.adicionarCarro(carro4);

        // Cria um novo carro a partir de um carro existente usando o construtor de cópia
        Car carroCopia = new Car(carro1);

        // Adiciona o carro copiado à garagem
        garagem.adicionarCarro(carroCopia);

        // Exibe a contagem e os detalhes de todos os carros na garagem
        garagem.exibirCarros();
        garagem.exibirContagens();
    }
}