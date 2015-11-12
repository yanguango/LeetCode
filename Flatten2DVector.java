public class Vector2D {
    int i, j;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        while (i < vec2d.size() && vec2d.get(i).size() == 0) i++;
    }

    public int next() {
        int res = vec2d.get(i).get(j);
        if (j == vec2d.get(i).size() - 1) {
            i++;
            while (i < vec2d.size() && vec2d.get(i).size() == 0) i++;
            j = 0;
        } else {
            j++;
        }
        return res;
    }

    public boolean hasNext() {
        return vec2d != null && i < vec2d.size() && j < vec2d.get(i).size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */