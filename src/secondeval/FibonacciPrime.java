package secondeval;

public class FibonacciPrime {
    static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2) return true;
        for(int i = 2; i <= n/2;i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int printedNumbers = 0;
        int currentNumber = 3;
        int previousNumber = 2;
        while(printedNumbers != 10) {
            if(isPrime(currentNumber)) {
                System.out.println(currentNumber);
                printedNumbers++;
            }
            int total = currentNumber + previousNumber;
            previousNumber = currentNumber;
            currentNumber = total;
        }
    }
}
