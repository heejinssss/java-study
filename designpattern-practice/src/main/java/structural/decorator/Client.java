package structural.decorator;

public class Client {
	public static void main(String[] args) {
		System.out.println(new ConcreteComponent("Hello World").operation());
		System.out.println(new BracesDecorator(new ConcreteComponent("Hello World")).operation());
		System.out.println(new ParenthesisDecorator(new BracesDecorator(new ConcreteComponent("Hello World"))).operation());
		System.out.println(new BracesDecorator(new ParenthesisDecorator(new ConcreteComponent("Hello World"))).operation());
	}
}

/**
 * Hello World
 * {Hello World}
 * ({Hello World})
 * {(Hello World)}
 **/