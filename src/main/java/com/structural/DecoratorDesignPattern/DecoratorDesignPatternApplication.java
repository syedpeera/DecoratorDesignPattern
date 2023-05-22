package com.structural.DecoratorDesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DecoratorDesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(DecoratorDesignPatternApplication.class, args);
		Pizza plainPizza = new PlainPizza();
		System.out.println("Plain Pizza: ");
		System.out.println("Description: "+plainPizza.getDescription());
		System.out.println("Cost: $"+plainPizza.getCost());
		
		Pizza cheesePizza = new Cheese(plainPizza);
		System.out.println("Cheese Pizza: ");
		System.out.println("Description: "+cheesePizza.getDescription());
		System.out.println("Cost: $"+cheesePizza.getCost());
		
		Pizza mushroomPizza = new Mushroom(cheesePizza);
		System.out.println("Mushroom Pizza: ");
		System.out.println("Description: "+mushroomPizza.getDescription());
		System.out.println("Cost: $"+mushroomPizza.getCost());
		
		Pizza deluxePizza = new TomatoSauce(new Cheese(new Mushroom(plainPizza)));
		System.out.println("Deluxe Pizza: ");
		System.out.println("Description: "+deluxePizza.getDescription());
		System.out.println("Cost: $"+deluxePizza.getCost());
	}
}
