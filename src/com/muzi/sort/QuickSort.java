/**
 * Shanghai Centalinehink.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.muzi.sort;

/**
 * TODO:6.快速排序
 * 
 * 基本思想：选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，
 * 将待排序列分成两部分,一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,
 * 然后再用同样的方法递归地排序划分的两部分。
 * @author lizh35
 * @version $Id: QuickSort.java, v 0.1 2015年11月12日 下午4:12:50 lizh35 Exp $
 */
public class QuickSort {

    int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18,
            23, 34, 15, 35, 25, 53, 51 };

    public QuickSort() {
        quick(a);
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public int getMiddle(int[] list, int low, int high) {
        int tmp = list[low]; //数组的第一个作为中轴     
        while (low < high) {
            while (low < high && list[high] >= tmp) {

                high--;
            }
            list[low] = list[high]; //比中轴小的记录移到低端     
            while (low < high && list[low] <= tmp) {
                low++;
            }
            list[high] = list[low]; //比中轴大的记录移到高端     
        }
        list[low] = tmp; //中轴记录到尾     
        return low; //返回中轴的位置     
    }

    public void _quickSort(int[] list, int low, int high) {
        if (low < high) {
            int middle = getMiddle(list, low, high); //将list数组进行一分为二     
            _quickSort(list, low, middle - 1); //对低字表进行递归排序     
            _quickSort(list, middle + 1, high); //对高字表进行递归排序     
        }
    }

    public void quick(int[] a2) {
        if (a2.length > 0) { //查看数组是否为空     
            _quickSort(a2, 0, a2.length - 1);
        }
    }

    public static void main(String[] args) {
        new QuickSort();
    }

}
