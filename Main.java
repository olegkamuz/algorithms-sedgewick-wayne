public class Main {

    public static void main(String[] args) {
        String[][] arr = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (StdRandom.bernoulli(0.5)) arr[i][j] = "" + i + j +"|*";
                else arr[i][j] = "" + i + j + "| ";
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
