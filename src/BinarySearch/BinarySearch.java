package BinarySearch;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Class: BinarySearch
 * @Package: BinarySearch
 * @Author: hedgeway
 * @CreateTime: 2023/3/12 16:12
 */

class TreeNode{
    int value;
    TreeNode left_Node;
    TreeNode right_Node;

    public TreeNode(int value){
        this.value = value;
        this.left_Node = null;
        this.right_Node = null;
    }

}

public class BinarySearch {
    public TreeNode rootNode;
    public static int count = 1;
    public void Add_Node_To_Tree(int value){
        if (rootNode == null){
            rootNode = new TreeNode(value);
            return;
        }

        TreeNode currentNode = rootNode;
        while (true){
            if (value < currentNode.value){
                if (currentNode.left_Node == null){
                    currentNode.left_Node = new TreeNode(value);
                    return;
                }else {
                    currentNode = currentNode.left_Node;
                }
            }else {
                if (currentNode.right_Node == null){
                    currentNode.right_Node = new TreeNode(value);
                    return;
                }else {
                    currentNode = currentNode.right_Node;
                }
            }
        }
    }

    public boolean findTree(TreeNode node, int value){
        if (node == null){
            return false;
        }else if(node.value == value){
            System.out.println("共搜索" + count + "次\n");
            return true;
        }else if (value < node.value){
            count += 1;
            return findTree(node.left_Node,value);
        }else {
            count += 1;
            return findTree(node.right_Node,value);
        }
    }

    public static void main(String[] args) throws IOException {
        int i,value;
        int arr[]  = {7,4,1,5,13,8,11,12,15,9,2};
        System.out.print("原始数组内容：\n");
        for ( i = 0; i < 11; i++) {
            System.out.print("[" + arr[i] + "] ");
        }

        BinarySearch tree = new BinarySearch();
        for (i = 0; i < 11; i++) {
            tree.Add_Node_To_Tree(arr[i]);
        }

        System.out.println();
        System.out.print("请输入搜索值：");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        value = Integer.parseInt(bufferedReader.readLine());
        if (tree.findTree(tree.rootNode,value)){
            System.out.println("找到了" + value);
        }else {
            System.out.println("没找到");
        }
    }

}
