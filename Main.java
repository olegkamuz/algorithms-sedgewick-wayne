public class Main {
    public static void main(String[] args) {
        In in = new In(args[0]);
        String[] whitelist = in.readAllLines();
        for(int i = 0; i < whitelist.length; i++){
            String[] arr = whitelist[i].split(" ");
            System.out.printf("%-14s%-14d%-14d%-14.3f", arr[0], Integer.parseInt(arr[1]), Integer.parseInt(arr[2]), Double.parseDouble(arr[1])/Double.parseDouble(arr[2]));
            System.out.println();
        }
    }
}

