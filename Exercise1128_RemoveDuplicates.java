public class Exercise1128_RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {3, 56, 30, 213, 56, 4, 4, 324, 10, 2, 8, 5, 2};
        int[] numbers = {56, 56, 11, 8, 0, 33, 2, 16};
        arr = quickSort(arr);
        int needle = 4;
        int countSmaller = rankByExercise(arr, needle);
        int countEqual = count(arr, needle);
        System.out.printf("smaller than key: %d equal: %d", countSmaller, countEqual);
    }

    private static int[] removeDuplicates(int[] whitelist) {
        Helper helper = changeDuplicatesWithMinusOne(whitelist);
        whitelist = helper.whitelist;
        int duplicateCount = helper.duplicateCount;

        int[] noDuplicatesArr = makeNoDuplicatesArr(whitelist, duplicateCount);
        return noDuplicatesArr;
    }

    private static int[] makeNoDuplicatesArr(int[] whitelist, int duplicateCount) {
        int[] noDuplicatesArr;
        int count;
        count = whitelist.length - duplicateCount;
        noDuplicatesArr = new int[count];
        for (int i = 0, j = 0; i < whitelist.length; i++){
            if (whitelist[i] != -1) {
                noDuplicatesArr[j] = whitelist[i];
                j++;
            }
        }

        return noDuplicatesArr;
    }

    private static Helper changeDuplicatesWithMinusOne(int[] whitelist) {
        int duplicateCount = 0;
        for (int i = 0; i < whitelist.length; i++){
            for (int j = 0; j < whitelist.length; j++) {
                if (i != j && whitelist[i] == whitelist[j] && whitelist[i] != -1) {
                    whitelist[j] = -1;
                    duplicateCount++;
                }
            }
        }
        Helper object = new Helper ();
        object.whitelist = whitelist;
        object.duplicateCount = duplicateCount;
        return object;
    }

    private static int[] BinCheck(int[] arr, int[] numbers, String inOrNot) {
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

    private static int rank(int key, int[] a){
        int indent = 0;
        return rank(key, a, 0, a.length - 1);
    }

    private static int rank(int key, int[] a, int lo, int hi){
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }

    private static int[] quickSort(int[] a){
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

    private static int rankByExercise(int[] whitelist, int needle) {
        int count = 0;
        for(int i = 0; i < whitelist.length; i++) {
            if(whitelist[i] < needle) count++;
        }
        return count;
    }

    private static int count(int[] whitelist, int needle) {
        int count = 0;
        for(int i = 0; i < whitelist.length; i++) {
            if(whitelist[i] == needle) count++;
        }
        return count;

    }
}

class Helper {
    int[] whitelist;
    int duplicateCount;
}

