public class Main {

    public static void main(String[] args) {
        assert lg(8) == 3 - 1;
        assert lg(16) == 4 - 1;
        assert lg(128) == 7 - 1;
        System.out.println("Test: OK!");
    }

    public static int lg(int N) {
        int power = 0;
        while(N > 1){
            N /= 2;
            power++;
        }
        return power - 1;
    }
}
