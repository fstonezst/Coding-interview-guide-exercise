/**
 * Created by peter on 2017/3/2.
 */
public class Chapter2_3 {

    public static Node removeByRatio(Node head, int a, int b){
        if(head == null || a > b || a < 1)
            return null;
        double r = (double)a/b;
        Node p = head;
        Node de = new Node(null);
        de.next = p;
        int len = 0;
        int deIndex = 0;
        while (p!= null){
            len ++;
            int newDeIndex = (int)Math.ceil(r*len) - 1;
            for ( int i = deIndex;i < newDeIndex;i ++)
                de = de.next;
            deIndex = newDeIndex;
            p = p.next;
        }
        p = de.next;
        de.next = de.next.next;
        return p;
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

    /*static class Node <T>{
        T data ;
        Node next;
        public Node(T data){
            this.data = data;
        }
    }*/
}
