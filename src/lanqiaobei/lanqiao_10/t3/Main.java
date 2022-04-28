package lanqiaobei.lanqiao_10.t3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <=900000 ; i++) {

        }

    }
    public static Boolean iszhishu(int number){
        for (int i = 2; i < number; i++) {
            if((number%i)==0){
                return false;
            }
        }
        return true;
    }
}
