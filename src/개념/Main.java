package 개념;

class Car {
	//...
}

public class Main {

	public static void main(String[] args) {
		// 1. 객체를 선언, 어떠한 메모리도 차지하지 않았다
		// 객체는 선언!
		Car tico;  
		
		// 2. 클래스의 인스턴스를 만들었고 메모리가 객체에 의해 차지되었다
		Car matiz = new Car();
		
		// 3. sonata, moring, pony는 객체
		Car sonata, morning, pony;
		
		// 4. tico, mornig, pony는 Car클래스의 인스턴스
		tico = new Car();
		morning = new Car();
		pony = new Car();
		
	}

}
