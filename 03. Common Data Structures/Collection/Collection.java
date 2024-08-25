package Collection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public interface Collection<T> extends Iterable<T> {

    // Returns the number of elements in this collection
    int size();

    // Returns true if this collection contains no elements
    boolean isEmpty();

    // Returns true if this collection contains the specified element
    boolean contains(Object o);

    // Returns an iterator over the elements in this collection
    Iterator<T> iterator();

    // Returns an array containing all the elements in this collection
    Object[] toArray();

    // Returns an array containing all the elements in this collection
    // the runtime type of the returned array is that of the specified array
    <T1> T1[] toArray(T1[] a);

    // Ensures that this collection contains the specified element
    boolean add(T t);

    // Removes a single instance of the specified element from this collection, if it is present
    boolean remove(Object o);

    // Returns true if this collection contains all the elements in the specified collection
    boolean containsAll(Collection<?> c);

    // Adds all the elements in the specified collection to this collection
    boolean addAll(Collection<? extends T> c);

    // Removes all of this collection's elements that are also contained in the specified collection
    boolean removeAll(Collection<?> c);

    // Retains only the elements in this collection that are contained in the specified collection
    boolean retainAll(Collection<?> c);

    // Removes all the elements from this collection
    void clear();

    // Compares the specified object with this collection for equality
    boolean equals(Object o);

    // Returns the hash code value for this collection
    int hashCode();
}
