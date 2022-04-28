package lanqiaobei.lanqiao_12.t1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //我把数据分成多列，分别是单个字符、2个字符等等，
        //每次都只看最后一位的数字，只要后面更大的，我就进行添加（还要本质的不同，因此，添加应该是区分内容的
        //就设计成Set集合，自动去除重复
        //A不能这样，因为我还要记录我最后一个字符串的位置呢
        String s = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcm" +
                "xvicfauachlifhafpdccfseflcdgjncadfclvfmadvrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl\n";
        HashMap<Integer, HashSet<MyString>> map = new HashMap<>();

        //先完成一个初始化
        for (int i = 0; i < s.length(); i++) {
            HashSet<MyString> set = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                char charTemp = s.charAt(j);
                String s1 = String.valueOf(charTemp);
                set.add(new MyString(j,s1,charTemp));
            }
            map.put(1,set);
        }
        //确实能够添加，并且只保留第一次存在的元素
        for (int i = 2; i < s.length(); i++) {
            HashSet<MyString> set = new HashSet<>();
            HashSet<MyString> myStrings = map.get(i-1);

            for (MyString myString : myStrings) {
                int locaiton = myString.getLocaiton();
                char myStringChar = myString.getCharTemp();
                for (int j = locaiton+1; j <s.length() ; j++) {
                    char c = s.charAt(j);
                    if(c-myStringChar >0){
                        String addString = myString.getMyString()+c;
                        MyString add = new MyString(j,addString,c);
                        set.add(add);

                    }

                }
            }
            map.put(i,set);
        }

        //添加完成了，进行输出并校验
        Set<Integer> integers = map.keySet();
        long number = 0;
        for (Integer integer : integers) {
            HashSet<MyString> myStrings = map.get(integer);
            System.out.println("字符串大小为"+integer+"输出字符串的大小"+myStrings.size());
            number+=myStrings.size();
//            for (MyString myString : myStrings) {
//                System.out.println(myString.getMyString());
//            }
        }

        System.out.println(number);
    }
    public static class MyString {
        int locaiton;
        String myString;
        char charTemp;

        public MyString(int locaiton, String myString, char charTemp) {
            this.locaiton = locaiton;
            this.myString = myString;
            this.charTemp = charTemp;
        }

        public char getCharTemp() {
            return charTemp;
        }

        public void setCharTemp(char charTemp) {
            this.charTemp = charTemp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MyString myString1 = (MyString) o;

            return myString.equals(myString1.myString);
        }

        @Override
        public int hashCode() {
            return myString.hashCode();
        }



        public int getLocaiton() {
            return locaiton;
        }

        public void setLocaiton(int locaiton) {
            this.locaiton = locaiton;
        }

        public String getMyString() {
            return myString;
        }

        public void setMyString(String myString) {
            this.myString = myString;
        }


    }
}

