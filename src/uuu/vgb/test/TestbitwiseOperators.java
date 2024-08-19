package uuu.vgb.test;

public class TestbitwiseOperators {

	public static void main(String[] args) {
		// & | ^ ~ >> >>> <<
		// 運算元只能為: byte, short, char, int, long 
		//\t Tab
		int a = 5;
		int b = 6;
		System.out.printf("\t%s\n&\t%s\n : \t%s\n", Integer.toBinaryString(a), Integer.toBinaryString(b),
				Integer.toBinaryString(a & b));
		System.out.printf("\t%s\n|\t%s\n : \t%s\n", Integer.toBinaryString(a), Integer.toBinaryString(b),
				Integer.toBinaryString(a | b));
		System.out.printf("\t%s\n^\t%s\n : \t %s\n", Integer.toBinaryString(a), Integer.toBinaryString(b),
				Integer.toBinaryString(a ^ b));
		System.out.printf("\t~\t\t\t%s\n : %s\n", Integer.toBinaryString(a), Integer.toBinaryString(~a));
		
		System.out.printf("a & b: %s\n",a & b);
		System.out.printf("a | b: %s\n",a | b);
		System.out.printf("a ^ b: %s\n",a ^ b);
		System.out.printf("~a: %s\n",~a);
		
		int x = 32;
		System.out.printf("x<<2: %s\n",x<<2);
		System.out.printf("x>>2: %s\n",x>>2);
		System.out.printf("x>>>2: %s\n",x>>>2);
		
		int y = -32;
		System.out.printf("y<<2: %s\n",y<<2);
		System.out.printf("y>>2: %s\n",y>>2);
		System.out.printf("y>>>2: %s\n",y>>>2);
	}

}
