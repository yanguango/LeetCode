import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        Iterator<List<Integer>> it = triangle.iterator();
        ListIterator<Integer> it1 = null;
        ListIterator<Integer> it2 = null;
        int result = Integer.MAX_VALUE;
        while (it.hasNext()) {
            if (it2 == null) it1 = it.next().listIterator();
            else {
                while (it2.hasPrevious()) it2.previous();
                it1 = it2;
            }

            it2 = it.next().listIterator();
            while (it1.hasNext()) {
                int current = it2.next();
                int add1 = Integer.MAX_VALUE;
                int add2 = Integer.MAX_VALUE;
                if (it1.hasPrevious()) {
                    add1 = it1.previous();
                    it1.next();
                }
                add2 = it1.next();
                int newValue = Math.min(add1, add2) + current;
                it2.set(newValue);
                if (!it.hasNext()) result = Math.min(result, newValue);
            }
            int last = it2.next();
            int add = it1.previous();
            int newValue = last + add;
            it2.set(newValue);

            if (!it.hasNext()) result = Math.min(result, newValue);
        }
        return result;
    }
}
