package sample.Collection;

import sample.Exceptions.Underflow;


public interface UnboundedQueueInterface<data> {

    boolean isEmpty();

    String dequeue() throws Underflow;

    void enqueue(data vertex);

}