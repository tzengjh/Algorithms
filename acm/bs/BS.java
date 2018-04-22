/*
* @Author: tzengjh
* @Date:   2018-04-22 15:20:53
* @Last Modified by:   tzengjh
* @Last Modified time: 2018-04-22 16:41:22
*/

public class BS{

    public static int binarySearch(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else if(nums[mid] > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int target, int lo, int hi){
        if(lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if     (nums[mid] < target) return binarySearch(nums, target, mid + 1, hi);
        else if(nums[mid] > target) return binarySearch(nums, target, lo, mid - 1);
        else                        return mid;
    }

    public static int firstOccurrence(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static int firstOccurrence(int[] nums, int target, int lo, int hi){
        if(lo > hi) return lo;
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] < target){
            return firstOccurrence(nums, target, mid + 1, hi);
        }else{
            return firstOccurrence(nums, target, lo, mid - 1);
        }
    }

    public static int lastOccurrence(int[] nums, int target){
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
        }
        return hi;
    }

    public static int lastOccurrence(int[] nums, int target, int lo, int hi){
        if(lo > hi) return hi;
        int mid = lo + (hi - lo) / 2;
        if(nums[mid] > target) return lastOccurrence(nums, target, lo, mid - 1);
        else return lastOccurrence(nums, target, mid + 1, hi);
    }


    public static void main(String[] args){
        int[] arr = {1, 3, 4, 5, 6, 8, 9, 12, 21, 32};
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
        System.out.println("------binarySearch------");
        System.out.println("location of 3:" + binarySearch(arr, 3));
        System.out.println("location of 4:" + binarySearch(arr, 4, 0, arr.length - 1));
        System.out.println("location of 7:" + binarySearch(arr, 7));
        System.out.println("location of 7:" + binarySearch(arr, 7, 0, arr.length - 1));

        int[] arr1 = {1, 3, 3, 5, 6, 8, 8, 8, 21, 32};
        for(int i = 0; i < arr1.length; i++)
            System.out.print(arr1[i] + " ");
        System.out.println();
        System.out.println("------firstOccurrence------");
        System.out.println("location of 3:" + firstOccurrence(arr1, 3));
        System.out.println("location of 8:" + firstOccurrence(arr1, 8, 0, arr1.length - 1));
        System.out.println("location of 4:" + firstOccurrence(arr1, 4));
        System.out.println("location of 4:" + firstOccurrence(arr1, 4, 0, arr1.length - 1));
        System.out.println("location of 0:" + firstOccurrence(arr1, 0));
        System.out.println("location of 0:" + firstOccurrence(arr1, 0, 0, arr1.length - 1));
        System.out.println("location of 40:" + firstOccurrence(arr1, 40));
        System.out.println("location of 40:" + firstOccurrence(arr1, 40, 0, arr1.length - 1));

        System.out.println("------lastOccurrence------");
        System.out.println("location of 3:" + lastOccurrence(arr1, 3));
        System.out.println("location of 8:" + lastOccurrence(arr1, 8, 0, arr1.length - 1));
        System.out.println("location of 4:" + lastOccurrence(arr1, 4));
        System.out.println("location of 4:" + lastOccurrence(arr1, 4, 0, arr1.length - 1));
        System.out.println("location of 0:" + lastOccurrence(arr1, 0));
        System.out.println("location of 0:" + lastOccurrence(arr1, 0, 0, arr1.length - 1));
        System.out.println("location of 40:" + lastOccurrence(arr1, 40));
        System.out.println("location of 40:" + lastOccurrence(arr1, 40, 0, arr1.length - 1));
    }
}
