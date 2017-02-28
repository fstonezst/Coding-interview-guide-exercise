

public class Chapter1_3 {
        private static <T> T getButton(Stack<T> s) {
                T result = s.pop();
                if (s.isEmpty()) {
                        return result;
                } else {
                        T last = getButton(s);
                        s.push(result);
                        return last;
                }
        }

        public static <T> void reverse(Stack<T> stack) {
                if (stack.isEmpty()) {
                        return;
                }
                T last = getButton(stack);
                reverse(stack);
                stack.push(last);
        }
}