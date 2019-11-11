package creationalPatterns.abstractFactory;

public class AbstractFactory {

    public static void main(String[] args) {
        WoodenFactory woodenFactory = new WoodenFactory();
        woodenFactory.createDoor().description();
        woodenFactory.createFittingExpert().description();

        IronFactory ironFactory = new IronFactory();
        ironFactory.createDoor().description();
        ironFactory.createFittingExpert().description();
    }

    /*
    Factory
     */

    interface DoorFactory {
        Door createDoor();
        DoorFittingExpert createFittingExpert();
    }

    public static class WoodenFactory implements DoorFactory {

        @Override
        public Door createDoor() {
            return new WoodenDoor();
        }

        @Override
        public DoorFittingExpert createFittingExpert() {
            return new Carpenter();
        }
    }

    public static class IronFactory implements DoorFactory {
        @Override
        public Door createDoor() {
            return new IronDoor();
        }

        @Override
        public DoorFittingExpert createFittingExpert() {
            return new Welder();
        }
    }

    /*
    Fitting Experts
     */

    public interface DoorFittingExpert {
        void description();
    }

    public static class Welder implements DoorFittingExpert {
        @Override
        public void description() {
            System.out.println("I can repair Iron door");
        }
    }

    public static class Carpenter implements DoorFittingExpert {
        @Override
        public void description() {
            System.out.println("I can repair Wooden door");
        }
    }

    /*
    Door
     */

    public interface Door {
        void description();
    }

    public static class IronDoor implements Door {
        @Override
        public void description() {
            System.out.println("Iron door");
        }
    }

    public static class WoodenDoor implements Door {

        @Override
        public void description() {
            System.out.println("Wooden door");
        }
    }
}
