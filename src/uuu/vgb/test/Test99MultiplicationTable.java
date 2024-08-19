package uuu.vgb.test;

public class Test99MultiplicationTable {
	public static void main(String[] args) {
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j <= i; j++) {
//				if (j == i) {
//					System.out.printf("%s*%s=%s\n", i, j, i * j);
//				} else {
//					System.out.printf("%s*%s=%s\t", i, j, i * j);
//				}
//
//			}
//		}
		loop1: for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= 10; j++) {
				if (j > i) {
					System.out.println();
					continue loop1;
				}
				System.out.printf("%s*%s=%s\t", i, j, i * j);
			}

			System.out.println();
		}

	}
}