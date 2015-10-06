public class ZigzagIterator {
    private Iterator it1;
    private Iterator it2;
    private Iterator it;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        if (it1.hasNext()) it = it1;
        else if (it2.hasNext()) it = it2;
        else it = it1;
    }

    public int next() {
        int res = (Integer)it.next();
        if (it == it1 && it2.hasNext()) it = it2;
        else if (it == it2 && it1.hasNext()) it = it1;
        return res;
    }

    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
