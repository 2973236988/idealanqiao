package Queue;

/**
 * @Description:
 * @Class: LinkListQueueTest
 * @Package: Queue
 * @Author: hedgeway
 * @CreateTime: 2023/3/5 15:31
 */
public class LinkListQueueTest {
    public static void main(String[] args) {
        LinkListQueue linkListQueue = new LinkListQueue();
        int tmp;
        System.out.println("以链表来实现队列");
        System.out.println("============================");
        System.out.println("在队列前端加入第1个数据，此数据值为1");
        linkListQueue.enqueue(1);
        System.out.println("在队列前端加入第2个数据，此数据值为2");
        linkListQueue.enqueue(3);
        System.out.println("在队列前端加入第3个数据，此数据值为3");
        linkListQueue.enqueue(5);
        System.out.println("在队列前端加入第4个数据，此数据值为4");
        linkListQueue.enqueue(7);
        System.out.println("在队列前端加入第5个数据，此数据值为5");
        linkListQueue.enqueue(9);
        System.out.println("============================");
        while (true){
            if (!(linkListQueue.front == null)){
                tmp = linkListQueue.dequeue();
                System.out.println("从队列前端依序取出的元素数据值为："+tmp);
            }else {
                break;
            }
        }
        System.out.println();
    }
}
