package lanqiaobei.lanqiao_10.t2;

public class Main {
    public static void main(String[] args) {
        String s = "LANQIAO";
        System.out.println(getNumber(s));
    }
    private static long getNumber(String s){
        int length = s.length();
        long number = 0;
        for (int i = 0; i < s.length(); i++) {
            int degree = length - i - 1;
            long weifen = 1;
            for (int j = 0; j < degree; j++) {
                weifen*=26;
            }
            number+=(s.charAt(i)-'A'+1)*weifen;
        }
        return number;
    }
}
