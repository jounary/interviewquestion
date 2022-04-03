package suanfa;

public class heapSort {
/*    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,4,3,2,1,9,3,2,5,7,3};
        int[] a= heapSortFun(arr);
        for (int i: a) {
            System.out.println(i);
        }
    }

    private static int[] heapSortFun(int[] arr) {
        //构建大根堆
        for(int i = arr.length/2 - 1; i >= 0; i--){
            adjustHeap(arr,i,arr.length);
        }
        for(int i = arr.length -1; i > 0; i--){
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            adjustHeap(arr,0,i);
        }
        return arr;
    }

    private static void adjustHeap(int[] arr, int i, int length) {
        int tmp = arr[i];
        for(int j = i*2 + 1; j < length; j=j*2+1){
            //判断左子树和右子树的大小
            if(j+1<length && arr[j] < arr[j+1]){
                j++;
            }
            if(arr[j] > tmp){
                arr[i] = arr[j];
                i = j;
            } else
                break;
        }
        arr[i] = tmp;
    }*/

    //大根堆排序算法
    public static void main(String[] args) {
        int[] arr = {42,6,3,7,2,6,3,5};
        int[] ans = heapSortFun(arr);
        for (int i: arr) {
            System.out.println(i);
        }
    }

    private static int[] heapSortFun(int[] arr) {
        //构造大根堆
        for(int i = arr.length/2-1;i>=0;i--){
            heapAdjust(arr,i,arr.length);
        }

        for(int i = arr.length-1; i >= 0; i--){
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;

            heapAdjust(arr,0,i);
        }
        return arr;
    }

    private static void heapAdjust(int[] arr, int i, int length) {
        int tmp = arr[i];
        for(int j = i*2+1; j < length; j = j*2+1){
            if(j+1 < length && arr[j] < arr[j+1]){
                j++;
            }
            if(arr[j] > tmp){
                arr[i] = arr[j];
                i = j;
            } else
                break;
        }
        arr[i] = tmp;
    }
}
