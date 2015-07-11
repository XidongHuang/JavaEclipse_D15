package tony.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.stream.events.StartDocument;

import org.junit.Test;
/*
 * 1. 流的分类
 * 按照数据流向的不同：输入流 输出流
 * 按照处理数据的的单位的不同: 字节流 字符流 (处理的文本文件)
 * 按照角色的不同: 节点流 处理流
 * 
 * 2. IO的体系
 * 抽象基类			节点流(文件流)				缓冲流(处理流的一种)
 * InputStream		FileInputStream			BufferedInputStream
 * OutputStram		FileOutputStream		BufferedOutputStream
 * Reader			FileReader				BufferedReader
 * Writer			FileWriter				BufferedWriter
 * 
 * 
 */
public class TestFileInputOutputStream {
	@Test
	public void testCopyFile(){
		long start = System.currentTimeMillis();
		String src = "/home/tony/Desktop/day14_08枚举类的定义与使用.wmv";
		String dest = "/home/tony/Desktop/day14_08枚举类的定义与使用2.wmv";
		copyFile(src, dest);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
	}
	
	//实现文件复制的方法
	public static void copyFile(String src, String dest){
		//1.提供读入，写出的文件
				File file1 = new File(src);
				File file2 = new File(dest);
				//2.提供相应的流
				FileInputStream fis = null;
				FileOutputStream fos = null;
				
				try{
					fis = new FileInputStream(file1);
					fos = new FileOutputStream(file2);
					//3.实现文件的复制
					byte[] b = new byte[1024];
					int len;
					while((len = fis.read(b))!= -1){
						//fos.write(b);错误的写法两种fos.wirte(b,0,b.length);
						fos.write(b, 0, len);
						
						
						
						
					}
					
				} catch (Exception e){
					e.printStackTrace();
				}finally{
					if(fos != null){
						try{
							fos.close();
						} catch (IOException e){
							System.out.println("Wrong2");;
						}
					}
					if(fis != null){
						try{
							fis.close();
						} catch (IOException e){
							System.out.println("Wrong3");;
						}
					}
				}
		
	}
	
	//从硬盘读取一个文件，并写入到另一个位置。 (相当于文件的复制)
	@Test
	public void TestFileInputOutputStream(){
		//1.提供读入，写出的文件
		File file1 = new File("/home/tony/Desktop/003.jpg");
		File file2 = new File("/home/tony/Desktop/002.jpg");
		//2.提供相应的流
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try{
			fis = new FileInputStream(file1);
			fos = new FileOutputStream(file2);
			//3.实现文件的复制
			byte[] b = new byte[10];
			int len;
			while((len = fis.read(b))!= -1){
				//fos.write(b);错误的写法两种fos.wirte(b,0,b.length);
				fos.write(b, 0, len);
				
				
				
				
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}finally{
			if(fos != null){
				try{
					fos.close();
				} catch (IOException e){
					System.out.println("Wrong2");;
				}
			}
			if(fis != null){
				try{
					fis.close();
				} catch (IOException e){
					System.out.println("Wrong3");;
				}
			}
		}
		
	}
	
	
	//FileOutputStream
	@Test
	public void testFileOutputStream(){
		//1.创建一个File对象，表明要写入的文件位置。
		//输出的物理文件可以不存在，当执行过程，若不存在，会自动的创建。若存在，会将原有的文件覆盖
		File file = new File("hello1.txt");
		//2.创建一个FileOutputStram的对象，将file的对象作为形参传递给FileOutputStram的构造器中
		FileOutputStream fos = null;
		
		try{
			fos = new FileOutputStream(file);
			
			//3.写入的操作
			fos.write(new String("I love China I love the world!").getBytes());
		
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			//4.关闭输出流
			if(fos != null){
			try{
				fos.close();
			} catch (IOException e){
				e.printStackTrace();
			}
		}
		}
	}
	
	
	
	
	
	@Test
	public void testFileInputStream3(){
		FileInputStream fis = null;
		try {
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			byte[] b = new byte[5];//读取到的数据要写入的数组
			int len;//每次读入到byte中的字节的长度
			while((len = fis.read(b))!=-1){
//				for(int i = 0;i<len;i++){
//					System.out.println((char)b[i]);
//				}
				String str = new String(b,0,len);
				System.out.println(str);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
		fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		}
	}
	
	
	
	
	//从硬盘存在的一个文件中，读取其内容到程序中
	//要读取的文件一定要存在。否则抛FileNotFoundException
	//要使用try-catch 的方式处理如下的异常更合理： 保证流的关闭操作一定可以执行
	@Test
	public void testFileInputStream1() {
		//2.创建一个FileInputStream类的对象
		FileInputStream fis = null;
		try {
			//1.创建一个File类的对象
			File file = new File("hello.txt");
			fis = new FileInputStream(file);
			//3.调用FileInputStream的方法，实现file的读取
			/*
			 * read()：读取文件的一个字节。当执行到文件结尾时，返回-1  abcdefg
			 * 
			 */
		int b = fis.read();
//		while(b != -1){
//			System.out.println((char)b);
//			b = fis.read();
//		}
			while((b = fis.read()) != -1){
				System.out.println((char)b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		
		try{
		//4.关闭相应的流
		fis.close();
		} catch (IOException e){
			e.printStackTrace();
		}
		}
	}
	
}
