public class Chapter1_9 {
        public int maximalRectangle(char[][] matrix) {
                int[] heights = new int[matrix[0].length];
                int max = 0;
                for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[0].length; ++j) {
                                if (matrix[i][j] == '1')
                                        heights[j]++;
                                else
                                        heights[j] = 0;
                        }
                        max = Math.max(max, largestRectangleArea(heights));
                }
                return max;
        }

        public int largestRectangleArea(int[] heights) {
                Stack<Integer> s = new Stack<>();
                int max = 0;
                for (int i = 0; i <= heights.length; i++) {
                        int currentH = i == heights.length ? 0 : heights[i];
                        while (!s.isEmpty() && heights[s.peek()] > currentH) {//找到右边界了
                                int h = heights[s.pop()];//s.pop()左边界
                                int w = s.isEmpty() ? i : (i - s.peek() - 1);
                                if (h * w > max)
                                        max = h * w;
                        }
                        s.push(i);
                }
                return max;
        }
}

