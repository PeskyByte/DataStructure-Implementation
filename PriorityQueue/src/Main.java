public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> x = new PriorityQueue<>();
        x.insert(3);
        x.insert(1);
        x.insert(2);
        x.insert(3);
        System.out.println(x.size());
        System.out.println(x.pop());
        System.out.println(x.pop());
        System.out.println(x.pop());
        System.out.println(x.pop());
    }
}