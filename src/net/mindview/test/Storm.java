package net.mindview.test;

import java.util.ArrayList;
import java.util.Random;

class Product{
	private final int id;
	private String description;
	private double price;
	public Product(int i,String str,double d){
		this.id=i;
		this.description=str;
		this.price=d;
	}
	public String toString(){
		return id+": "+description+",price: "+price;
	}
	public static Generator<Product> generator(){
		return new Generator<Product>() {
			private Random random=new Random(47);
			public Product next() {
				// TODO Auto-generated method stub
				return new Product(random.nextInt(1000), "Test", Math.round(random.nextDouble()*1000)+0.99);
			}
		};
	}
}
class Shelf extends ArrayList<Product>{
	public Shelf(int npro){
		Generators.fill(this, Product.generator(), npro);
	}
}

class Aisle extends ArrayList<Shelf>{
	public Aisle(int nsh,int npro){
		for(int i=0;i<nsh;i++){
			this.add(new Shelf(npro));
		}
	}
}
class CheckoutStand{
	
}
class Office{}

public class Storm extends ArrayList<Aisle>{
	private ArrayList<CheckoutStand> checkoutStands=new ArrayList<CheckoutStand>();
	private Office office=new Office();
	public Storm(int nas,int nsh,int npro){
		for(int i=0;i<nas;i++){
			add(new Aisle(nsh, npro));
		}
	}
	
	public String toString(){
		StringBuilder sbBuilder=new StringBuilder();
		for(Aisle aisle:this){
			for(Shelf shelf:aisle){
				for(Product product:shelf){
					sbBuilder.append(product);
					sbBuilder.append("\n");
				}
			}
		}
		return sbBuilder.toString();
	}
	public static void main(String[] agrs){
		Storm storm=new Storm(14, 5, 10);
		System.out.print(storm );
	}
	
}
