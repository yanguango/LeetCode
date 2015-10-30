public class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] map = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else map[secret.charAt(i) - 48]++;
        }
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                int index = guess.charAt(i) - 48;
                if (map[index] > 0) cows++;
                map[index]--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}`