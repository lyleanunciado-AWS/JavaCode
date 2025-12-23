package sandBox;
import java.io.FileReader;
import java.io.IOException;
//import java.io.Exception;

public class Box {
	public static void main (String[] args) {
		try {
			throw new RuntimeException();
		} catch (RuntimeException e) {
			throw new RuntimeException();
		}finally{
			throw new Exception();
		}
	}
	
	private static FileReader read() throws IOException{
		throw new IOException("adsfasdf");
	}
}
