/**
 * Created by peter on 2017/3/3.
 */
public class Chapter2_5 {

    /**
     * 反转带头结点链表的指定部分
     * @param head 链表的头结点
     * @param from 反转开始位置
     * @param to  反转结束位置
     * @return 链表的头结点
     */
    public static Node reversePart(Node head,int from, int to)
    {

        //参数合法性判断
        if(head == null || from >= to || from <= 0)
            return head;

        //找到第from个节点
        int c = 0;
        Node fromHead = head,cur,pre;
        while(c < from -1 ){
            fromHead = fromHead.next;
            c ++;
        }

        //pre指向第from个节点，依次把pre后面的节点(cur)用头插法插到fromHead之后
        pre = fromHead.next;
        cur = pre.next;
        c ++;
        while(c < to && cur != null)
        {
            pre.next = cur.next;
            cur.next = fromHead.next;
            fromHead.next = cur;
            cur = pre.next;
            c ++;
        }

        //若c<to说明 to大于链表长度
        //这里有一个问题 就是参数不合法的情况下 依然修改了链表
        if ( c < to )
            System.out.println("Error!");
        return head;
    }

}
