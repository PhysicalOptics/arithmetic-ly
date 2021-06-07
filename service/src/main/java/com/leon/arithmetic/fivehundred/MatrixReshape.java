package com.leon.arithmetic.fivehundred;

/**
  * ClassName:    MatrixReshape
  * @Description: 566
  * @Author:      liyang
  * @Date:        2021/2/25
  * version     1.0.0
 */

public class MatrixReshape {

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
//        int tr = nums.length;
//        int tc = nums[0].length;
//        if (tr * tc != r*c){
//            return nums;
//        }
//        int[][] ret = new int[r][c];
//        int rr=0,rc=0;
//        while (rr < r){
//            while (rc < c){
//                int pr = (rr * c + rc + 1) / tc ;
//                int pc = (rr * c + rc + 1) % tc;
//                ret[rr][rc] = nums[pc==0?pr-1:pr][pc==0?tc-1:pc-1];
//                rc++;
//            }
//            rc=0;
//            rr++;
//        }

        int tr = nums.length;
        int tc = nums[0].length;
        if (tr * tc != r*c){
            return nums;
        }
        int[][] ret = new int[r][c];
        for (int x = 0; x < tr * tc; ++x) {
            ret[x / c][x % c] = nums[x / tc][x % tc];
        }
        return ret;
    }

    /*public int[][] generateMatrix(int n) {
        int[][] ints = new int[n][n];
        int i=0,j=0,count=0;
        while (count<n*n){
            while (j<n-i){
                ints[i][j] = i*n+j+1;
                j++;
                count++;
            }
            j--;
            while (i<n-j){
                ints[i][j] = i*n+j+1;
                i++;
                count++;
            }
            i--;
            while (j>0){
                j--;
                ints[i][j] = i*n+j+1;
            }
        }
    }*/

    public void shang(int i, int j){
        i--;
    }

    public void xia(int i, int j){
        i++;
    }

    public void zuo(int i, int j){
        j--;
    }

    public void you(int i, int j){
        j++;
    }


    public static void main(String[] args){

        int[][] ints = {{1,2},{3,4}};
        matrixReshape(ints,1,4);
    }
}