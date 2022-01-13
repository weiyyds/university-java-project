package test;

public class testfather {
	public static void main(String[] args) {
		Animal g=new Dog();
	}
}
class Animal{
	public Animal() {
		System.out.print("吃饭了");
	}
}
class Dog extends Animal{

	public Dog() {
		System.out.print("吃骨头了");
	}
	
}