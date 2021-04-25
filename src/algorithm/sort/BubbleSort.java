package algorithm.sort;

import java.util.Arrays;

/**
 * 버블 정렬
 *
 * 두 숫자를 비교해서 더 작은 숫자를 왼족에 두는 것.
 * 반복이 끝났을 때, 가장 큰 숫자가 먄 뒤에 있게 된다.
 *
 * 시간 복잡도 : O(N²)
 * 선택정렬보다 더 비효율적인 정렬 알고리즘 => 비교할 때마다 바꾸기 연산이 이뤄지기 때문
 */

public class BubbleSort {
    int[] array = new int[]{10, 2, 5, 8, 12, 73};

    public void sort() {
        int temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
