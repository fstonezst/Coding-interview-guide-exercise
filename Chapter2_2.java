/**
 * Created by peter on 2017/3/2.
 */
public class Chapter2_2 {
    public static void main(String[] args){
        Integer[] list = new Integer[]{1,2,3,4,5};
        Node head = buildList(list);
        System.out.print(removeLastKthNode(head,3).data+"|");
    }

    public static Node removeLastKthNode(Node head, int k){
        //head 为头指针
        if(head == null || k < 1)
            throw new RuntimeException("Error input!");
        Node p = head;
        Node km = head;
        while(k>0 && p != null){
            p = p.next;
            k--;
        }
        if( k > 0)
            throw new RuntimeException("head length leass than k!");
        else if (p == null){
            head = head.next;
            return km;
        }else{
            while(p.next != null){
                p= p.next;
                km = km.next;
            }
            p = km.next;
            km.next = p.next;
            return p;
        }

    }

    public static DoubleNode removeLastKthNode(DoubleNode head,int k){
        if(head == null || k < 1)
            throw new RuntimeException("Error input");
        DoubleNode p = head;
        int c = k;
        while(p.next != null ){
            p = p.next;
            c--;
        }
        if(c > 1)
            return null;
        else if (c == 1)
            return head;
        p = head;
        while(c < 0){
            c ++;
            p = p .next;
        }
        p.last.next = p.next;
        p.next.last = p .last;
        return p;
    }

    static class Node <T extends Comparable>{
        T data ;
        Node next;
        public Node(T data){
            this.data = data;
        }
    }

    static class DoubleNode<T> {
        T data;
        DoubleNode next;
        DoubleNode last;
        public DoubleNode(T data){
            this.data = data;
        }
    }

    public static <T extends Comparable> Node buildList(T[] list){
        Node head = new Node(list[0]);
        Node p = head;
        for(int i = 1;i<list.length;i++){
            Node newNode  = new Node(list[i]);
            p.next = newNode;
            newNode.next = null;
            p = newNode;
        }
        return head;
    }
}
