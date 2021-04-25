package algorithm.sort;

import java.util.Arrays;

/**
 * 삽입 정렬
 *
 * 앞의 숫자들이 이미 정렬이 되어 있다고 가정
 * 특정 원소에서 앞의 원소들을 살펴보며 적당한 위치를 찾는 것
 *
 * 시간 복잡도 : O(N²)
 * 선택 정렬, 버블 정렬보다 효율적인 알고리즘 => 필요 시에 바꾸기 연산이 이뤄지기 때문
 * 정렬이 이미 되어 있을 경우에는 최고의 효율을 보인다.
 */

public class InsertSort {
    int[] array = new int[]{10, 2, 5, 8, 12, 73};

    public void sort() {
        int j, temp;

        for (int i = 0; i < array.length - 1; i++) {
            j = i;
            while (j >= 0 && array[j] > array[j + 1]) {
                temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                j--;
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
