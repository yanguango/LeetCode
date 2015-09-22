class Node {
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int k, int v) {
        key = k;
        val = v;
    }
}
public class LRUCache {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    Node head = null;
    Node tail = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        setHead(node);
        return node.val;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            setHead(node);
        } else {
            Node node = new Node(key, value);
            if (map.size() == capacity) {
                map.remove(tail.key);
                remove(tail);
                setHead(node);
            } else {
                setHead(node);
            }
            map.put(key, node);
        }
    }

    public void remove(Node node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;

    }

    public void setHead(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) head.prev = node;
        head = node;
        if (tail == null) tail = head;
    }
}
