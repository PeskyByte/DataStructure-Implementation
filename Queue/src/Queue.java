import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<E> implements Iterable<E>{

    private Node<E> head, tail;
    private int size;

    public Queue(){
        head = null;
        tail = null;
        size = 0;
    }
    public void enqueue(E item){
        if(item == null) throw new IllegalArgumentException();
        if(isEmpty()){
            tail = new Node<E>(item);
            head = tail;
        }
        else{
            Node<E> oldTail = tail;
            tail = new Node<E>(item);
            oldTail.setNext(tail);
        }
        size++;
    }

    public E dequeue(){
        if(isEmpty()) throw new NoSuchElementException();
        E item = head.getItem();
        head = head.getNext();
        size--;
        if(isEmpty()) tail = null;
        return item;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<E> iterator(){
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<E>{
        private Node<E> x = head;
        @Override
        public boolean hasNext() {
            return x != null;
        }

        @Override
        public E next() {
            if(!hasNext()) throw new NoSuchElementException();
            E item = x.getItem();
            x = x.getNext();
            return item;
        }
    }
}