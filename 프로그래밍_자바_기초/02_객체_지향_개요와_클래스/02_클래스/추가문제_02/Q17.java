class PrimeCache {
    private static int[] primes = new int[10];

    static {
        int count = 0;
        int num = 2;
        while (count < 10) {
            boolean isPrime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes[count++] = num;
            }
            num++;
        }
    }

    static int get(int index) {
        return primes[index];
    }

    static void printAll() {
        for (int i = 0; i < primes.length; i++) {
            System.out.print(primes[i]);
            if (i < primes.length - 1) System.out.print(" ");
        }
        System.out.println();
    }
}

public class Q17 {
    public static void main(String[] args) {
        PrimeCache.printAll();
        System.out.println("5번째 소수: " + PrimeCache.get(4));
    }
}
