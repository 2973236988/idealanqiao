package calculatetree;

/**
 * @Description:
 * @Class: Expression_Tree
 * @Package: calculatetree
 * @Author: hedgeway
 * @CreateTime: 2023/3/11 23:16
 */
public class Expression_Tree extends Binary_Search_Tree{
    public Expression_Tree(char[] information, int index){
        rootNode = create(information,index);
    }

    public TreeNode create(char[] sequence,int index){
        TreeNode tempNode;
        if (index >= sequence.length){
            return null;
        }else {
            tempNode = new TreeNode((int) sequence[index]);
            tempNode.left_Node = create(sequence,2*index);
            tempNode.right_Node = create(sequence,2*index+1);
            return tempNode;
        }
    }
    public void InOrder(TreeNode node){
        if (node != null){
            InOrder(node.left_Node);
            System.out.print((char)node.value);
            InOrder(node.right_Node);
        }
    }

    public void PreOrder(TreeNode node){
        if (node != null){
            System.out.print((char)node.value);
            PreOrder(node.left_Node);
            PreOrder(node.right_Node);
        }
    }

    public void PostOrder(TreeNode node){
        if (node != null){
            PostOrder(node.left_Node);
            PostOrder(node.right_Node);
            System.out.print((char)node.value);
        }
    }

    public int condition(char oprator, int num1, int num2){
        switch (oprator){
            case '*': return (num1 * num2);
            case '/': return (num1 / num2);
            case '+': return (num1 + num2);
            case '-': return (num1 - num2);
            case '%': return (num1 % num2);
        }
        return -1;
    }


    public int answer(TreeNode node){
        int firstnumber = 0;
        int secondnumber = 0;
        if (node.left_Node == null && node.right_Node == null){
            return Character.getNumericValue((char)node.value);
        }else {
            firstnumber = answer(node.left_Node);
            secondnumber = answer(node.right_Node);
            return condition((char) node.value,firstnumber,secondnumber);
        }
    }


    public static void main(String[] args) {
        char[] information1 = {' ','+','*','%','6','3','9','5'};
        char[] information2 = {' ','+','+','+','*','%','/','*','1','2','3','2','6','3','2','2'};
        Expression_Tree exp1 = new Expression_Tree(information1,1);
        System.out.println("====二叉运算树数值运算范例1：====");
        System.out.println("===============================");
        System.out.println("===转换成前序表达式===");
        exp1.InOrder(exp1.rootNode);
        System.out.println();
        System.out.println("===转换成中序表达式===");
        exp1.PreOrder(exp1.rootNode);
        System.out.println();
        System.out.println("===转换成后序表达式===");
        exp1.PostOrder(exp1.rootNode);

        System.out.println("\n此二叉运算树，经过计算后所得到的结果值：");
        System.out.println(exp1.answer(exp1.rootNode));

        System.out.println();
        Expression_Tree exp2 = new Expression_Tree(information2,1);
        System.out.println("====二叉运算树数值运算范例2：====");
        System.out.println("===============================");
        System.out.println("===转换成前序表达式===");
        exp1.InOrder(exp2.rootNode);
        System.out.println();
        System.out.println("===转换成中序表达式===");
        exp1.PreOrder(exp2.rootNode);
        System.out.println();
        System.out.println("===转换成后序表达式===");
        exp1.PostOrder(exp2.rootNode);

        System.out.println("\n此二叉运算树，经过计算后所得到的结果值：");
        System.out.println(exp1.answer(exp2.rootNode));
    }
}
