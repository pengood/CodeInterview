package net.mindview.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
 enum Gender {  
    MALE, FEMALE  
} 
 class PersonProxy implements java.io.Serializable
{
 public PersonProxy(Person orig)
 {
     data = orig.getFirstName() + "," + orig.getLastName() + "," + orig.getAge();
     if (orig.getSpouse() != null)
     {
         Person spouse = orig.getSpouse();
         data = data + "," + spouse.getFirstName() + "," + spouse.getLastName() + ","  
           + spouse.getAge();
     }
 }

 public String data;
 private Object readResolve() throws java.io.ObjectStreamException
 {
     String[] pieces = data.split(",");
     Person result = new Person(pieces[0], pieces[1], Integer.parseInt(pieces[2]));
     if (pieces.length > 3)
     {
         result.setSpouse(new Person(pieces[3], pieces[4], Integer.parseInt
           (pieces[5])));
         result.getSpouse().setSpouse(result);
     }
     return result;
 }
}

public class Person implements java.io.Serializable
{
 public Person(String fn, String ln,int a)
 {
     this.firstName = fn; this.lastName = ln; this.age = a;
 }

 public String getFirstName() { return firstName; }
 public String getLastName() { return lastName; }
 public int getAge() { return age; }
 public Person getSpouse() { return spouse; }

 private Object writeReplace()
     throws java.io.ObjectStreamException
 {
     return new PersonProxy(this);
 }
 
 public void setFirstName(String value) { firstName = value; }
 public void setLastName(String value) { lastName = value; }
 public void setAge(int value) { age = value; }
 public void setSpouse(Person value) { spouse = value; }   

 public String toString()
 {
     return "[Person: firstName=" + firstName + 
         " lastName=" + lastName +
         " age=" + age +
         "]";
 }    
 
 private String firstName;
 private String lastName;
 private int age;
 private Person spouse;
 public static void main(String[] args) throws Exception {  
     File file = new File("person.out");  
     ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file)); 
    
     oout.writeObject(new Person("zhao", "peng", 23)); // 保存单例对象  
     oout.close();  

     ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));  
     Object newPerson = oin.readObject();  
     oin.close();  
     System.out.println(newPerson);  
   

}
}
	  