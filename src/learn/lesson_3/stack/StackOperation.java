package learn.lesson_3.stack;

public interface StackOperation<E> {
    /***
     * Pushes an item onto the top of the stack and returns
     * @param data The item to be pushed
     * @return Returns the item pushed
     */
    E push(E data);

    /***
     * Removes and returns the item at the top of the stack
     * @return  Returns the item at the top of the stack
     */
    E pop();

    /***
     *
     * @return Returns the item at the top of the stack without removing it
     */
    E peek();

    /***
     * Checks whether the stack is empty
     * @return Returns true if the stack is empty, false otherwise
     */
    boolean isEmpty();
}
