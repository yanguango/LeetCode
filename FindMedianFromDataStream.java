class MedianFinder {
    private PriorityQueue<Integer> leftHeap;
    private PriorityQueue<Integer> rightHeap;
    private double median;

    public MedianFinder() {
        leftHeap = new PriorityQueue(16, Collections.reverseOrder());
        rightHeap = new PriorityQueue();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        int leftSize = leftHeap.size();
        int rightSize = rightHeap.size();
        if (leftSize < rightSize) {
            if (num < median) {
                leftHeap.offer(num);
            } else {
                leftHeap.offer(rightHeap.poll());
                rightHeap.offer(num);
            }
            median = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        } else if (leftSize == rightSize) {
            if (num < median) {
                leftHeap.offer(num);
                median = leftHeap.peek();
            } else {
                rightHeap.offer(num);
                median = rightHeap.peek();
            }
        } else {
            if (num < median) {
                rightHeap.offer(leftHeap.poll());
                leftHeap.offer(num);
            } else {
                rightHeap.offer(num);
            }
            median = (leftHeap.peek() + rightHeap.peek()) / 2.0;
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();