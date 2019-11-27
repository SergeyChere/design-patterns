package behaviorPatterns;

import java.util.ArrayList;
import java.util.List;

public class Observer {

    public static abstract class ObserverExample {
        protected Subject subject;
        public abstract void update();
    }

    public static class Subject {
        private List<ObserverExample> observers = new ArrayList<>();
        private int state;

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
            notifyAllObservers();
        }

        private void attach(ObserverExample observerExample) {
            observers.add(observerExample);
        }

        private void notifyAllObservers() {
            for (ObserverExample observerExample : observers) {
                observerExample.update();
            }
        }
    }

    public static class HexaObserver extends ObserverExample {

        public HexaObserver(Subject subject) {
            this.subject=subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Hexa string: "+Integer.toHexString(subject.state));
        }
    }

    public static class BinaryObserver extends ObserverExample {

        public BinaryObserver(Subject subject) {
            this.subject=subject;
            this.subject.attach(this);
        }

        @Override
        public void update() {
            System.out.println("Binary string: "+Integer.toBinaryString(subject.state));
        }
    }

    public static class OctalObserver extends ObserverExample {

        @Override
        public void update() {
            System.out.println("Octal string: "+Integer.toOctalString(subject.state));
        }

        public OctalObserver(Subject subject) {
            this.subject=subject;
            this.subject.attach(this);
        }

    }

    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);

        System.out.println("First state 15");
        subject.setState(15);
        System.out.println("First state 10");
        subject.setState(10);
        System.out.println("First state 3");
        subject.setState(3);
    }
}
