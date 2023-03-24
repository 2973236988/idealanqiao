package BinarySortTree;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Description:
 * @Class: BinarySortTree
 * @Package: BinarySortTree
 * @Author: hedgeway
 * @CreateTime: 2023/3/12 15:52
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

public class BinarySortTree {
    public TreeNode rootNode;

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


    public void InOrder(TreeNode node){
        if (node != null){
            InOrder(node.left_Node);
            System.out.println("[" + node.value + "]");
            InOrder(node.right_Node);
        }
    }

    public void PreOrder(TreeNode node){
        if (node != null){
            System.out.println("[" + node.value + "]");
            InOrder(node.left_Node);
            InOrder(node.right_Node);
        }
    }

    public void PostOrder(TreeNode node){
        if (node != null){
            InOrder(node.left_Node);
            InOrder(node.right_Node);
            System.out.println("[" + node.value + "]");
        }
    }


    public static void main(String[] args) throws IOException {
        int value;
        BinarySortTree tree = new BinarySortTree();
        BufferedReader keyin = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入数据，结束请输入-1：\n");
        while (true){
            value = Integer.parseInt(keyin.readLine());
            if (value == -1){
                break;
            }
            tree.Add_Node_To_Tree(value);
        }
        System.out.println("================:\n");
        System.out.println("排序后的结果：");
        tree.InOrder(tree.rootNode);
        System.out.println("\n");
    }
}
