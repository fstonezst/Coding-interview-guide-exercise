/**
 * Created by peter on 2017/3/3.
 */

public class Test {

    public static void main(String[] args){

    }

    public static void testChapter2_2(){

        Integer[] list = new Integer[]{1,2,3,4,5};
        Node head = buildList(list);
        System.out.print(Chapter2_2.removeLastKthNode(head,3).data+"|");

    }

    public static void testChapter2_3(){
        Integer[] list = new Integer[]{0,1,2,3,4,5};
        Node head = buildList(list);
        System.out.print(Chapter2_3.removeByRatio(head,9,10).data+"|");
    }

    public static void testChapter2_5(){
        Integer[] list = new Integer[]{0,1,2,3,4,5};
        Node head = buildList(list);
        printList(Chapter2_5.reversePart(head,1,1));
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
    
    public static void printList(Node head){
        while(head!=null){
            System.out.print(head.data+",");
            head = head.next;
        }
        System.out.println();
    }

}
