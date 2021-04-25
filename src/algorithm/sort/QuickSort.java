package algorithm.sort;

import java.util.Arrays;

/**
 * 퀵 정렬
 *
 * Pivot 값을 기준으로 왼쪽에서부터 검사해서 큰 값을, 오른쪽에서부터 검사해서 작은 값을 발견한다.
 * 두 값을 바꾸기 연산하고, 같은 과정을 수행한다.
 * 큰 값의 index와 작은 값의 index가 교차할 경우, 작은 값과 Pivot 값을 교환한다.
 * 그러면 Pivot 값을 기준으로 왼쪽은 작은 값들이 오른쪽은 큰 값들로 분할된다.
 * 분할된 영역에서 같은 과정을 수행한다 = 재귀 성격
 *
 * 시간 복잡도 : O(NlogN)
 * 작은 값과 큰 값으로 분할을 할 수 없는 경우 = 이미 정렬되어 있는 경우 O(N²)
 */

public class QuickSort {
    int[] array = new int[]{10, 2, 5, 6, 3, 73};

    public void sort() {
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;

        int pivot = start;
        int left = start + 1;
        int right = end;
        int temp;

        while (left <= right) { // 엇갈릴 때 까지 반복
            // 피봇값보다 큰 값일 경우의 left값이 필요한거에요
            while (array[pivot] >= array[left]) {
                left++;
            }

            // 피봇값보다 작은 값일 경우의 right 값이 필요한거에요
            while (array[pivot] <= array[right] && right > start) {
                right--;
            }

            if (left > right) { // index가 엇갈릴 경우
                temp = array[right];
                array[right] = array[start];
                array[start] = temp;
            } else {
                temp = array[right];
                array[right] = array[left];
                array[left] = temp;
            }
        }

        quickSort(array, start, right - 1);
        quickSort(array, right + 1, end);
    }
}
