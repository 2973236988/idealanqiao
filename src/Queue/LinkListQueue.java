package Queue;

import javax.xml.namespace.QName;

/**
 * @Description:
 * @Class: LinkListQueue
 * @Package: Queue
 * @Author: hedgeway
 * @CreateTime: 2023/3/5 15:26
 */

class QueueNode{
    int data;
    QueueNode next;
    public QueueNode(int data){
        this.data =data;
        next =null;
    }
}


public class LinkListQueue {
    public QueueNode front;
    public QueueNode rear;

    public LinkListQueue() {
        this.front = null;
        this.rear = null;
    }

    public Boolean enqueue(int value){
        QueueNode node = new QueueNode(value);
        if (rear == null){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;
        return true;
    }


    public int dequeue(){
        int value;
        if (!(front==null)){
            if (front==rear){
                rear = null;
            }
            value = front.data;
            front = front.next;
            return value;
        }else {
            return -1;
        }
    }
}
