package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            }
            newNode.next = rear.next;
            rear = newNode;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader buf;
        buf = new BufferedReader(new InputStreamReader(System.in));
        StackByLink stack_by_linkedlist = new StackByLink();
        int choice =0;
        while (true){
            System.out.println("(0)结束(1)再堆栈中加入数据(2)弹出堆栈数据");
            choice = Integer.parseInt(buf.readLine());
            if (choice == 2){
                stack_by_linkedlist.pop();
                System.out.println("数据弹出后的堆栈内容");
                stack_by_linkedlist.output_of_Stack();
            }else if (choice == 1){
                System.out.println("请输入要加入堆栈的数据：");
                choice = Integer.parseInt(buf.readLine());
                stack_by_linkedlist.insert(choice);
                System.out.println("数据加入后的堆栈内容");;
                stack_by_linkedlist.output_of_Stack();
            }else if (choice == 0){
                break;
            }else {
                System.out.println("输入错误！！！");
            }
        }
    }

}

