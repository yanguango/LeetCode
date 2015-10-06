public class ValidWordAbbr {
    private Map<String, List<String>> map;

    public String getAbbr(String s) {
        if (s.length() < 3) return s;
        else return "" + s.charAt(0) + (s.length() - 2) + s.charAt(s.length() - 1);
    }

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, List<String>>();
        for (String word : dictionary) {
            if (word.length() > 2) {
                String abbr = getAbbr(word);
                if (!map.containsKey(abbr)) {
                    map.put(abbr, new ArrayList<String>(Arrays.asList(word)));
                } else {
                    map.get(abbr).add(word);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbr(word);
        return !map.containsKey(abbr) ||
               (map.get(abbr).size() == 1 && map.get(abbr).get(0).equals(word));
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
