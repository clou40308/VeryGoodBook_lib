package uuu.vgb.test;

import java.time.LocalDate;

public class Test_if_else {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now().plusDays(1);
		int dayOfWeek = today.getDayOfWeek().getValue();
		if (dayOfWeek == 1 || dayOfWeek == 2 || dayOfWeek == 4) {
			System.out.println("整天");
		} else if (dayOfWeek == 1 || dayOfWeek == 5) {
			System.out.println("半天");
		} else if (dayOfWeek == 6 || dayOfWeek == 7) {
			System.out.println("放假");
		} else {
			System.out.println("錯誤的資料:" + dayOfWeek);
		}

		System.out.println("The End");
	}
}
