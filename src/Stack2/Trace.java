package Stack2;


class Node{
    int x;
    int y;
    Node next;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
        this.next =null;
    }
}


class TraceRecord {
    public Node first;
    public Node last;
    public boolean isEmpty(){
        return  first == null;
    }

    public void insert(int x, int y){
        Node newNode = new Node(x,y);
        if (this.isEmpty()){
            first = newNode;
            last = newNode;
        }else {
            last.next = newNode;
            last = newNode;
        }
    }


    public void delete(){
        Node newNode;
        if (this.isEmpty()){
            System.out.println("[队列已经空了]\n");
            return;
        }
        newNode = first;
        while (newNode.next != last){
            newNode = newNode.next;
        }
        newNode.next = last.next;
        last = newNode;
    }
}

public class Trace {
    public static int ExitX = 8;
    public static int ExitY = 10;
    public static int[][] MAZE = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

    public static void main(String[] args) {
        int i, j, x, y;
        TraceRecord path = new TraceRecord();
        x = 1;
        y = 1;
        System.out.println("[迷宫的路径(0的部分)]\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }

        while (x <= ExitX && y <= ExitY) {
            MAZE[x][y] = 2;
            if (MAZE[x - 1][y] == 0) {
                x -= 1;
                path.insert(x, y);
            }else if (MAZE[x + 1][y] == 0)  {
                x += 1;
                path.insert(x, y);
            } else if (MAZE[x][y + 1] == 0) {
                y += 1;
                path.insert(x, y);
            } else if (MAZE[x][y - 1] == 0){
                x += 1;
                path.insert(x, y);
            } else if (chkExit(x, y, ExitX, ExitY) == 1) {
                break;
            } else {
                MAZE[x][y] = 2;
                path.delete();
                x = path.last.x;
                y = path.last.y;
            }
        }
        System.out.println("[老鼠走过的路径(2的部分)]\n");
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 12; j++) {
                System.out.print(MAZE[i][j]);
            }
            System.out.println();
        }
    }

    public static int chkExit(int x, int y, int ex, int ey) {
        if (x == ex && y == ey) {
            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2) {
                return 1;
            }

            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 2 || MAZE[x][y + 1] == 2) {
                return 1;
            }

            if (MAZE[x - 1][y] == 1 || MAZE[x + 1][y] == 2 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2) {
                return 1;
            }

            if (MAZE[x - 1][y] == 2 || MAZE[x + 1][y] == 1 || MAZE[x][y - 1] == 1 || MAZE[x][y + 1] == 2) {
                return 1;
            }
        }
        return 0;
    }
}