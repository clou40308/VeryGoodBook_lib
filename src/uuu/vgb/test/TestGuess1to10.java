package uuu.vgb.test;

import java.util.Random;
import java.util.Scanner;

public class TestGuess1to10 {

	public static void main(String[] args) {
		//1.系統[亂數]產生1~10目標數字
		Random random = new Random();
		int target = random.nextInt(10)+1;// (0~9)+1 :1~10
		
		//2. 文字模式輸入 準備
		Scanner scanner = new Scanner(System.in);
		
		//3.使用者輸入數字
//		System.out.println("請猜1個 1~10 之間的整數: ");
		
		
		//作法1: 使用者輸入數字，並用while()判斷是否猜對了
//		int answer = scanner .nextInt();
//		
//		while (answer!=target) { //猜錯了繼續猜
//			System.out.println("猜錯了，請再猜1個 1~10 之間的整數: ");
//			answer = scanner .nextInt();
//		}
//		System.out.println("猜對了");
		
		//作法2: 使用者輸入數字，並用do...while()判斷是否猜對了
		int answer   ;
		String preTitle="請";
		do {//猜錯了繼續猜
			System.out.printf("%s猜一個 1~10之間的整數:\n",preTitle);
			answer = scanner.nextInt();
			preTitle="猜錯了，請再";
		}while(answer != target);
		System.out.println("猜對了");
		scanner.close();
	}

}
