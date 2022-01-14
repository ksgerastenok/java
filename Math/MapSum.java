class MapSum extends Object {
    private final HashMap<String, Integer> map1 = new HashMap<>();
    private final HashMap<String, Integer> map2 = new HashMap<>();

    public void insert(String key, int val) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i != key.length(); i += 1) {
            sb.append(key.charAt(i));
            map1.put(sb.toString(), map1.getOrDefault(sb.toString(), 0) - map2.getOrDefault(key, 0) + val);
        }
        map2.put(key, val);
    }

    public int sum(String prefix) {
        return map1.getOrDefault(prefix, 0);
    }
}

class Program extends Object {
    public static void main(String[] args) {
        MapSum map = new MapSum();
        map.insert("apple", 3);
        map.insert("application", 2);
        map.insert("applicant", 1);
        System.out.println(map.sum("app"));
        map.insert("apple", 5);
        System.out.println(map.sum("app"));
    }
}
