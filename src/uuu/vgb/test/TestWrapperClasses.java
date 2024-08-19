package uuu.vgb.test;

import java.util.ArrayList;
import java.util.List;

public class TestWrapperClasses {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
		
		
		int data1 = 1;
		Integer data10bj = new Integer(data1);// boxing
		intList.add(data10bj);

		Double data20bj = new Double(data1);// boxing
		double x = data10bj.intValue() + data20bj.doubleValue();// unboxing

		Double data20bj2 = (2.0);
		double x1 = data10bj + data20bj;
		System.out.println(x);

		// Wrapper class提供將String轉成對應基本型別
		String s1 = "1234";
		if (s1 != null && s1.matches("[0-9]+")) {

		}
	}

}
