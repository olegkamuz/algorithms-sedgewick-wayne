public class FindEqualPairs {
    public static int[] FindEqualPairsNumber(int[] a) {
        int count = 0;
        for(int i = 1; i < a.length; i++){
           int compared = a[i];
           if (compared != a[i-1]) {
               if (count > 0) {
                   System.out.println("");
               }
              count = 0;
           } else {
               count++;
           }
        }
        return a;
    }
}
