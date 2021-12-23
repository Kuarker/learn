package com.kuarker.test;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-12-23
 **/
public class AriApp {


    public static void main(String[] args) {


        int[] ints = {1, 2, 5, 2, 7, 3, 9, 5, 0, 1};

        bubbleSort(ints);

        for (int anInt : ints) {
            System.out.println(anInt);

        }


    }

    private static void bubbleSort(int[] nums) {
        if (nums == null) {
            return;
        }

        int lenght = nums.length;

        for (int i = 0; i < lenght; i++) {


            for (int j = i; j < lenght; j++) {


                if (nums[i]>nums[j]) {
                    swap(i, j, nums);
                }

            }
        }


    }

    private static void swap(int i, int j, int[] ints) {


        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
