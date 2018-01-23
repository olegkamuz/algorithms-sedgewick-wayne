public class Test
{
    private String a;
    public Test(String a){
        this.a = a;
    }
    public String getA(){
        return this.a;
    }
    public static void main(String[] args){
        Test[] a = new Test[2];
//        a[0] = new Test("abracadabra");
        System.out.println(a[0]);
    }
}


