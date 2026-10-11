
class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0], a[0])
        );

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int distance = x * x + y * y;

            maxHeap.offer(new int[]{distance, x, y});

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = maxHeap.poll();
            ans[i][0] = point[1];
            ans[i][1] = point[2];
        }

        return ans;
    }
}