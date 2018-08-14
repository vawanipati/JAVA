
class SuperClass {
	int a = 10;
	static int b = 20;

	public SuperClass() {
		System.out.println("Super Class Cunstructer ");
	}
	{
		System.out.println("Super class Instance block");
		System.out.println("a :"+a);
		System.out.println("b :"+b);
	}
	static {
		System.out.println("Super class static block");
		System.out.println("b :"+b);
	}
	void method1() {
		System.out.println("Super Class instance method1 ");
	}
	static void method2() {
		System.out.println("Super Class static method2 ");
	}
}

class SubClass extends SuperClass {
	int c = 30;
	static int d = 40;
	
	
	public SubClass() {

		System.out.println("Sub Class Cunstructer ");
	}
	
	{
		System.out.println("Subclass Instance block");
		System.out.println("a :"+a);
		System.out.println("b :"+b);
		System.out.println("c :"+c);
		System.out.println("d :"+d);
	}
	static {
		System.out.println("Sub class static block");
		System.out.println("b :"+b);
		System.out.println("d :"+d);
	}
	void method3() {
		System.out.println("Sub Class instance method13 ");
	}
	static void method4() {
		System.out.println("Sub Class static method4 ");
	}
}

public class SubclassExample {

	public static void main(String[] args) {
		
//		SubClass sc= new SubClass();
//		sc.method1();
//		sc.method2();
//		sc.method3();
//		sc.method4();
		SubClass.method4();
		SubClass.method2();
		
	}

}
