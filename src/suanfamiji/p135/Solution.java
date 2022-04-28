package suanfamiji.p135;


import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //这个使用数组是不能解决的，如果要提速，就要选择不同的数据结构
        //如果使用栈，就代表先进后出，那么就代表，如果栈中有东西，东西比我当前比较的数更小的，直接删除
        //东西比我当前要比较的数更大，我就进行添加（添加到栈中），并且栈应该存一个数据结构，包括数字和位置
        Stack<Location> stack = new Stack<>();
        int[] answear = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            //1.
            Location location = new Location(i,temperatures[i]);
            while(!stack.isEmpty()&&stack.peek().getNumber()<=location.getNumber()){
                stack.pop();
            }
            if(stack.isEmpty()){
                answear[i] = 0;
            }
            else{
                answear[i] = stack.peek().getIndex()-i;
            }
            stack.push(location);
        }
        return answear;
        //
    }
    private class Location {
        private int index;
        private int number;

        public Location(int index, int number) {
            this.index = index;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
