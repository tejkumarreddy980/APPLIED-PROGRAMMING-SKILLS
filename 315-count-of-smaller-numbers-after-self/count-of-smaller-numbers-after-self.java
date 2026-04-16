import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] index = new int[n];

        for (int i = 0; i < n; i++) index[i] = i;

        mergeSort(nums, index, count, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : count) result.add(c);
        return result;
    }

    private void mergeSort(int[] nums, int[] index, int[] count, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort(nums, index, count, left, mid);
        mergeSort(nums, index, count, mid + 1, right);

        merge(nums, index, count, left, mid, right);
    }

    private void merge(int[] nums, int[] index, int[] count, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (nums[index[j]] < nums[index[i]]) {
                temp[k++] = index[j++];
                rightCount++;
            } else {
                count[index[i]] += rightCount;
                temp[k++] = index[i++];
            }
        }

        while (i <= mid) {
            count[index[i]] += rightCount;
            temp[k++] = index[i++];
        }

        while (j <= right) {
            temp[k++] = index[j++];
        }

        for (int p = 0; p < temp.length; p++) {
            index[left + p] = temp[p];
        }
    }
}