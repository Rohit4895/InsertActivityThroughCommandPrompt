package main_data;

public class Tp {

	public static void main(String[] args) {
	
		String abc = "C:/Users/admin/eclipse-workspace/InsertActivityThroughCommandPrompt/src/required_data/marketplace.jks";
		int indexOfLastPathSeperator = abc.lastIndexOf("/");
		int indexOfLastDot = abc.lastIndexOf(".");
		
		System.out.println(" indexOfLastPathSeperator: "+indexOfLastPathSeperator+" indexOfLastDot: "+indexOfLastDot);
		String name = abc.substring((indexOfLastPathSeperator+1), indexOfLastDot);
		System.out.println("Name: "+name);

	}

}
