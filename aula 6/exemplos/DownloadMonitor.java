class DownloadFile extends Thread {
    public void run() {
        try {
            System.out.println("Baixando arquivo...");
            Thread.sleep(5000); // Simula tempo de download
            System.out.println("Download concluído!");
        } catch (InterruptedException e) {}
    }
}

public class DownloadMonitor {
    public static void main(String[] args) {
        DownloadFile download = new DownloadFile();
        download.start();

        while (download.isAlive()) {
            System.out.println("Aguardando download...");
            try { Thread.sleep(1000); } catch (InterruptedException e) {}
        }

        System.out.println("Arquivo pronto para uso.");
    }
}
