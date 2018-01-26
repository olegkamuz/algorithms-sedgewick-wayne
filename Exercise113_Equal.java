public class Exercise113_Equal {
    public static void main(String[] args) {
        int one = Integer.parseInt(args[0]);
        int two = Integer.parseInt(args[1]);
        int three = Integer.parseInt(args[2]);
        if (one == two && two == three) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
