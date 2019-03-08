public class FourSum {
    public int[] arr;
    private int count = 0;
    FourSum(int[] arr) {
        this.arr = arr;
        count();
    }
    public int count() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int m = k + 1; m < arr.length; m++) {
                        if (arr[i] + arr[j] + arr[k] + arr[m] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
       return arr.length;
    }
    public void printAmount(){
        System.out.println(count);
    }
}
