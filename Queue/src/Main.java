public class Main {
    public static void main(String[] args) {
        Queue<Integer> x = new Queue<Integer>();
        x.enqueue(1);
        x.enqueue(2);
        x.enqueue(3);

        for(Integer i: x){
            System.out.println(i);
        }
        System.out.println("Size = " + x.size());

        System.out.println(x.dequeue());
        System.out.println(x.dequeue());
        System.out.println(x.dequeue());

        System.out.println("Size = " + x.size());
        System.out.println("Is empty? " + x.isEmpty());
    }
}