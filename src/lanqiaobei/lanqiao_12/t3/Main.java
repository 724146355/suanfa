package lanqiaobei.lanqiao_12.t3;

import java.util.*;
//涉及的知识点：因为数据是通过除法获取的，哪怕使用的是Double类型，也是存不准的，所以只能使用分数进行存储k和B，，而且要保存的是最简分数
//以kup+" “+Kdown+” “+bup+” "+bdown的字符串形式将直线存入HashSet。没有斜率的直线用x=n的形式存储
//斜率不存在的情况要单独考虑，
//把坐标存入容器ArrayList中，形式是x*100+y（一个int型的数据）这个数对除以100就是横坐标，对100取余就是纵坐标。然后再一个双重循环，就可以计算直线了
public class Main {
    public static void main(String[] args) {
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 21; j++) {
                Point point = new Point(i,j);
                list.add(point);
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size() ; j++) {
                int x1 = list.get(i).getX();
                int y1 = list.get(i).getY();
                int x2 = list.get(j).getX();
                int y2 = list.get(j).getY();
                int kup = y1-y2;
                int kdown = x1-x2;
                if(kdown==0){
                    //那么k是不存在的，就需要保存的是X表示直线
                    String s = "y="+x1;
                    set.add(s);
                    continue;
                }
                //要保留分数的最简表达式，就是获取分子和分母的最大公约数，并分别除以最大公约数即可

                int kgcd = gcd(kup,kdown);
                kup = kup/kgcd;
                kdown = kdown/kgcd;

                int bup=y1*kdown-kup*x1;
                int bdown=kdown;
                int bgcd=gcd(bup,bdown);//分子分母最大公约数
                bup=bup/bgcd;
                bdown=bdown/bgcd;//得到最简分数
                String s=kup+" "+kdown+" "+bup+" "+bdown;
                set.add(s);
            }
        }
        System.out.println(set.size());
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static class Point{
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
