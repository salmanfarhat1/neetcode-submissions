class LRUCache {

    HashMap<Integer, Node> map = new HashMap<>();

    int capacity;
    Node start;
    Node end;

    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCache(int capacity) {

        start = new Node(-1, -1);
        end = new Node(-1, -1);

        start.next = end;
        end.prev = start;

        this.capacity = capacity;
    }

    public int get(int key) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            putAtEnd(node);

            return node.val;
        }

        return -1;
    }

    public void putAtEnd(Node node) {

        node.prev.next = node.next;
        node.next.prev = node.prev;

        node.prev = end.prev;
        node.next = end;

        end.prev.next = node;
        end.prev = node;
    }

    public void put(int key, int value) {

        // Key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.val = value;

            putAtEnd(node);

            return;
        }

        if (map.size() == capacity) {
            Node node = start.next;
            map.remove(node.key);
            start.next = node.next;
            node.next.prev = start;
        }
        Node node = new Node(key, value);
        map.put(key, node);

        node.prev = end.prev;
        node.next = end;

        end.prev.next = node;
        end.prev = node;
    }
}