package prim;

public class Animal {
	public static void displaySound(Primate m) {
		System.out.println("Animal says " + m.makeSound() );
	}
	
	public static void main (String[] args) {
		displaySound(new Lemur());
		displaySound(new Primate());
	}
}
