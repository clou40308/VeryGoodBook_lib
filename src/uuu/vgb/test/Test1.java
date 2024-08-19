package uuu.vgb.test;

import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		//1. 奇偶數
		Scanner scanner = new Scanner(System.in);
		for (;;) {
			System.out.println("請輸入數字:");
			int num = scanner.nextInt();
			if (num % 2 == 0) {
				System.out.println("偶數");
			} else {
				System.out.println("奇數");
			}
			if(num == 000) {
				break;
			}
		}

		
		
	}

}
