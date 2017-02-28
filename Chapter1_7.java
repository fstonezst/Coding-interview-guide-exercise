public class Chapter1_7 {
        public int[] maxSlidingWindow(int[] nums, int k) {
                if (nums == null || k <= 0)
                        return new int[0];
                LinkedList<Integer> q = new LinkedList<>();
                int[] out = new int[nums.length - k + 1];
                int p = 0;
                for (int i = 0; i < nums.length; ++i) {
                        while (!q.isEmpty() && nums[i] > nums[q.getLast()])
                                q.removeLast();
                        q.add(i);
                        if (q.getFirst() <= i - k)
                                q.removeFirst();
                        if (i >= k - 1)
                                out[p++] = nums[q.getFirst()];
                }
                return out;
        }
}
