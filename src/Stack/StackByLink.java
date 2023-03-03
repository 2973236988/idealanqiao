package Stack;

/**
 * @Description:
 * @Class: StcakByLink
 * @Package: Stack
 * @Author: hedgeway
 * @CreateTime: 2023/3/2 23:03
 */

class Node{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackByLink {
    public Node front;
    public Node rear;

    //类方法：isEmpty()
    //判断堆栈如果为空堆栈，则front == null
    public boolean isEmpty() {
        return front == null;
    }


    //类方法：output_of_Stack
    //打印堆栈内容
    public void output_of_Stack() {
        Node current = front;
        while(current != null) {
            System.out.println("[" + current.data +"]");
            current = current.next;
        }
        System.out.println();
    }


    //类方法：insert()
    //在堆栈顶端加入数据
    private void insert(int data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            front = newNode;
            rear = newNode;
        }else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void pop(){
        Node newNode;
        if (this.isEmpty()){
            System.out.println("====目前为空堆栈====");
            return;
        }
        newNode = front;
        if (newNode == rear){
            front = null;
            rear = null;
            System.out.println("=====目前为空堆栈=====");
        }else {
            while (newNode.next != rear){
                newNode = newNode.next;
                newNode.next = rear.next;
                rear = newNode;
            }
        }
    }
}