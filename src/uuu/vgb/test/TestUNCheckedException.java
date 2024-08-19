package uuu.vgb.test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class TestUNCheckedException {

	public static void main(String[] args) {
		int i = 10;
		System.out.print("10/" + i + ":");
		System.out.println(10 / i);// 當i為0時，會發生java.lang.ArithmeticException

		String s = "hello"; // null示範資料沒有從前端表單傳過來
		System.out.println(s.length()); // 當s為null時，會發生java.lang.NullPointerException

		Object o = LocalDate.now();
		System.out.println(((LocalDate) o).getYear()); // 當o參考的不是null也非LocalDate物件，會發生 java.lang.ClassCastException

		int[] intArray = { 1, 2, 4, 78 };
		System.out.println(intArray[intArray.length - 1]); // 當intArray中沒有半個int元素，會發生
															// java.lang.ArrayIndexOutOfBoundsException

		// String的方法，可能發生執行時期錯誤，但compiler不檢查。應該用程式技巧(if...else，或三元運算子)先防範讓錯誤不會發生
		String a = " ";
		System.out.println(a != null && a.length() > 0 ? a.charAt(a.length() - 1) : "");// 當o參考的""物件，會發生
																						// java.lang.StringIndexOutOfBoundsException

		String data = "abcd";
		if (data != null && data.matches("[0-9]+")) {
			int quantity = Integer.parseInt(data); //當data字串內容有非數字資料，會發生 java.lang.NumberFormattException
			System.out.printf("數量為: %s\n", quantity);
		} else {
			System.err.printf("try...catch... 數量: %s不正確，必須為正整數\n", data);//for user
		}

		String dateString = "2000-07-08";// iso 8601
		try {
			LocalDate date = LocalDate.parse(dateString);// java.time.format.DateTimeParseException
			System.out.printf("你輸入的日期為: %s,是%s \n", dateString, date.getDayOfWeek());
		} catch (DateTimeParseException e) {
			System.out.printf("你輸入的日期不正確: %s\n", dateString);
		}

	}

}
