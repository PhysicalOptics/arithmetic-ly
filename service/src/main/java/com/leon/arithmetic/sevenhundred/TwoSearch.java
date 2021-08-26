package com.leon.arithmetic.sevenhundred;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
  * ClassName:    TwoSearch
  * @Description: 704
  * @Author:      liyang
  * @Date:        2021/7/30
  * version     1.0.0
  * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
  *
 */
public class TwoSearch {


    public int search(int[] nums, int target) {
        int left = 0 ,right = nums.length;
        while (left<right){
            int mid = left+(right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid]<target){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        //构建最大顶堆
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer i1, Integer i2) {
//                return i1-i2;
//            }
//        });
//        queue.offer(2);
//        Integer peek = queue.peek();
//        queue.poll();

        Integer i = 123123;
        System.out.println("24,25,26,27,123123".indexOf(i.toString())>0);
        System.out.println("Preparing:SELECT t2.csa_org_id , t3.begin_date , t3.item , CONVERT( AVG(t3.data_value) , DECIMAL(10 , 2) ) avgdatavalue FROM csa_user_info t1 INNER JOIN csa_org2user t2 ON t1.id = t2.csa_user_id INNER JOIN( SELECT csa_user_id , begin_date , item , data_value FROM ( SELECT csa_user_id , begin_date , item , data_value , create_time FROM csa_assess_original_data WHERE is_delete = 0 AND item IN( ? , ? , ? , ? ) AND begin_date = ? AND csa_user_id NOT IN( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? ) ORDER BY id DESC ) temp GROUP BY csa_user_id , item ) t3 ON t2.csa_user_id = t3.csa_user_id WHERE t1.`status` = 0 AND t2.user_org_role = 'member' AND t2.csa_org_id IN( ? , ? , ? , ? , ? ) GROUP BY t3.item  ");
        System.out.println("Parameters: jtl(String), myd(String), fwpjl(String), pjthsc(String), 2021-07(String), 573(Integer), 405(Integer), 386(Integer), 305(Integer), 653(Integer), 611(Integer), 274(Integer), 601(Integer), 276(Integer), 277(Integer), 699(Integer), 613(Integer), 478(Integer), 581(Integer), 784(Integer), 816(Integer), 830(Integer), 831(Integer), 835(Integer), 836(Integer), 837(Integer), 838(Integer), 24(Integer), 25(Integer), 26(Integer), 27(Integer), 28(Integer)");





    }
    public int firstBadVersion(int n){
        int left= 0,right = n;
        while (left<right){
            int mid = left + (right-left)/2;
            if (isBadVersion(mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }
    boolean isBadVersion(int version){
        return true;
    }
}