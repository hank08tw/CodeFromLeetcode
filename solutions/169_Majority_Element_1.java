public class Solution {
    public int majorityElement(int[] num) {
        int [] times = new int[32];
        int res = 0;
        for(int ix = 0; ix < 32; ++ix){
            int count = 0;
            for(int val:num){
               if((val>>>ix \u0026 1) == 1) 
               count++;
            }
            times[ix] = count;
        }
        int flag = (times[31] > num.length / 2)? 1:0;
        for(int ix = 30; ix>=0; ix--){
            int digit = (times[ix] > num.length / 2)? 1: 0;
            if(flag == 1)
                digit = 1 - digit;
            res = res* 2 + digit;
        }
        if (times[31] > num.length / 2)
            res = -res - 1;
        return res;
        
    }
}