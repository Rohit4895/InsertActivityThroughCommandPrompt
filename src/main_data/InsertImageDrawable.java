package main_data;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class InsertImageDrawable {

	private String sourcePathOfImage;
	private String destinationPathOfImage;
	private CallBacksForInsertActivity callBackImage;
	
	public InsertImageDrawable(String sourcePathOfImage, String destinationPathOfImage, CallBacksForInsertActivity callBackImage) {
		this.sourcePathOfImage = sourcePathOfImage;
		this.destinationPathOfImage = destinationPathOfImage;
		this.callBackImage = callBackImage;
	}
	
	public void execute() {
		try {
			FileInputStream fin = new FileInputStream(sourcePathOfImage);
			BufferedInputStream bin = new BufferedInputStream(fin);
			FileOutputStream fout = new FileOutputStream(destinationPathOfImage);
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			int i;
			while ((i = bin.read()) != -1) {
				bout.write(i);
			}
			bin.close();
			fin.close();
			bout.flush();
			bout.close();
			fout.close();
			System.out.println("Success..");
			callBackImage.insertionOfImage("success");
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
	
}
