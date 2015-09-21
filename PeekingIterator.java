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
