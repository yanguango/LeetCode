public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] index = new int[2];
        if (numbers.length < 2) return index;
        index[0] = 1;
        index[1] = numbers.length;
        while (index[0] < index[1]) {
            int num1 = numbers[index[0] - 1];
            int num2 = numbers[index[1] - 1];
            if (num1 + num2 == target) {
                return index;
            } else if (num1 + num2 < target) {
                index[0]++;
            } else {
                index[1]--;
            }
        }
        return index;
    }
}
