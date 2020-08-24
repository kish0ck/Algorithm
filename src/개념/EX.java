package 개념;


// 구간 f 시작
class EX {

	public static void main(String[] args) {
		Employee one = new Permanent();
		Employee two = new Salesman();
		one.sabun = 1;
		one.name = "lji";
		two.sabun = 2;
		two.name = "kcs";
		// 구간 f 끝
		
		
		// 구간 g 시작
		one.printEmployeeInfo();
		two.printEmployeeInfo();
		// 구간 g 끝
	}

}
//구간 a 시작
abstract class Employee{
	int sabun;
	String name;
	// 구간 a 끝
	
	// 구간 b 시작
	abstract int getSalary();
	// 구간 b 끝
	
	// 구간 c 시작
	void printEmployeeInfo() {
		System.out.println("사번: "+sabun+", 이름 : "+name+", 봉급 : "+getSalary());
	}
}
// 구간 c 끝

// 구간 d 시작
class Permanent extends Employee {
	int getSalary() {
		return 100;
	}
}
// 구간 d 끝

// 구간 e 시작
class Salesman extends Permanent{
	int getSalary() {
		return 10 + super.getSalary();
	}
}