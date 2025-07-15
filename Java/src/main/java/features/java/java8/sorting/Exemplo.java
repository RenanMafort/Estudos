package features.java.java8.sorting;

import java.util.Arrays;

public class Exemplo {
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,6,8,9,-1,-2};

        for (int i = 0; i < nums.length -1; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println();

        Arrays.parallelSort(nums,0,5);

        for (int i = 0; i < nums.length -1; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
