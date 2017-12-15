package sample.Collection;
import sample.Exceptions.Overflow;
import sample.Exceptions.Underflow;

public interface UnboundedStackInterface<data> {

    String push(String startVertex) throws Overflow;

    String top(String vertex) throws Underflow;

    void pop() throws Underflow;

    boolean isEmpty();

}
