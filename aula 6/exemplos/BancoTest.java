public class BancoTest {
    public static void main(String[] args) {
        BankSynch conta = new BankSynch();

        Runnable saque = () -> {
            for (int i = 0; i < 3; i++) {
                conta.sacar(500);
            }
        };

        Thread t1 = new Thread(saque, "Cliente 1");
        Thread t2 = new Thread(saque, "Cliente 2");
        t1.start();
        t2.start();
    }
}

