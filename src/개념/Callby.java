package 개념;

public class Callby {

	static class CustomClass {
		int num;

		public CustomClass(int num) {
			this.num = num;
		}
	}
	
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		System.out.println("기본형-swap(전) num1 = "+num1 +",num2 = "+num2);
		swap1(num1, num2);
		System.out.println("기본형-swap(후) num1 = "+num1 +",num2 = "+num2);
		
		Integer num3 = 30;
		Integer num4 = 40;
		System.out.println("wrapper클래스-swap(전) num3 = "+num3 +",num4 = "+num4);
		swap2(num3, num4);
		System.out.println("wrapper클래스-swap(전) num3 = "+num3 +",num4 = "+num4);
		
		CustomClass num5 = new CustomClass(10);
		CustomClass num6 = new CustomClass(20);
		System.out.println("Custom클래스-swap(전) num5 = "+num5.num +", num6 = "+num6.num);
		swap3(num5, num6);
		System.out.println("Custom클래스-swap(후) num5 = "+num5.num +", num6 = "+num6.num);
		
	}

	private static void swap3(CustomClass num5, CustomClass num6) {
		int temp;
		
		temp = num5.num;
		num5.num = num6.num;
		num6.num = temp;
	}

	private static void swap2(Integer num3, Integer num4) {
		Integer temp;

		temp = num3;
		num3 = num4;
		num4 = temp;
		
	}

	private static void swap1(int num1, int num2) {
		int temp;
		
		temp = num1;
		num1 = num2;
		num2 = temp;
	}

}
