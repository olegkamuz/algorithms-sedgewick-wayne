public class Main {
    public static void main(String[] args) {
        int[] arr = {3, 56, 30, 213, 7, 4, 9, 324, 10, 2, 8, 5, 1};
        int[] numbers = {56, 56, 11, 8, 0, 33, 2, 16};
        arr = quicksort(arr);
        System.out.print("not in list: ");
        int[] notInList = BinCheck(arr, numbers, "+");
        for(int i = 0; i < notInList.length; i++) {
            System.out.print(notInList[i] + " ");
        }
        int[] inList = BinCheck(arr, numbers, "-");
        System.out.println();
        System.out.print("in list: ");
        for(int i = 0; i < inList.length; i++) {
            System.out.print(inList[i] + " ");
        }
    }

    public static int[] BinCheck(int[] arr, int[] numbers, String inOrNot) {
        int[] list = new int[numbers.length];
        int j = 0;
        for(int i = 0; i < numbers.length; i++) {
            int ttt = rank(numbers[i], arr);
            if(inOrNot.equals("+") && rank(numbers[i], arr) == -1){
                list[j] = numbers[i];
                j++;
            }
            if(inOrNot.equals("-") && rank(numbers[i], arr) > -1){
                list[j] = numbers[i];
                j++;
            }
        }
        int[] returnList = new int[j];
        for(int i = 0; i < j; i++) {
            returnList[i] = list[i];
        }
        return returnList;
    }

    public static int rank(int key, int[] a){
        int indent = 0;
        return rank(key, a, 0, a.length - 1);
    }

    public static int rank(int key, int[] a, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    public static int[] quicksort(int[] a){
        int temp;
        for(int j = 0; j < a.length; j++){
            for(int i = 0; i < a.length; i++){
                if (a[j] < a[i]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}

