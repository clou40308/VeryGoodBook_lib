package uuu.vgb.test;

public class TestAssignmentOperators {

	public static void main(String[] args) {
		// = += *= *= /= %=
		double price = 200;
		int discount = 21; // 21% off

		price = price * (100 - discount) / 100;
		System.out.printf("%s\n", price);

		price = 200;
		price = price * ((100D - discount) / 100);
		System.out.printf("%s\n", price);

		price = 200;
		price *= (100 - discount) / 100;
		System.out.printf("%s\n", price);

		int a = 100;
		a += 3.5 * price / 1000 - 6;
		System.out.printf("a: %s\n", a);

		a = 100;
		a = (int) (a + (3.5 * price / 1000 - 6));
		System.out.printf("a: %s\n", a);

		byte a1 = 1, b = 1, c = 1, d = 1;
		a1 += b + c / d;
		System.out.printf("a1: f%s\n", a);
	}

}
