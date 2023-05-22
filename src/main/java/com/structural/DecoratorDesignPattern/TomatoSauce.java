package com.structural.DecoratorDesignPattern;

public class TomatoSauce extends PizzaDecorator{

	public TomatoSauce(Pizza pizza) {
		super(pizza);
	}

	public String getDescription() {
		return super.getDescription()+", Tomato Sauce";
	}
	
	public double getCost() {
		return super.getCost()+0.75;
	}
}
