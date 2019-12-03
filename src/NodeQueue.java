import java.util.LinkedList;

/**
 * This class is for completion in Practical 3iii
 * The Node class is supplied for you
*/
public class NodeQueue<E> implements QueueADT<E>
{
    // references to the head and tail of 
    // the linked list
    protected Node<E> head, tail;   
    // number of elements in the queue
    protected int size;
    private LinkedList<E> linkedList;

    /** constructs an empty queue
    */
    public NodeQueue() {    
       head = null; tail = null;
       size = 0;
       linkedList = new LinkedList<>();
    }
    
   // Complete the method bodies below. Take care
   // that exceptions of the correct types are thrown by 
   // your methods as specified in the method comments.
   
    public int size() {
        return linkedList.size();
    }
    
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    
    public void enqueue(E elem) {
    // create and link in a new node at tail
        linkedList.add(elem);
    }

    /**
     @throws EmptyQueueException
    */
    public E front() {      //peek
        if(isEmpty()){
            throw new EmptyQueueException("empty");
        }
        return linkedList.get(0);
    }

    /**
     @throws EmptyQueueException
    */
    public E dequeue() {
        if(isEmpty()){
            throw new EmptyQueueException("empty");
        }
        return linkedList.pop();
    }
}
