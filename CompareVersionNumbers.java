public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] strs1 = version1.split("\\.");
        String[] strs2 = version2.split("\\.");
        for (int i = 0; i < Math.max(strs1.length, strs2.length); i++) {
            int v1 = i < strs1.length ? Integer.valueOf(strs1[i]) : 0;
            int v2 = i < strs2.length ? Integer.valueOf(strs2[i]) : 0;
            if (v1 == v2) continue;
            else return v1 < v2 ? -1 : 1;
        }
        return 0;
    }
}
