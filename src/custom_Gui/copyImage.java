package custom_Gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class copyImage {
	public static void coppyExtention(String pathInput, String nameInput) throws IOException {
		FileInputStream in = null;
		FileOutputStream out = null;
		System.out.println(nameInput);
		try {
			in = new FileInputStream(pathInput);
			out = new FileOutputStream("src/image/"+nameInput);
			int c ; 
			while((c=in.read()) != -1 ) {
				out.write(c);
			}
		}finally {
			if(in!=null) in.close();
			if(out!=null) out.close();
		}
	}
}
