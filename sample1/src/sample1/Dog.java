package sample1;

public class Dog {
	public int age;
	public int weight;
	
	public Dog(int age) {
//		System.out.println("age only");
		this(age,7);
	}
	public Dog(int age, int weight) {
		this.weight = weight;
		this.age = age;
	}
}
