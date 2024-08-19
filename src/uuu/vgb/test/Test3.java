package uuu.vgb.test;

public class Test3 {
	public static void main(String[] args) {
		//3. 聖母峰
		double height = 8844430;
		double thickness = 0.1;
		int sum = 0;
		while (height > thickness) {
			thickness = 2 * thickness;
			sum++;
		}
		System.out.printf("次數:%s\n",sum);
	}
}
