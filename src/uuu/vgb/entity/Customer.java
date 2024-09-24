package uuu.vgb.entity;

import java.time.LocalDate;
import java.util.Objects;

import uuu.vgb.exception.VGBDataInvalidException;
import uuu.vgb.exception.VGBException;

public class Customer {

	public String id; // PKey,ROC ID

	public String email;// UNIQUE,required

	public String phone;// UNIQUE,required

	private String password;// required,6~20個字元

	public String name;// required,2~20個字元

	public LocalDate birthday;// required,iso-8601,年滿12歲

	public char gender;// required,M-男,F-女,O-其他

	public String address = "";// optional

	public boolean subscribed = false;// optional

	public Customer() {
	}

	public Customer(String id, String password, String name) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public Customer(String id, String password, String name, char gender) {
		this(id, password, name);
		this.gender = gender;
	}

	// public int age; //derived attribute
	public int getAge() {
		return getAge(this.birthday);
	}

	public int getAge(LocalDate birthday) {
		if (birthday != null) {
			int thisYear = LocalDate.now().getYear();
			int birthYear = this.birthday.getYear();
			int age = thisYear - birthYear;
			return age;
		} else {
			return -1; // TODO: 第13章 改成(拋出) throw XxxEeception物件
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (checkId(id)) {
			this.id = id;
		} else {
//			System.err.printf("ID(%s)不正確，必須符合ROC ID規則\n", id);//
			String msg = String.format("ID(%s)不正確，必須符合ROC ID規則\n", id);
			throw new VGBDataInvalidException(msg);
		}

	}

	public boolean checkId(String id) {
		if (id != null && id.matches("[A-Z][1289][0-9]{8}")) {
			// 1. 將第1碼的英文字元轉成整數firstNumber(A123123123)
			char firstChar = id.charAt(0);
			int firstNumber = 0;
			if (firstChar >= 'A' && firstChar <= 'H') {
				firstNumber = firstChar - 'A' + 10;
			} else if (firstChar >= 'J' && firstChar <= 'N') {
				firstNumber = firstChar - 'A' + 18;
			} else if (firstChar >= 'P' && firstChar <= 'V') {
				firstNumber = firstChar - 'A' + 23;
			} else {
				switch (firstChar) {
				case 'I':
					firstNumber = 34;
					break;
				case 'O':
					firstNumber = 35;
					break;
				case 'W':
					firstNumber = 32;
					break;
				case 'X':
					firstNumber = 30;
					break;
				case 'Y':
					firstNumber = 31;
					break;
				case 'Z':
					firstNumber = 33;
				}
			}

			// 2. 依公式加總

			// 將firstNumber的十位數 *1 + firstNumber的十位數*9
			int sum = firstNumber / 10 + firstNumber % 10 * 9;
			// 依公視加總:
			// sum = sum + n1 * 8 + n2 * 7 + n3 * 6 + n4 * 5
			// + n5 * 4 + n6 * 3 + n7 * 2 + n8 *1 + n9 *1
			for (int i = 1; i < 10; i++) {
				sum = sum + (id.charAt(i) - '0') * (i == 9 ? 1 : 9 - i);
			}
			// sum += sum + (id.charAt(1) - '0') * 8;
			// sum += sum + (id.charAt(2) - '0') * 7;
			// sum += sum + (id.charAt(3) - '0') * 6;
			// sum += sum + (id.charAt(4) - '0') * 5;
			// sum += sum + (id.charAt(5) - '0') * 4;
			// sum += sum + (id.charAt(6) - '0') * 3;
			// sum += sum + (id.charAt(7) - '0') * 2;
			// sum += sum + (id.charAt(8) - '0') * 1;
			// sum += sum + (id.charAt(9) - '0') * 1;
			return true;
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) { // 原始格式: ^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$
		if (email != null && email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) { // regexp lib搜尋
			this.email = email;
		} else {
			//System.err.printf("email(%s)格式不正確\n ", email);//
			String msg = String.format("email(%s)格式不正確\n ", email);
			throw new VGBDataInvalidException(msg);
		}
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		if (phone != null && phone.matches("[0][9][0-9]{8}")) { // regexp lib搜尋
			this.phone = phone;
		} else {
			//System.err.printf("phone(%s)格式不正確\n ", phone);//
			String msg = String.format("phone(%s)格式不正確\n ", phone);
			throw new VGBDataInvalidException(msg);
		}

	}

	public String getName() {
		return name;
	}
	public static final int MIN_NAME_LENGTH = 2;
	public static final int MAX_NAME_LENGTH = 20;
	public void setName(String name) {
		if(name!=null && name.length()>=MIN_NAME_LENGTH && name.length()<=MAX_NAME_LENGTH) {
			this.name = name;
		}else {
			//System.err.printf("姓名必須輸入且要有%s~%s個字元\n", MIN_NAME_LENGTH, MAX_NAME_LENGTH);//for developers, testers, admins, not for users
			String msg = String.format("姓名必須輸入且要有%s~%s個字元\n", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
			throw new VGBDataInvalidException(msg);
		}
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	/**
	 * birthday屬性的標準setter
	 * 
	 * @param birthday
	 */
	
	public static final int MIN_AGE = 12;
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
		if (birthday == null || getAge() < MIN_AGE) {
			System.err.printf("生日日期%s不正確，必須年滿12歲\n ", birthday);
			this.birthday = null;
		}
	}

	public char getGender() {
		return gender;
	}

	public static final char MALE = 'M';
	public static final char FEMALE = 'F';
	public static final char OTHERS = 'O';
	public void setGender(char gender) {
		if (gender == MALE || gender == FEMALE || gender == OTHERS ) {
			this.gender = gender;
		} else {
			//System.err.println("必須選擇正確的性別選項: M|F|O");//
			String msg = String.format("必須選擇正確的性別選項: %s|%s|%s\n", MALE, FEMALE, OTHERS);
			throw new VGBDataInvalidException(msg);
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isSubscribed() {
		return subscribed;
	}

	public void setSubscribed(boolean subscribed) {
		this.subscribed = subscribed;
	}

	public String getPassword() {
		return password;
	}

	public static final int MIN_PWD_LENGTH = 6;
	public static final int MAX_PWD_LENGTH = 20;
	public void setPassword(String password) {
		if (password.length() >= MIN_PWD_LENGTH && password.length() <= MAX_PWD_LENGTH) {
			this.password = password;
		} else {
			//System.err.println("密碼長度不正確，必須6~20個字元");
			String msg = String.format("密碼長度不正確，必須6~20個字元\"");
			throw new VGBDataInvalidException(msg);
		}

	}

	/**
	 * 將 年,月,日 三個整數轉換成LocalDate物件後指派給客戶的birthday屬性
	 * 
	 * @param year  int型態 客戶生日的年份
	 * @param month int型態 客戶生日的月份
	 * @param day   int型態 客戶生日的日期
	 */
	public void setBirthday(int year, int month, int day) {
		this.birthday = LocalDate.of(year, month, day);
	}

	/**
	 * 將符合iso-8601的日期字串轉換成LocalDate物件後指派給客戶的birthday屬性
	 * 
	 * @param dateString 符合iso-8601的日期字串，如: 2007-12-03
	 */
	public void setBirthday(String dateString) {
		try {
			LocalDate date = LocalDate.parse(dateString);
			this.setBirthday(date);
		} catch (Exception e) {
			//System.err.printf("你輸入的日期:%s不正確，必須符合iso8601日期格式\n",dateString);
			String msg = String.format("你輸入的日期:%s不正確，必須符合iso8601日期格式\n",dateString);
			throw new VGBDataInvalidException(msg);
		}

	}

	@Override
	public String toString() {
		return this.getClass().getName() 
				+ "[id=" + id + ", email=" + email + ", 手機=" + phone 
				+ ",\n 密碼=" + password + ", 姓名=" + name + ", 生日=" + birthday + ", 性別=" + gender 
				+ ",\n 地址=" + address + ", 是否訂閱="	+ subscribed + ", 年齡=" + getAge() + "歲]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}
