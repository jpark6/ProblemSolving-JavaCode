public class Fib {
    public Fib() {

    }

    /**
     *
     * @param len - length
     */
    public void printGoldenRatio(int len) {
        double[] fib_arr = new double[len];

        fib_arr[0] = 1;
        fib_arr[1] = 1;

        for(int i=2; i<len; i++) {
            fib_arr[i] = fib_arr[i-2] + fib_arr[i-1];
            System.out.println(i + ":" + fib_arr[i]/fib_arr[i-1]);
        }

    }
    public static void main(String[] args) {
        Fib fib = new Fib();
        fib.printGoldenRatio(100);
    }
}
