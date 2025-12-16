package sample;

public class Animal {
	
	private String type;
	public int age;
	public String name = "Mommy monkey";
	
//	public Animal(int age) {
//		this.age = age;
//	}
	
	public void setType(String t) {
		type = t;
	}

	public String getType() {
		return type;
	}
	public static void main(String [] args) {
		Monkey monkey = new Monkey();
//		monkey.setDetails();
	}
}
