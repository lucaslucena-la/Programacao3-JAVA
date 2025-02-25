class PrimeChecker {
    // Método para verificar se um número é primo
    static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

// Cálculo sequencial
class SequentialPrimeSearch {
    static void findPrimes(int start, int end) {
        for (int i = start; i <= end; i++) {
            if (PrimeChecker.isPrime(i)) {
                System.out.println("Primo encontrado (Sequencial): " + i);
            }
        }
    }
}

// Cálculo paralelo usando Thread
class PrimeThread extends Thread {
    private int start, end;

    public PrimeThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public void run() {
        for (int i = start; i <= end; i++) {
            if (PrimeChecker.isPrime(i)) {
                System.out.println("Primo encontrado (Thread " + Thread.currentThread().getName() + "): " + i);
            }
        }
    }
}

// Programa principal
public class MultithreadingExample {
    public static void main(String[] args) {
        int start = 1, end = 1000; // Intervalo para buscar primos

        // Teste Sequencial
        long startTime = System.currentTimeMillis();
        SequentialPrimeSearch.findPrimes(start, end);
        long endTime = System.currentTimeMillis();
        System.out.println("Tempo sequencial: " + (endTime - startTime) + "ms\n");

        // Teste com Multithreading (Dividindo a carga entre 4 threads)
        int numThreads = 4;
        int range = (end - start) / numThreads;

        startTime = System.currentTimeMillis();
        PrimeThread[] threads = new PrimeThread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int rangeStart = start + (i * range);
            int rangeEnd = (i == numThreads - 1) ? end : rangeStart + range;

            threads[i] = new PrimeThread(rangeStart, rangeEnd);
            threads[i].start();
        }

        // Aguarda todas as threads finalizarem
        for (PrimeThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        endTime = System.currentTimeMillis();
        System.out.println("Tempo multithreading: " + (endTime - startTime) + "ms");
    }
}
