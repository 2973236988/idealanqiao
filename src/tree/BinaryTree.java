package tree;

import com.sun.istack.internal.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Class: BinaryTree
 * @Package: tree
 * @Author: hedgeway
 * @CreateTime: 2023/3/11 20:53
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





public class BinaryTree {


    public TreeNode rootNode;

    public BinaryTree() {
    }

    public BinaryTree(int[] data){
        for (int i = 0; i < data.length; i++) {
            Add_Node_To_Tree(data[i]);
        }
    }

    void Add_Node_To_Tree(int value){
        TreeNode currentNode =rootNode;
        if (rootNode == null){
            rootNode = new TreeNode(value);
            return;
        }


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

    public void InOrder(TreeNode node){
        if (node != null){
            InOrder(node.left_Node);
            System.out.print("[" + node.value + "] ");
            InOrder(node.right_Node);
        }
    }

    public void PreOrder(TreeNode node){
        if (node != null){
            System.out.print("[" + node.value + "] ");
            PreOrder(node.left_Node);
            PreOrder(node.right_Node);
        }
    }

    public void PostOrder(TreeNode node){
        if (node != null){
            PostOrder(node.left_Node);
            PostOrder(node.right_Node);
            System.out.print("[" + node.value + "] ");
        }
    }



    public static void main(String[] args) throws IOException {
//        int ArraySize = 5;
//        int tempdata;
//        int[]  content = new int[ArraySize];
//        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
//        System.out.println("请连续输入" + ArraySize + "个数据");
//        for (int i = 0; i < ArraySize; i++) {
//            System.out.println("请输入第" + (i+1) +"个数据");
//            tempdata = Integer.parseInt(keyin.readLine());
//            content[i] = tempdata;
//        }
//
//        BinaryTree binaryTree = new BinaryTree(content);
//        if (binaryTree != null){
//            System.out.println("yes");
//        }


        int i;
        int arr[] = {7,4,1,5,16,8,11,12,15,9,2};
        BinaryTree tree = new BinaryTree(arr);


        System.out.print("二叉树的内容\n");
        for (int j = 0; j < arr.length; j++) {
            System.out.print("[" + arr[j] + "] ");
        }

        System.out.println();
        System.out.print("前序遍历的结果：\n");
        tree.PreOrder(tree.rootNode);
        System.out.println();
        System.out.print("后序遍历的结果：\n");
        tree.PostOrder(tree.rootNode);
        System.out.println();
        System.out.print("中序遍历的结果：\n");
        tree.InOrder(tree.rootNode);
        System.out.println();
    }
}
