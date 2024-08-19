package uuu.vgb.test;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		for (;;) {	
			System.out.println("請輸入一組字串:");
			String str = scanner.nextLine();
			System.out.println(str.length());
			
			if (str.equals("0")) {
				break;
			}
			str = str.trim();//去掉前後空格
			int a = str.lastIndexOf(" ");// 計算最後一個空格index
			str = str.substring(a + 1, str.length());
			System.out.println(str.length());
		}
		scanner.close();
	}
}
