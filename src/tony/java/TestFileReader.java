package tony.java;

import java.beans.FeatureDescriptor;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class TestFileReader {
	/* 使用FileReader FileWriter 可以实现文件文本的复制
	 * 对于非文本文件(视频文件，音频文件，图片),只能使用字节流
	 * 
	 */

	@Test
	public void testFileReaderWriter(){
		//1. 输入流对应的文件src一定要存在，否则抛异常。输出流对应的文件dest可以不存在，执行过程中会自动创建
		FileReader fr = null;
		FileWriter fw = null;
		try {
			
			//不能实现非文本文件的复制
			File src = new File("dbcp.txt");
			File dest = new File("dbcp1.txt");
			
			//2.
			fr = new FileReader(src);
			fw = new FileWriter(dest);
			//3.
			char [] c =new char[24];
			int len;
			while((len = fr.read(c))!= -1){
				fw.write(c, 0, len);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		finally{
			if(fw != null) {
				try{
					fw.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			} 
			if(fr != null){
				try {
					fr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	
	
	@Test
	public void testFileReader(){
		FileReader fr = null;
		
		try {
			File file = new File("dbcp.txt");
			fr = new FileReader(file);
			char[] c = new char[24];
			int len;
			while((len = fr.read(c)) != -1){
				String str = new String(c, 0, len);
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				fr.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		
	}
}
