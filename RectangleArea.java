public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = 0;
        area += (D - B) * (C - A);
        area += (H - F) * (G - E);
        int commonA = Math.max(A, E);
        int commonB = Math.max(B, F);
        int commonC = Math.min(C, G);
        int commonD = Math.min(D, H);
        if (commonA < commonC && commonB < commonD ) {
            area -= (commonD - commonB) * (commonC - commonA);
        }
        return area;
    }
}
