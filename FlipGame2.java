public class Solution {
    public boolean canWin(String s) {
        for(int i = 0; i < s.length() - 1; i++) {
            if(s.substring(i, i + 2).equals("++")) {
                String fliped = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!canWin(fliped)) return true;
            }
        }

        return false;
    }
}