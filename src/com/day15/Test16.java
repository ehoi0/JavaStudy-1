package com.day15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

//�ܼ��� Buffer�� ����� ����

public class Test16 {
	
	public final static int BUFFER_SIZE = 512;
	
	public static void main(String[] args) {
		
		byte[] buffer = new byte[BUFFER_SIZE];
		
		try {
			
			FileInputStream fis = new FileInputStream("d:\\doc\\test.txt");
			FileOutputStream fos = new FileOutputStream("d:\\doc\\out5.txt");
			
			//Buffer�� �ѹ� �� ������ ����
			BufferedInputStream bis = new BufferedInputStream(fis);//���۷� �Ȱ� �ӵ��� ���� ������ ������ fis, fos�� ���۷� �ѹ� �� ������ ��
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int data, len=0;
			
			while((data=bis.read(buffer))!=-1){
				
				System.out.println("���� ���ڱ���: " + data);
				len += data;//����
				
				bos.write(buffer,0,data);//byte�迭 buffer�� 0~data���� �ۼ�
				bos.flush();
			}
			
			System.out.println("�о���� ��ü����: " + len);
			
			fis.close();
			fos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}