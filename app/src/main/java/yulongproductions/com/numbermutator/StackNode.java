package yulongproductions.com.numbermutator;

/**
 * Created by Yulong on 4/1/2016.
 */
public class StackNode<E> {
    public E data;
    public StackNode next;

    public StackNode(E e) {
        this(e, null);
    }

    public StackNode(E e, StackNode next) {
        this.data = e;
        this.next = next;
    }
}
