package uuu.vgb.test;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		//2. 1~1000奇偶數
		int oddSum = 0; //奇數和
		int evenSum = 0; //偶數和
		for (int i =1; i<=1000 ;i++) {
			if (i % 2 == 0) {
				evenSum+=i;
			} else {
				oddSum+=i;
			}
		}
		System.out.printf("奇數和:%s\n",oddSum);
		System.out.printf("偶數和:%s\n",evenSum);

	}

}
