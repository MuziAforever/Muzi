/**
 * Shanghai Centalinehink.com Inc.
 * Copyright (c) 2015-2015 All Rights Reserved.
 */
package com.muzi.sort;

/**
 * TODO:5.冒泡排序
 * 
 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，
 * 自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，
 * 较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * @author lizh35
 * @version $Id: BubbleSort.java, v 0.1 2015年11月12日 下午4:08:40 lizh35 Exp $
 */
public class BubbleSort {
    public BubbleSort() {
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17,
                18, 23, 34, 15, 35, 25, 53, 51 };
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < a.length; i++)
            System.out.println(a[i]);
    }

    public static void main(String[] args) {
        new BubbleSort();
    }

}
