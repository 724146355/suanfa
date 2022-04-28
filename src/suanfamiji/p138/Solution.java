package suanfamiji.p138;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
//数据特征分析：频繁的增减数据，只要我移除的是最大的数字，就表示我要重新进行遍历，那么，不如就在添加数字的时候，能够随时保持数据的顺序
//这样的结构只能是通过链表来进行实现
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyPriorityQueue myPriorityQueue = new MyPriorityQueue();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            myPriorityQueue.push(nums[i]);
        }
        int answear = myPriorityQueue.getBigest();
        list.add(answear);
        for (int i = 1+k-1; i <nums.length ; i++) {
            myPriorityQueue.pop(nums[i-k]);
            myPriorityQueue.push(nums[i]);

            int answer = myPriorityQueue.getBigest();
            list.add(answer);

        }
        int[] answearlist = list.stream().mapToInt(Integer::valueOf).toArray();
        return answearlist;
    }
    private class MyPriorityQueue{
        LinkedList<Integer> list = new LinkedList<>();
        void push(Integer number){
            while(!list.isEmpty() && list.peekLast()<number){
                list.pollLast();
            }
            list.addLast(number);
        }

        void pop(Integer number){

            if(number.equals(list.getFirst())){
                list.pollFirst();
            }
        }

        public int getBigest() {
            return list.getFirst();
        }
    }
}
