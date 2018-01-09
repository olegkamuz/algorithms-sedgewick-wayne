public class Main {

    public static void main(String[] args) {
        String s = "";
        for (int n = 6; n > 0; n /= 2)
            s = (n % 2) + s;
        System.out.println(s);
    }
}
