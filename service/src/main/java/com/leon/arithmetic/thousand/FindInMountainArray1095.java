package com.leon.arithmetic.thousand;

/**
  * ClassName:    FindInMountainArray1095
  * @Description: 1095. 山脉数组查找目标值
  * @Author:      liyang
  * @Date:        2021/11/18
  * version     1.0.0
 */
public class FindInMountainArray1095 {
    public static void main(String[] args){
        int s= 1231232328,c = 64;
        System.out.println(System.currentTimeMillis());
        System.out.println(s%c);
        System.out.println(System.currentTimeMillis());
        System.out.println(s&(c-1));
        System.out.println(System.currentTimeMillis());
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        int left = 0, right = length -1;
        while (left<right){
            int mid = left + (right - left) / 2;
            if (mountainArr.get(mid)<mountainArr.get(mid+1)){
                left = mid+1;
            }else {
                right = mid;
            }
        }
        if (mountainArr.get(left)<target||(mountainArr.get(0)>target&&mountainArr.get(length -1)>target)) return -1;
        int lnum = findNumber(target, mountainArr, 0, left,true);
        if (lnum >-1){
            return lnum;
        }
        int rnum = findNumber(target, mountainArr, left, length -1,false);
        if (rnum>-1){
            return rnum;
        }
        return -1;

    }

    public int findNumber(int target, MountainArray mountainArr,int left,int right,boolean flag){
        while (left<=right){
            int mid = left + (right - left) / 2;
            int curr = mountainArr.get(mid);
            if (curr ==target){
                return mid;
            }else if ((curr <target)==flag){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }


}
class MountainArray {
    int[] ints = {1, 5, 2};
    public int get(int index) {

        return ints[index];
    }
    public int length() {return ints.length;}
}