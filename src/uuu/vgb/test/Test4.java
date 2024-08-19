package uuu.vgb.test;
import java.util.Random;

public class Test4 {

	public static void main(String[] args) {
		//4.產生隨機碼
		String strData = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890");
		String[] array = strData.split("");
		Random random = new Random();
		for(int i =1 ;i<=200;i++) {
			System.out.printf("第%s次:",i);
			for(int j =0 ;j<5;j++) {
				int num =random.nextInt(62);
				System.out.printf("%s",array[num]);
			}
			System.out.printf("\n");
		}
	}

}