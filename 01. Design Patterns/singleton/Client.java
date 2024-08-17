package singleton;

public class Client {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton);
        System.out.println(singleton2);

        ThreadsafeSingleton tsingleton = ThreadsafeSingleton.getInstance();
        ThreadsafeSingleton tsingleton2 = ThreadsafeSingleton.getInstance();

        System.out.println(tsingleton);
        System.out.println(tsingleton2);
    }
}
