package com.wesley.growth.algorithms.sort;

/**
 * 归并排序
 * 时间复杂度 N log(N)
 * @author Wesley Created By 2018/7/28
 */
public class MergeSort extends AbstractSort{

    @Override
    public <T extends Comparable<T>> void sort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    /**
     * 递归使用归并排序,对arr[l...r]的范围进行排序
     * @param left
     * @param right
     */
    private <T extends Comparable<T>> void mergeSort(T[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    /**
     * 将arr[l...mid]和arr[mid+1...r]两部分进行归并
     */
    private <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
        T[] aux = (T[]) new Comparable[right - left + 1];

        for (int i = left; i <= right; i ++){
            aux[i - left] = arr[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left].compareTo(aux[j - left]) < 0) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }

    @Override
    public void sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        // 不可再分割
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        // 左边：[left, mid]
        mergeSort(arr, left, mid);
        // 右边：[mid+1, right]
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // 需要临时空间
        int[] aux = new int[right - left + 1];

        for (int i = left; i <= right; i ++){
            aux[i - left] = arr[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] < aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }
}
