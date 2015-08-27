package net.mindview.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Echo {

	public static void main(String[] args) throws IOException{
		BufferedReader stdinBufferedReader=new BufferedReader(new InputStreamReader(System.in));
		String string;
		while((string=stdinBufferedReader.readLine())!=null&&string.length()!=0)
			System.out.println(string);
	}
}
