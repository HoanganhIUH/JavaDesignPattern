package Singletonpattern;

public class Main {
	public static void main(String[] args) {
		EagerInitializedSingleton instance1 = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instance2 = EagerInitializedSingleton.getInstance();
		System.out.println("Instance 1 hash:" + instance1.hashCode());
		System.out.println("Instance 2 hash:" + instance2.hashCode());

	}
}
