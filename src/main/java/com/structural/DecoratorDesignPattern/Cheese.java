package com.structural.DecoratorDesignPattern;

public class Cheese extends PizzaDecorator{

	public Cheese(Pizza pizza) {
		super(pizza);
	}

	public String getDescription() {
		return super.getDescription()+", Cheese";
	}
	
	public double getCost() {
		return super.getCost()+1.5;
	}
}
