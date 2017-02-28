import java.util.Random;
import java.util.Stack;

/**
 * Created by peter on 2017/2/22.
 */
public class sortStackByStack {
    public static void main(String[] args){
        Stack<Integer> s = new Stack<>();
        Random r = new Random();
        for(int i =0;i<10;i++){
            s.push(r.nextInt(10));
        }
        for(Integer i : s)
            System.out.print(i+"|");
        new sortStackByStack().sort(s);
        System.out.println();
        for(Integer i : s)
            System.out.print(i+"|");

    }

    public < T extends Comparable > void sort(Stack<T> s){
        Stack<T> help = new Stack<>();
        while(!s.isEmpty()){
            T cur = s.pop();
            while(!help.isEmpty() && cur.compareTo(help.peek()) > 0){
                s.push(help.pop());
            }
            help.push(cur);
        }
        while(!help.isEmpty())
            s.push(help.pop());
    }

}
