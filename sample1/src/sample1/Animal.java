package sample1;

public class Animal {
	public static void main(String[] args) {
		Dog myDog = new Dog(2);
		System.out.println(myDog.weight);
		System.out.println(myDog.age);
		
		Dog myOtherDog = new Dog(4, 12);
		System.out.println(myOtherDog.weight);
		System.out.println(myOtherDog.age);
	}
}
