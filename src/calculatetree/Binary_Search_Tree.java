package calculatetree;

/**
 * @Description:
 * @Class: Binary_Search_Tree
 * @Package: calculatetree
 * @Author: hedgeway
 * @CreateTime: 2023/3/11 23:13
 */
public class Binary_Search_Tree {
    public TreeNode rootNode;
    public Binary_Search_Tree(){
        rootNode = null;
    }
    public Binary_Search_Tree(int[] data){
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


}
