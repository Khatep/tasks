package findmaxavg;

/**
 Дан целочисленный массив nums, состоящий из n элементов, и целое число k. <br><br>

 Найдите непрерывный подмассив длиной k, имеющий максимальное среднее значение, и верните это значение. <br><br>

 Подмассив — это последовательность чисел без изменения порядка или пропуска элементов исходного массива.
 * */

public class FIndMaxAverage {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0,4,0,3,2};
        int k = 1;
        double res = s.findMaxAverageSlidingWindow(nums, k);
        System.out.println(res);
    }
}

class Solution {
    public double findMaxAverageSlidingWindow(int[] nums, int k) {
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        int tempSum = maxSum;
        for (int i = k; i < nums.length; i++) {
            tempSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, tempSum);
        }

        return 1.0 * maxSum / k;
    }

    public double findMaxAveragePrefixSums(int[] nums, int k) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }

        double maxSum = sums[k - 1];
        for (int i = k; i < nums.length; i++) {
            maxSum = Math.max(maxSum, sums[i] - sums[i-k]);
        }

        return maxSum / k;
    }
}