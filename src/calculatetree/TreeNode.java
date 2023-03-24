package calculatetree;

/**
 * @Description:
 * @Class: TreeNode
 * @Package: calculatetree
 * @Author: hedgeway
 * @CreateTime: 2023/3/11 23:12
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