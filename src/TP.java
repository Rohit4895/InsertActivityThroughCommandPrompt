import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String abc = "E:\\roh\\ClashOfTitans\\Clash_Of_Titans\\res\\drawable\\background.png";
		
		System.out.println("Before: "+abc);
		abc = abc.substring(0, abc.lastIndexOf("\\"));
		System.out.println("After: "+abc);
		
		Path path = Paths.get(abc);
		 
		if(Files.exists(path)) {
			System.out.println("Exist");
		}
	}

}
