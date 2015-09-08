public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] segments = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String seg : segments) {
            if (seg.equals("..")) {
                if (stack.peek() != null) stack.pop();
            } else if (!seg.equals(".") && !seg.equals("")) {
                stack.push(seg);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (stack.peekLast() != null) {
            String seg = stack.pollLast();
            if (seg.length() > 0) {
                sb.append('/');
                sb.append(seg);
            }
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
