package com.think.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.think.unit1.Person;

public class StandardFunctionalInterface {

	public static void main(String[] args) {
		List<Person> people=Arrays.asList(
				new Person("Charles","Dickens",60),
				new Person("Lewis","Carroll",42),
				new Person("Thomas","Carlyle",51),
				new Person("Charlotte","Bronte",45),
				new Person("Mathew","Arnold",39)
				);
		//sort  by last name
		//Collections.sort(people,(Person p1,Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
		Collections.sort(people,(p1,p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		//print all
		//printAll(people);
		System.out.println("Printing all the person");
		printCondoitionally(people,p->true,p-> System.out.println(p));
		
		//print those whose last name starts with "C"
		//printAllLastNmeWithC(people);
		System.out.println("Printing the person whose last name starts with C");
		printCondoitionally(people,p->p.getLastName().startsWith("C"),p-> System.out.println(p));
		System.out.println("Printing the person whose first name starts with C");
		printCondoitionally(people,p->p.getFirstName().startsWith("C"),p-> System.out.println(p));
		printCondoitionally(people,p->p.getFirstName().startsWith("C"),p-> System.out.println(p.getFirstName()));
	}

	
//	  private static void printAllLastNmeWithC(List<Person> people) { 
//		  for(Person p:people){ 
//			  if(p.getLastName().startsWith("C")) { 
//				  System.out.println(p); } }
//	  
//	  }
//	
	//using java out of the box functional interface Predicate java.uti.function package. No need to create new interview
	private static void printCondoitionally(List<Person> people,Predicate<Person> predicate,Consumer<Person> consumer) {
		for(Person p: people){
			if(predicate.test(p)) {
				consumer.accept(p);
			}
		}
		
	}
	
//	private static void printCondoitionally(List<Person> people,Condition condition) {
//		for(Person p: people){
//			if(condition.test(p)) {
//			System.out.println(p);
//			}
//		}
//		
//	}

//	private static void printAll(List<Person> people) {
//		for(Person p: people){
//			System.out.println(p);
//		}
//		
//	}

}
