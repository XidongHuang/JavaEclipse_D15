package tony.java;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.junit.Test;

/*
 * 2. IO的体系
 * 抽象基类			节点流(文件流)				缓冲流(处理流的一种,可以提升文件操作的效率)
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStram		FileOutputStream		BufferedOutputStream  (flush())
 * Reader			FileReader				BufferedReader		  (readLine())
 * Writer			FileWriter				BufferedWriter		  (flush())
 * 
 */


public class TestBuffered {
	
	@Test
	public void testBufferedReader(){
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		
		try {
			File file = new File("dbcp.txt");
			File file1 = new File("dbcp3.txt");
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			Writer fw = new FileWriter(file1);
			bw = new BufferedWriter(fw);
//			char[] c = new char[1024];
//			int len;
//			while((len = br.read(c))!=-1){
//				String str = new String(c,0,len);
//				System.out.println(str);
//			}
			
			String str;
			while((str = br.readLine())!= null){
				bw.write(str);
				bw.newLine();
				System.out.println(str);
				bw.flush();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try{
				if(br != null){
					br.close();
				}
			}catch (IOException e){
					e.printStackTrace();
				}
		}
	}
	
	
	
	
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
		String src = "/home/tony/Share Files/1.java核心技术教程/第10章：IO(day15-day16)/day15/day15_06FileOutputStream的使用_文件复制操作.wmv";
		String dest = "/home/tony/Desktop/002.wmv";
		
		copyFile(src, dest);
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	

	
	
	public void copyFile(String src, String dest){
		//3. 将创建的节点流的对象作为形参传递给缓冲流的构造器中
				BufferedInputStream bis = null;
				BufferedOutputStream bos = null;
				try {
					//1.提供相应的读入,写出文件
					File file1 = new File(src);
					File file2 = new File(dest);
					
					//2.先创建相应的节点流: FileInputStream, FileOutputStream
					FileInputStream fis = new FileInputStream(file1);
					FileOutputStream fos = new FileOutputStream(file2);
					
					bis = new BufferedInputStream(fis);
					bos = new BufferedOutputStream(fos);
					
					//4.具体的实现文件复制的操作
					byte[] b = new byte[1024];
					int len;
					while((len = bis.read(b))!= -1){
						bos.write(b, 0, len);
						bos.flush();
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
				//关闭相应的流
				
					if(bos != null){
					try {
						bos.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					}
					if(bis != null){
						try{
						bis.close();
						} catch (IOException e){
							e.printStackTrace();
						}
					}
				}
		
		
		
	}
	
	
	
	
	
	
	
	
	//使用BufferedInputStream和BufferedOutputStream实现非文本文件的复制
	@Test
	public void testBufferedInputOutputStream(){
		//3. 将创建的节点流的对象作为形参传递给缓冲流的构造器中
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			//1.提供相应的读入,写出文件
			File file1 = new File("/home/tony/Desktop/002.jpg");
			File file2 = new File("003.jpg");
			
			//2.先创建相应的节点流: FileInputStream, FileOutputStream
			FileInputStream fis = new FileInputStream(file1);
			FileOutputStream fos = new FileOutputStream(file2);
			
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			
			//4.具体的实现文件复制的操作
			byte[] b = new byte[1024];
			int len;
			while((len = bis.read(b))!= -1){
				bos.write(b, 0, len);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		//关闭相应的流
		
			if(bos != null){
			try {
				bos.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			}
			if(bis != null){
				try{
				bis.close();
				} catch (IOException e){
					e.printStackTrace();
				}
			}
		
		
		}
		
		
		
		
		
		
	}
	
	
}
