public class BancoDeDados {
    private static BancoDeDados instancia;

    private BancoDeDados() {} // Construtor privado

    public static synchronized BancoDeDados getInstance() {
        if (instancia == null) {
            instancia = new BancoDeDados();
        }
        return instancia;
    }
}
