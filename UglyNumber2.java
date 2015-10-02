public class Solution {
    public int nthUglyNumber(int n) {
        Queue<Long> heap = new PriorityQueue<>();
        heap.offer(1L);
        int count = 1;
        int[] factors = {2, 3, 5};
        while (count < n) {
            long num = heap.poll();
            for (int i : factors) {
                if (!heap.contains(num * i))
                    heap.offer(num * i);
            }
            count++;
        }
        return heap.poll().intValue();
    }
}
