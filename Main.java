public class Main {

    public static void main(String[] args) {
        String[][] arrPre = new String[10][10];
        String[][] arrPost = new String[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                arrPre[i][j] = " " + i + j + " ";
                System.out.print(arrPre[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++){
                arrPost[i][j] = arrPre[j][i];
                System.out.print(arrPost[i][j]);
            }
            System.out.println();
        }
    }
}
