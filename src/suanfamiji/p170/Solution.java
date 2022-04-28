package suanfamiji.p170;

import java.util.HashMap;
import java.util.Random;

//完成一个聪明的解法，不适用随机函数的方式实现随机取数
//目标，优化算法， 能够最小化随机函数的调用次数，方法：把黑值放在最后，让随机函数的取值只在前面，那么每次随机的都是想要的
class Solution {
    Random random;
    int[] answear;
    int blackNumber;
    HashMap<Integer, Integer> alreadyDone;
    int miniCoundChangeIndex;
    int normalLimit;

    public Solution(int n, int[] blacklist) {
        alreadyDone = new HashMap<>();
        this.blackNumber = blacklist.length;
        this.random = new Random();
        this.answear = new int[n];
        this.normalLimit = answear.length - this.blackNumber + 1;//limit是不可以进行访问的位置
        // 0 1 2 3 4  黑数为 1 2  n =4 length = 2 正常数就是前三个
        this.miniCoundChangeIndex = n - blacklist.length;//mini是直接可以访问的

        //完成answear 的初始化
        for (int i = 0; i < answear.length; i++) {
            answear[i] = i;
        }
        //将黑数进行交换
        for (int i = 0; i < blacklist.length; i++) {
            miniFresh(blacklist);
            //黑数是我不要的内容，我就应该
            while (alreadyDone.getOrDefault(blacklist[i], 0) != 0) {
                i++;
            }
            if (i < blacklist.length) {
                answear[blacklist[i]] = answear[miniCoundChangeIndex];
                alreadyDone.put(blacklist[i], 1);
                if(miniCoundChangeIndex<answear.length){
                    this.miniCoundChangeIndex++;
                }

            }

        }


    }

    public int pick() {
        int randomNumber = this.random.nextInt(this.normalLimit - 1);
        return answear[randomNumber];

    }

    //还是没有函数分级的理念，你要对每个函数，做的哪个事情要100%控制好
    private void miniFresh(int[] blacklist) {
        while (this.miniCoundChangeIndex < answear.length) {
            int mini = answear[this.miniCoundChangeIndex];
            boolean flag = false;
            for (int i1 : blacklist) {
                if (i1 == mini) {
                    alreadyDone.put(mini, 1);
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                this.miniCoundChangeIndex++;
            } else {
                return;
            }
            //如果走完了循环，就进行返回嘛？


        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */