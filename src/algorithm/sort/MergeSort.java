package algorithm.sort;

import java.util.Arrays;

/**
 * 병합 정렬
 *
 * 함수가 호출될 때 마다 배열을 절반씩 나누어, 가장 작은 조각부터 정렬하고, 병합하는 정렬 알고리즘
 * 실행 시에 별도의 temp 공간이 필요하기 때문에 공간이 없을 경우에는 퀵 정렬을 이용한다.
 *
 * 시간 복잡도 : O(NlogN)
 * 배열이 N개의 낱개로 나뉘어져 시작
 * 절반씩 나누어 검사를 하게 되니 logN
 * 퀵 정렬과 다르게 최악의 복잡도도 O(NlogN)을 가지는 정렬 알고리즘
 */

public class MergeSort {
    int[] array = new int[]{10, 2, 5, 8, 1, 73};

    public void sort() {
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private void mergeSort(int[] a, int[] temp, int start, int end) {
        // 크기가 1보다 큰 경우
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, temp, start, mid); // 절반으로 나눈다.
            mergeSort(array, temp, mid + 1, end);
            merge(array, temp, start, mid, end); // 나눈 것을 정렬 후, 병합
        }
    }

    private void merge(int[] a, int[] temp, int start, int mid, int end) { // 시작점, 중간점, 끝점
        for (int i = start; i <= end; i++) {
            temp[i] = a[i];
        }

        int part_1 = start; // 첫번째 배열 방의 첫번째 인덱스
        int part_2 = mid + 1; // 두번째 배열 방의 첫번째 인덱스
        int index = start; // 결과 배열 방의 현재 인덱스

        while (part_1 <= mid && part_2 <= end) { // 첫번째 배열이 끝까지 가거나 두번째 배열이 끝까지 갈 때까지, break
            if (temp[part_1] <= temp[part_2]) {
                a[index] = temp[part_1];
                part_1++;
            } else {
                a[index] = temp[part_2];
                part_2++;
            }
            index++;
        }

        // 남은 데이터도 삽입
        if (part_1 > mid) { // part_1은 다 들어갔지만 part_2가 남아있을 경우를 대비함
            for (int i = part_2; i <= end; i++) {
                a[index] = temp[i];
                index++;
            }
        } else {
            for (int i = part_1; i <= mid; i++) {
                a[index] = temp[i];
                index++;
            }
        }
    }
}
