package Queue;

import org.junit.Test;

import javax.xml.namespace.QName;

/**
 * @Description:
 * @Class: FirstQueue
 * @Package: Queue
 * @Author: hedgeway
 * @CreateTime: 2023/3/5 21:12
 */
class Queue_Node{
    int data;
    Queue_Node next;
    public Queue_Node(int data){
        this.data = data;
        next =null;
    }
}

public class DoubleEndQueue {
    public Queue_Node front;
    public Queue_Node rear;

    public DoubleEndQueue(){
        front =null;
        rear = null;
    }

    //队列数据的存入
    public boolean enqueue(int value){
        Queue_Node node = new Queue_Node(value);
        if (rear == null){
            front = node;
        }else {
            rear.next = node;
        }
        rear = node;
        return true;
    }

    //方法dequeue:队列数据的取出
    public int dequeue(int action){
        int value;
        Queue_Node tempNode,startNode;
        if (!(front == null) && action ==1){
            if (front == rear){
                rear = null;
            }
            value = front.data;
            front = front.next;
            return value;
        }else if (!(rear == null) && action == 2){
            startNode = front;
            value = rear.data;
            tempNode = front;
            while (front.next != rear && front.next !=null){
                front = front.next;
                tempNode = front;
            }
            front = startNode;
            rear= tempNode;
            if (front.next == null || rear.next ==null){
                front = null;
                rear = null;
            }
            return value;
        }else {
            return -1;
        }
    }

    @Test
    public void test(){
        DoubleEndQueue queue = new DoubleEndQueue();
        int temp;
        System.out.println("以链表来实现双向队列");
        System.out.println("======================================");
        System.out.println("在双向队列前端加入第1个数据，此数据值为1");
        queue.enqueue(1);
        System.out.println("在双向队列前端加入第2个数据，此数据值为3");
        queue.enqueue(3);
        System.out.println("在双向队列前端加入第3个数据，此数据值为5");
        queue.enqueue(5);
        System.out.println("在双向队列前端加入第4个数据，此数据值为7");
        queue.enqueue(7);
        System.out.println("在双向队列前端加入第5个数据，此数据值为9");
        queue.enqueue(9);

        System.out.println("======================================");
        temp = queue.dequeue(1);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(2);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(1);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(2);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);
        temp = queue.dequeue(1);
        System.out.println("从双向队列前端依序取出的元素数据值为：" + temp);


    }


}

