import java.util.NoSuchElementException;

/**
 * This class is for completion in practical 3 part i
*/

public class ArrayQueue<E> implements QueueADT<E>
{
   /*
   note, I changed the variable names here because Q, f, r and N are awful identifiers.
    */

   protected E[] queue; // Q will refer to the array
   protected int front; // front - array index of element at front of queue
   protected int rear; // rear - array index of where next element added will be placed
   protected int capacity;  // array capacity

   /**
    * Constructor for objects of class ArrayQueue.
    * In practical 3i no change need be made to this constructor.
    * With this constructor a queue can hold up to 3 (i.e.N-1) items when 
    * using the approach described in lectures.
    */
   public ArrayQueue()
   {
       capacity =4;
       queue = (E[]) new Object[capacity];
       front =0;
       rear =0;
   }
    
   // In practical 3i complete the methods below using an array 
   // implementation where the queue is considered full if the 
   // queue size is one less than the array capacity. Pseudo code
   // is provided in lecture handout 4 slides 7 and 8.
   // Take care that exceptions of the correct types are 
   // thrown by your methods as specified in the method comments.
   
   /** 
     @throws FullQueueException
   */
   public void enqueue(E element){
      if(size() == capacity-1){
         throw new FullQueueException("full");
      }
      queue[rear] = element;
      rear++;
   }

   /**
     @throws EmptyQueueException
   */
   public E dequeue(){
      if(isEmpty()){
         throw new EmptyQueueException("Queue empty");
      }
      E returnMe = queue[front];
      front = increment(front);
      return returnMe;
   }

   private int increment(int front) {
      if(front == rear){
         rear = 0;
         this.front = 0;
         return 0;
      }
      return ++front;
   }

   /**
     @throws EmptyQueueException
   */
   public E front(){
      if(isEmpty()){
         throw new EmptyQueueException("Empty");
      }
      return queue[front];
   }

   public int size(){
      int count = 0;
      for (int i = front; i < rear; i++){
         count++;
      }
      return count;
   }

   public boolean isEmpty(){
      return (front - rear) == 0;
   }  
}
