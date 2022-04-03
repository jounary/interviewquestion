package suanfa;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

//快速排序
public class quickSort {
   /* private static quickSort sort;
    private quickSort(){
        sort = new quickSort();
    }

    public static quickSort getInstance(){
        return sort;
    }
    public static int[] arr;
    public static int[] createArr(int n){
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Random().nextInt(10000);
        }
        return arr;
    }
    public static void main(String[] args) {
        int n = 10;
        arr = new int[10];
        arr = createArr(n);
        System.out.println(Arrays.toString(arr));
        quickSort(arr,0,9);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int i, int j){
        if(i >= j){
            return;
        }
        int l = i; int r = j;
        int tmp = arr[i];
        while(i < j){
            while (i < j && arr[j] > tmp){
                j--;
            }
            if(i < j){
                arr[i] = arr[j];
                i++;
            }
            while (i<j && arr[i] < tmp){
                i++;
            }
            if(i < j){
                arr[j] = arr[i];
                j--;
            }
        }
        arr[i] = tmp;
        quickSort(arr,l,i-1);
        quickSort(arr,i+1,r);
    }*/

    public static void main(String[] args) {
        int[] arr = {1,3,2,7,4,2,5,2,88,2,3456789};
        quickSortFun(arr,0,arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void quickSortFun(int[] arr,int left, int right) {
        if(left >= right){
            return;
        }
        int tmp = arr[left];
        int leftP = left;
        int rightP = right;

        while(leftP < rightP){
            while(leftP < rightP && arr[rightP] > tmp){
                rightP --;
            }
            while (leftP < rightP && arr[leftP] < tmp){
                leftP ++;
            }
            if(leftP < rightP){
                int dvs = arr[leftP];
                arr[leftP] = arr[rightP];
                arr[rightP] = dvs;
                leftP ++;
                rightP --;
            }
        }
        arr[leftP] = tmp;
        quickSortFun(arr,0,rightP-1);
        quickSortFun(arr,leftP+1,right);
    }
}
