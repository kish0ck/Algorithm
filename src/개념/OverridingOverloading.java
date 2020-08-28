package 개념;

public class OverridingOverloading {
	static class Human {
			String name;
			String sex;
			int age;
			// 오버로딩
			public Human() {}
			public Human(String name) {} 
			public Human(String name, String sex) {}
	//		public human(String sex, String name) {} 순서가 다르면 같은걸로 인정띠
			public Human(String name, String sex, int age) {}
			public Human(String name, int age, String sex) {} // 매개변수의 타입이 다를 경우는 순서가 다르면 가능
			public void print() {
				System.out.println("이름 : "+ this.name + ", 성별 : "+ this.sex+", 나이 : "+this.age);
			}
			public String print(String str) { // 매개변수는 원래 달라야하니까
				return str;
			}
			public void method() {
				System.out.println("Human");
			}
		}
	
	static class Korean extends Human {
			String WhereAreyouFrom;
			
			public void print() {
				super.print();
				System.out.println("국적 : " + this.WhereAreyouFrom);
			}
			public void method() {
				System.out.println("Korean");
			}
		}
	
	public static void main(String[] args) {
		Korean kistone = new Korean();
		kistone.name = "hoho";
		kistone.age = 19;
		kistone.sex = "남";
		kistone.WhereAreyouFrom="한국";
		kistone.print();
		/*
		 * 이름 : hoho, 성별 : 남, 나이 : 19
		     국적 : 한국
		 * */
		
		Human h1 = new Human();
		h1.method(); // Human
		
		Human h2 = new Korean();
		h2.method(); // Korean
		
		Korean k = new Korean();
		k.method(); // Korean
		
		/*
		 출력
		이름 : hoho, 성별 : 남, 나이 : 19
		국적 : 한국
		Human
		Korean
		Korean
		 * */
	}

}
