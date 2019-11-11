package creationalPatterns.singelton;

public class Singeltone {

    public static void main(String[] args) {
        President instance1 = President.getInstance();
        President instance2 = President.getInstance();
        System.out.println(instance1.equals(instance2));
    }

    public static class President {

        private static President instance;

        public static President getInstance() {
            if (instance == null) {
                instance = new President();
            }
            return instance;
        }

        private President() {}
    }
}
