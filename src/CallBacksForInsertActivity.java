
public interface CallBacksForInsertActivity {
	
	void decompile(int status);
	void manifestModification(String status, String splashActivityName, String splashActivityPath);
	void insertionOfImage(String status);
	void insertionOfWrapperActivity(String status);
	void compileApk(int status);
	void zipAlign(int status);
	void signedApk(int status);
	void installedApk(int status);
	void takingDataFromUserCallBack();
	void assignedValuesToAllStringCallBack();
}
