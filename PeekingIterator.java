// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peek;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator  = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peek == null) peek = iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peek != null) {
            Integer res = peek;
            peek = null;
            return res;
        } else return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (peek != null) return true;
        else return iterator.hasNext();
    }
}

//Generic version

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator<E> implements Iterator<E> {
    Iterator<E> iterator;
    E peek;
    public PeekingIterator(Iterator<E> iterator) {
        // initialize any member here.
        this.iterator  = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public E peek() {
        if (peek == null) peek = iterator.next();
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public E next() {
        if (peek != null) {
            E res = peek;
            peek = null;
            return res;
        } else return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (peek != null) return true;
        else return iterator.hasNext();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        PeekingIterator<String> it = new PeekingIterator<>(list.iterator());
        System.out.println(it.peek());
    }
}
//
