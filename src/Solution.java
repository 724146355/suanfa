public class Solution {
    public void printfeiji(){
        String s = "1.jpg";
        System.out.println(s.lastIndexOf('.'));
        String substring = s.substring(s.lastIndexOf('.')+1);
        System.out.println(substring);

    }
}
