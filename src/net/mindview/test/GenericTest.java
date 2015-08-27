package net.mindview.test;

import java.util.ArrayList;
import java.util.List;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

interface Sender{
	void send();
}

class SmsSender implements Sender{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("SmsSender");;
	}
	
}

class MailSender implements Sender{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("MailSender");
	}
	
}

public class GenericTest {
	public static List<Class<?>> list=new ArrayList<>();
	public static List<Sender> list2=new ArrayList<>();
	public static void add(Class<? extends Sender> c) throws InstantiationException, IllegalAccessException{
		list.add(c);
		list2.add(c.newInstance());
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		add(SmsSender.class);
		add(MailSender.class);
		for(Sender sender:list2){
			sender.send();
		}
	}
	
	
}
