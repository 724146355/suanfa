package suanfamiji.p135;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answear = solution.dailyTemperatures(new int[]{30,60,90});
        for (int i : answear) {
            System.out.println(i);
        }
    }
}
