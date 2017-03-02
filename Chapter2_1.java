/**
 * Created by peter on 2017/3/2.
 */
public class Chapter2_1 {

    public void printCommonPart(Node list1,Node list2){
        Node p1 = list1 ,p2 = list2;
        while (p1 != null && p2 != null){
            int re = p1.data.compareTo(p2.data);
            if(re == 0){
                System.out.print(p1.data + ",");
                list1 = list1.next;
                list2 = list2.next;
            }else if (re < 0){
                list1 = list1.next;
            }else{
                list2 = list2.next;
            }
        }
    }

    class Node <T extends Comparable>{
        T data ;
        Node next;
        public Node(T data){
            this.data = data;
        }
    }
}

