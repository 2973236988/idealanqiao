import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

/**
 * @Description:
 * @Class: demo
 * @Package: PACKAGE_NAME
 * @Author: hedgeway
 * @CreateTime: 2023/3/13 16:08
 */
class ThreadedBinaryTree {
    private Node root;
    private Node prev; // 用于记录中序遍历中的前驱节点

    public void insert(int val) {
        root = insert(root, val);
    }

    private Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else if (val > node.val) {
            node.right = insert(node.right, val);
        }
        return node;
    }

    public void inorderThread() {
        prev = null;
        inorderThread(root);
    }

    private void inorderThread(Node node) {
        if (node == null) {
            return;
        }
        inorderThread(node.left);
        if (prev != null) {
            prev.right = node;
            prev.isThreaded = true;
        }
        node.left = prev;
        prev = node;
        inorderThread(node.right);
    }

    public int[] toArray() {
        List<Integer> list = new ArrayList<>();
        Node node = root;
        while (node != null) {
            while (node.left != null && !node.left.isThreaded) {
                node = node.left;
            }
            list.add(node.val);
            if (node.isThreaded) {
                node = node.right;
            } else {
                node = node.right;
                while (node != null) {
                    node = node.left;
                }
            }
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    private static class Node {
        int val;
        Node left;
        Node right;
        boolean isThreaded; // 是否为线索

        public Node(int val) {
            this.val = val;
        }
    }
}


public class demo {
    public static void main(String[] args) {
        // 使用示例
        int[] arr = {4, 2, 6, 1, 3, 5, 7};
        ThreadedBinaryTree tree = new ThreadedBinaryTree();
        for (int val : arr) {
            tree.insert(val);
        }
        tree.inorderThread();
        int[] sortedArr = tree.toArray(); // 输出有序数组
        for (int i = 0; i < sortedArr.length; i++) {
            System.out.print(sortedArr[i] + " ");
        }
    }
}
