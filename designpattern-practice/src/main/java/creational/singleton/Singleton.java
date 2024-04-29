package creational.singleton;

public class Singleton {
	private static Singleton instance = null;

	private Singleton() {

	} // => New 사용 불가

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}
}
