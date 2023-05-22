package com.structural.DecoratorDesignPattern;

public class Mushroom extends PizzaDecorator{

	public Mushroom(Pizza pizza) {
		super(pizza);
	}

	public String getDescription() {
		return super.getDescription()+", Mushroom";
	}
	
	public double getCost() {
		return super.getCost()+1.25;
	}
}
