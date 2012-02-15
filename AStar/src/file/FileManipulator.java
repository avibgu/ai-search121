package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileManipulator {

	public StringBuilder readFromFile(String fileName){

		File file = new File(fileName);

		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		StringBuilder sb = new StringBuilder();
		
		try {
	
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
		
			while (br.ready())
				sb.append(br.readLine() + "\n");
	
			fis.close();
			isr.close();
			br.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	return sb;
}
