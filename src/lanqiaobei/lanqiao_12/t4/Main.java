package lanqiaobei.lanqiao_12.t4;

public class Main {
    public static void main(String[] args) {
        System.out.println(gcd(6, 4));
    }
    static int gcd(int a, int b) {
        if(b==0){
            return a;
        }
        int c = gcd(b,a%b);
        return c;
    }
}
