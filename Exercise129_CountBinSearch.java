public class Exercise129_CountBinSearch {
    public static void main(String[] args){
        Counter counter = new Counter("binSearch");
        int[] arr = {3,6,23,77,257,23,1,88,34,2,1,7};
        int key = 77;
        CountBinSearch binCounter = new CountBinSearch(key, arr, counter);
        int count = binCounter.count();
        if(count != -1) System.out.println(count);
        else System.out.println("No match");
    }
}

