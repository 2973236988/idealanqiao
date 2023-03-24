package Queue;

/**
 * @Description:
 * @Class: CirculaQueue
 * @Package: Queue
 * @Author: hedgeway
 * @CreateTime: 2023/3/5 18:05
 */

/**
 * 如果rear和front的初始值都为-1，那么在插入第一个元素时，
 * 需要将rear和front都加1，这样就多了一步操作。而且，在计算队列长度时，
 * 需要用(rear-front+maxsize)%maxsize来避免负数的情况，这样也增加了复杂度。
 *
 * 如果rear和front的初始值都为0，那么在插入第一个元素时，
 * 只需要将rear加1即可。而且，在计算队列长度时，
 * 可以直接用(rear-front+maxsize)%maxsize来得到结果。
 *
 * 因此，使用0作为rear和front的初始值是一种更简洁和高效的方式。
 */
public class CircularQueue {
        private int[] data; //存放数据元素的数组
        private int front; //头指针，指向队首元素
        private int rear; //尾指针，指向队尾元素的下一个位置
        private int maxSize;
        private int size; //队列中元素个数

        //初始化循环队列
        public CircularQueue(int maxSize) {
            data = new int[maxSize]; //创建容量为capacity的数组
            this.front = 0; //头指针置为零，表示空队列
            this.rear = 0;
            this.size = 0;
            this.maxSize = maxSize;
        }

        //队列是否满
        public boolean isFull(){
            return (rear+1)%maxSize == front;
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false; //判断队列是否已满
            }
            data[rear] = value; //将新元素放入尾指针所在位置
            rear = (rear + 1) % data.length; //更新尾指针
            size++; //增加元素个数
            return true;
        }

        //队列是否为空
        public boolean isEmpty(){
            return rear == front;
        }

        //出队操作
        public boolean deQueue() {
            //判断队列是否为空
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % data.length; //更新头指针
            size--; //减少元素个数
            return true;
        }

}

