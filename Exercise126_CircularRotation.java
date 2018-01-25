public class Exercise126_CircularRotation {
    public static void main(String[] args){
        String s = "ACTGACG";
        String t = "TGACGAC";
        System.out.println(isRotation(s, t));
    }
    private static boolean isRotation(String s, String t){
        if (s.length() != t.length()) return false;
        for (int i = 0; i < t.length(); i++) {
            String r = t.substring(i, t.length()).concat(t.substring(0, i));
            if(r.equals(s)) return true;
        }
        return false;
    }
}
