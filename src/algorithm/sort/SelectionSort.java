package algorithm.sort;

import java.util.Arrays;

/**
 * 선택 정렬
 *
 * 가장 작은 숫자를 가장 앞에 두는 것.
 * 반복이 끝났을 때, 최솟값이 맨 앞에 있게 된다.
 *
 * 시간 복잡도 : O(N²)
 */

public class SelectionSort {
    int[] array = new int[]{10, 2, 5, 8, 12, 73};

    public void sort() {
        int min, temp, index = 0;

        for (int i = 0; i < array.length; i++) {
            min = 99999;
            for (int j = i; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }

        System.out.println(Arrays.toString(array));
    }
}
