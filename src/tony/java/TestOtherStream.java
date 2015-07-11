package tony.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;


public class TestOtherStream {
	/*
	 * 标准的输入输出流:
	 * 标准的输出流: System.out
	 * 标准的输入流: System.in
	 * 
	 * 题目:
	 * 从键盘输入字符串,要求将读取到的整行字符串转成大写输出.然后继续输入操作
	 * 直至当输入"e"或者"exit"时,退出程序
	 * 
	 * 
	 */
	
	@Test
	public void test2(){
		BufferedReader br = null;
		try {
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			
			String str;
			while(true){
				System.out.print("Please input string: ");
				str = br.readLine();
				
				if(str.equalsIgnoreCase("e") || str.equalsIgnoreCase("exit")){
					break;
				}
				String str1 = str.toUpperCase();
				System.out.println(str1);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(br != null){
			try{
				br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			}
		}
	}
	
	
	
	
/*
 * 
 * 如何实现字节流与字符流之间的转换:
 * 转换流: InputStreamReader 		OutputStreamWriter
 * 编码: 字符串 ---> 字节数租
 * 解码: 字节数租 ---> 字符串
 * 
 * 
 */
	
	@Test
	public void test1(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			//解码的过程
			File file1 = new File("/home/tony/Share Files/1.java核心技术教程/尚硅谷_宋红康_JavaSE课件/尚硅谷_宋红康_第6章_异常处理/异常处理_练习&面试题.txt");
			FileInputStream fis = new FileInputStream(file1);
			InputStreamReader isr = new InputStreamReader(fis,"GBK");
			br = new BufferedReader(isr);
			
			//编码
			File file2 = new File("/home/tony/Desktop/exeException1.txt");
			FileOutputStream fos =new FileOutputStream(file2);
			OutputStreamWriter osr = new OutputStreamWriter(fos,"UTF-8");
			bw = new BufferedWriter(osr);
			String str;
			while((str = br.readLine()) != null){
//				System.out.println(str);
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			if(br != null){
				try{
				br.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
			if(bw != null){
		try {
			bw.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
			
			}
		}
		
	}
	
	
	
}
