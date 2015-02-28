class A{
	int i;
	A(){
		System.out.println(i);
	}
	A(int i){
		System.out.println(i);
	}
}
public class Test extends A {

	/**
	 * @param args
	 */
	int i;
	Test(int i){
		//super(5);
		System.out.println("Test");
		System.out.println(i);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test(10);
		
	}

}
