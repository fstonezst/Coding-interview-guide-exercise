/**
 * Created by peter on 2017/3/3.
 */
class Node <T extends Comparable>{
    T data ;
    Node next;
    public Node(T data){
        this.data = data;
    }
}
class DoubleNode<T> {
    T data;
    DoubleNode next;
    DoubleNode last;
    public DoubleNode(T data){
        this.data = data;
    }
}