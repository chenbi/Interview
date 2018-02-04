class A {
	public A() {
		foo();
	}

	public void foo() {
		System.out.println("Class A");
	}

	public static void main(String[] args) {

		A a = new B();
	}
}