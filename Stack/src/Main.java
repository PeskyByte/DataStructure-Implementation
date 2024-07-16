public class Main {
    public static void main(String[] args) {
        LinkedListBasedStack<Integer> s = new LinkedListBasedStack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s.size());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.isEmpty());
    }
}