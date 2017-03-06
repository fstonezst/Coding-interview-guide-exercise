import java.util.*;
import java.util.logging.Logger;

/**
 * Created by peter on 2017/2/27.
 */

public class MaxTree {
    public static void main(String[] args) {
        int length = 10;
        Integer[] test = new Integer[length];
        for (int i = 0; i < 10; ++i) {
            test[i] = i;
        }
        myShuffle(test);
        for (int i : test) {
            System.out.print(i + "|");
        }
        Tree root = getMaxTree(test);
        printTree(root);
    }

    private static void printTree(Tree root) {
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            System.out.println();
            while (size > 0) {
                Tree node = q.poll();
                System.out.print("[" + node.data + ":");
                if (node.leftSon != null) {
                    System.out.print(" " + node.leftSon.data);
                    q.add(node.leftSon);
                }
                if (node.rightSon != null) {
                    System.out.print(" " + node.rightSon.data);
                    q.add(node.rightSon);
                }
                System.out.print("] ");
                size--;
            }
        }
    }

    public static <T> void myShuffle(T[] list) {
        Random rnd = new Random();
        int size = list.length;
        for (int i = size; i > 1; i--)
            swap(list, i - 1, rnd.nextInt(i));
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static <T extends Comparable> Tree<T> getMaxTree(T[] nums) {
        HashMap<T, T> rootMap = getRoot(nums);
        Tree root = buildTree(rootMap);
        return root;
    }

    private static <T extends Comparable> HashMap<T, T> getRoot(T[] nums) {
        Stack<T> s = new Stack<>();
        HashMap<T, T> rootMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!s.isEmpty() && s.peek().compareTo(nums[i]) < 0) {
                T temp = s.pop();
                T root = null;
                if (!s.isEmpty())
                    root = s.peek().compareTo(nums[i]) > 0 ? nums[i] : s.peek();
                else
                    root = nums[i];
                rootMap.put(temp, root);
                i--;
            } else {
                s.push(nums[i]);
            }
        }

        while (!s.isEmpty()) {
            T temp = s.pop();
            if (s.isEmpty())
                rootMap.put(temp, null);
            else
                rootMap.put(temp, s.peek());
        }

        return rootMap;
    }

    private static <T> Tree buildTree(HashMap<T, T> rootMap) {
        HashMap<T, Tree> treeMap = new HashMap<>();
        Tree rootNode = null;
        //可优化为一个for循环
        for (T r : rootMap.keySet()) {
            treeMap.put(r, new Tree(r));
        }
        for (T r : rootMap.keySet()) {
            T rootIndex = rootMap.get(r);
            if (rootIndex == null) {
                rootNode = treeMap.get(r);
                continue;
            }
            Tree root = treeMap.get(rootIndex);
            if (root.leftSon == null)
                root.leftSon = treeMap.get(r);
            else if (root.rightSon == null)
                root.rightSon = treeMap.get(r);
            else
                Logger.getGlobal().warning("Error!");
        }
        return rootNode;
    }

}

class Tree<T> {
    T data;
    Tree leftSon;
    Tree rightSon;

    public Tree(T data) {
        this.data = data;
    }
   /* public Tree(T data,Tree leftSon,rightSon) {
        this.data = data;
        this.leftSon = leftSon;
        this.rightSon = rightSon;
    }*/
}
