package lanqiaobei.lanqiao_10;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        List<Map<String,Integer>>list =new ArrayList<>();
        for(int i = 0;i < 20;i++) {
            for(int j =0;j <21;j++) {
                HashMap<String,Integer>tempMap =new HashMap<>();
                tempMap.put("heng",i);
                tempMap.put("zong",j);
                list.add(tempMap);
            }
        }
        List<Map<String,Integer>> listOfLinear =new ArrayList<>();

        //线段初始化
        for(int i =0;i <list.size()-1; i++) {
            for(int j =i+1;j <list.size() ;j++) {
                Map<String,Integer>mapLeft =list.get(i);
                Map<String,Integer>mapRight =list.get(j);
                Map<String,Integer>linearMap =new HashMap<>();
                linearMap.put("heng",mapLeft.get("heng")-mapRight.get("heng"));
                linearMap.put("zong",mapLeft.get("zong")-mapRight.get("zong"));
                listOfLinear.add(linearMap);
            }
        }
        //应该初始化出来15条线段，这个应该是对的
        System.out.println(listOfLinear.size());


        for(int i =0;i <listOfLinear.size()-1;i++) {
            for(int j =i+1;j <list.size() ;j++) {
                for(int j2 =1;j2 <30;j2++) {
                    Map<String,Integer>linear1 =listOfLinear.get(i);
                    Map<String,Integer>linear2 =listOfLinear.get(j);
                    if(linear1.get("heng")*j2 ==linear2.get("heng") &&
                            linear1.get("zong")*j2 ==linear2.get("zong")){
                        listOfLinear.remove(j);
                        j = j-1;
                    }
                    if(linear1.get("heng")*j2 ==-1*linear2.get("heng") &&
                            linear1.get("zong")*j2 ==-1*linear2.get("zong")){

                    }
                }
            }
        }
        System.out.println(listOfLinear.size());

    }


}



