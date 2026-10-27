
class CountSquares {
    HashMap<String, Integer> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + "," + point[1];
        points.put(key, points.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;

        for (String key : points.keySet()) {
            String[] parts = key.split(",");
            int x2 = Integer.parseInt(parts[0]);
            int y2 = Integer.parseInt(parts[1]);

            if (Math.abs(x2 - x) != Math.abs(y2 - y))
                continue;

            if (x2 == x || y2 == y)
                continue;

            String p1 = x + "," + y2;
            String p2 = x2 + "," + y;

            result += points.get(key)
                    * points.getOrDefault(p1, 0)
                    * points.getOrDefault(p2, 0);
        }

        return result;
    }
}
