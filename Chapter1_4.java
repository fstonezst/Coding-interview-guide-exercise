import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class DogCatQueue{
    private Queue<Pet> firstQ ;
    private Queue<Pet> secondQ;

    public static void main(String[] args){
        Dog d = new Dog();
        Cat c = new Cat();
        DogCatQueue q = new DogCatQueue();
        for(int i =0;i <10;i++) {
            Random r = new Random();
            if (r.nextBoolean() == true)
                 q.add(d);
            else
                q.add(c);
        }

        q.printQ();
        System.out.println(q.pollAll().getType());
        q.printQ();
        System.out.println(q.pollCat().getType());
        q.printQ();
        System.out.println(q.pollDog().getType());
        q.printQ();
        System.out.println(q.isQEmpty()+"");
        q.printQ();
        System.out.println(q.isDogQueueEmpty()+"");
        q.printQ();
        System.out.println(q.isCatQueueEmpty()+"");
        q.printQ();

        q.printQ();
        q.add(c);
        q.printQ();

    }


    public DogCatQueue(){
        firstQ = new LinkedList<Pet>();

        //secondQ中只可能存在猫或者狗，不可能同时存在猫狗。
        secondQ = new LinkedList<Pet>();

    }

    public void printQ(){
        System.out.println();
        for( Pet p: this.secondQ)
            System.out.print(p.getType()+"|");
        for( Pet p: this.firstQ)
            System.out.print(p.getType()+"|");
        System.out.println();
    }

    public void add(Pet pet){
        this.firstQ.add(pet);
    }

    public Pet pollAll(){
        if(this.secondQ.isEmpty())
            return this.firstQ.poll();
        else if (this.firstQ.isEmpty())
            throw new RuntimeException("err,queue is empty!");
        else
            return this.secondQ.poll();
    }

    public Dog pollDog(){
        if(this.secondQ.isEmpty() || this.secondQ.peek().getType().equals("Cat")) {
            while (!this.firstQ.isEmpty() && this.firstQ.peek().getType().equals("Cat"))
                this.secondQ.add(this.firstQ.poll());
            if (this.firstQ.isEmpty())
                throw new RuntimeException("err,Dog is empty!");
            else
                return (Dog)this.firstQ.poll();
        }else{
            return (Dog)this.secondQ.poll();
        }
    }

    public Cat pollCat(){
        if(this.secondQ.isEmpty() || this.secondQ.peek().getType().equals("Dog")) {
            while (!this.firstQ.isEmpty() && this.firstQ.peek().getType().equals("Dog"))
                this.secondQ.add(this.firstQ.poll());
            if (this.firstQ.isEmpty())
                throw new RuntimeException("err,Cat is empty!");
            else
                return (Cat)this.firstQ.poll();
        }else{
            return (Cat)this.secondQ.poll();
        }
    }

    public boolean isQEmpty(){
        return this.secondQ.isEmpty() && this.firstQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        if(!this.secondQ.isEmpty() && this.secondQ.peek().getType().equals("Dog"))
            return false;
        else {
            while (!this.firstQ.isEmpty() && this.firstQ.peek().getType().equals("Cat"))
                this.secondQ.add(this.firstQ.poll());
            if (this.firstQ.isEmpty())
                return true;
            else
                return false;
        }
    }

    public boolean isCatQueueEmpty(){
        if(!this.secondQ.isEmpty() && this.secondQ.peek().getType().equals("Cat"))
            return false;
        else {

            while (!this.firstQ.isEmpty() && this.firstQ.peek().getType().equals("Dog"))
                this.secondQ.add(this.firstQ.poll());
            if (this.firstQ.isEmpty())
                return true;
            else
                return false;
        }
    }

}

class Pet{
    private String type;
    public Pet(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }
}
class Cat extends Pet{
    public Cat(){
        super("Cat");
    }
}
class Dog extends Pet{
    public Dog(){
        super("Dog");
    }
}