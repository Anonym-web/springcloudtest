package com.anonym.spring.pojo;

import java.util.ArrayList;

public class TestController {

    public static void main(String[] args) {

        /*int[] nums = {10,9,2,5,3,4,7,101,18};
        lengthOfLIS(nums);*/
        eoor();
    }


    public static int lengthOfLIS(int[] nums) {

        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        int []dp=new int[n];  //记录每次第i个元素的序列时的最长子序列
        dp[0]=1;
        for(int i=1;i<n;i++){
            int max=1;  //这个是最大的长度在每一次递归中的记录
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                max=Math.max(max,dp[j]+1);
            }
            dp[i]=max;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    public static void eoor(){
        try {
            ArrayList arrayList = new ArrayList();
            while (true){
                arrayList.add(new TestController());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
