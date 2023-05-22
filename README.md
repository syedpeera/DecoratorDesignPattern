# DecoratorDesignPattern

Overview:
In object-oriented programming, the decorator pattern is a structural design pattern that allows behaviour and functionality to be dynamically added to an object without affecting the behaviour of other objects in the same class. Because it offers a wrapper to an existing class, the decorator design pattern is also known as Wrapper. To implement the wrapper, this approach uses abstract classes or interfaces with composition. Decorator classes are used to extend the functionality of the base class.

When Will We Need Decorator Design Pattern?
The following are the indicators which show the requirement of the decorator design pattern:

1. When one has an object that requires functionality extension. For extending functionality, decorators are a versatile alternative to subclassing.
2. When one has to recursively rewrap or change the functionalities of an object according to the requirements, dynamically without affecting other objects of the class.
A real-life example of a decorator design pattern would be a pizza, pizza base here would be the original class, and the variety of different toppings would act as the added functionalities. The customer can add toppings (functionalities) as per their choice and the pizza base (original class) will remain intact.

Other examples of decorator design pattern:

1. Decorating a Christmas tree.
2. Adding toppings to ice cream.
3. Clothes on a human body.
4. Interior decoration of a building.

Consider the following scenario: there is a table that has a temporary need for a few more rows and columns. Similar requests revolving around the initial table arise frequently, and the owner does not want to start from scratch every time something new comes up. The decorator pattern comes to the rescue in this situation. The owner can develop a decorator class that can be customized to meet specific needs. This eliminates the need to create a new table every time, and the decorator class may be reused with minor changes.

How Does Decorator Design Pattern Work?
Structure
UML Diagram


1. Color: This interface (or an abstract class) serves as the foundation for all concrete components as well as all decorator classes. This base class defines any conventional members that will be used by all the concrete components and decorator classes such as fill() method.
2. Black: This is the concrete component class which inherits the base component class. There may be more than one concrete classes, specifying different objects for the decorators like pattern decorator. Here Black class implements the Color interface.
3. ColorDecorator: This abstract decorator class serves as the foundation for all component decorators. Decorators adds a constructor that takes an object of the base class as a parameter. This enables the use of numerous decorators on a single object, that is, the behaviour of several classes can be used by an object and the classes can have references to numerous objects and delegate work to them.
4. Concrete Decorator: In the above diagram, 'PatternDecorator' is the concrete decorator class, it provides a decorator for the class objects. An additional operation method, addPattern() has been added to the decorator. The user can construct more concrete decorator classes as needed. For example, if the user wants to accommodate a gradient feature, the user can define the addGradient() method. This way, any number of methods to enhance the functionality of the objects can be defined.

Implementation:
1. Create an interface (or an abstract class), Color, and define a method fill() to be used by all the concrete and decorator classes.
2. Create a concrete class like the class 'Black' used in the above diagram. This class implements the component class and overrides the fill() method.
3. Now, create an abstract decorator class, ColorDecorator which implements the Color interface.
4. Define the object, colored of the base interface, Color. This is the object which requires an extension and will be wrapped by the decorator class.
5. Initialise the constructor and pass the object, colored, as a parameter in the constructor. This object is inherited from the base class.
6. Create a concrete decorator class, PatternDecorator which inherits the base decorator class, ColorDecorator. Define a new method addPattern(), to add functionalities to the wrapped object.

Code Example:
Java:


interface Color{
    void fill();
}

//concrete component of the base interface
class Black implements Color{
    @Override
    public void fill(){
        System.out.println("Black color");
    }
}

//abstract decorator class
abstract class ColorDecorator implements Color{

    //base class object
    protected Color colored;
    
    //constructor with base class object as the parameter
    public ColorDecorator(Color colored){
        this.colored = colored;
    }
    
    public void fill(){
        colored.fill();
    }
}

//concrete decorator class extending base decorator class
class PatternDecorator extends ColorDecorator{
    public PatternDecorator(Color colored){
        super(colored);
    }
    
    public void fill(){
        colored.fill();
        addPattern(colored);
    }
    
    private void addPattern(Color colored){
        System.out.println("Pattern");
    }
}

class Demo{
    public static void main(String[] args){
    
    Color black = new Black();
    Color pattern = new PatternDecorator(new Black());
     
    System.out.println("\nStyle: Solid");
    black.fill();
    
    System.out.println("\nStyle: Pattern");
    pattern.fill();
    }
}
    
Output:
Style: Solid
Black color

Style: Pattern
Black color
Pattern

Pros:
1. A decorator design pattern provides a high degree of flexibility as an alternative to subclassing for functionality extension.
2. Instead of editing the existing code, decorators allow behaviour modification at runtime.
3. Problems with permutation are resolved. Wrapping an object in numerous decorators allows you to mix multiple behaviours.
4. The decorator design pattern adheres to the concept that classes should be extensible but not modifiable.
5. Decorator pattern follows the Single responsibility principle which states that a monolithic class with multiple tasks can be broken down into various classes, each with a particular responsibility or task.

Cons:
1. Decorators might result in a lot of small elements in our design, which can be difficult to manage.
2. This design pattern is not beginner-friendly.
3. Debugging is quite difficult because of the extended decorator components.
4. The architecture may have very high complexity, especially due to the decorator interface.

Comparison with Other Similar Design Patterns:
1. The purpose of a decorator pattern is to enhance and decorate a particular object, whereas the purpose of a composite pattern is to combine together components as a whole.
2. Decorator design pattern allows you to add functionalities to an object without subclassing, the emphasis in Composite design pattern is on representation rather than decoration.
3. The decorator pattern enables you to modify or extend existing functionality at runtime. The strategy pattern enables you to alter the implementation of anything that is being used in runtime.
4. In contrast to the Decorator pattern, which alters and decorate the functionality of pre-existing instances, the Proxy pattern offers the same interface as the object it holds the pointer to and does not affect the data in any way.
5. Even though the Proxy and Decorator patterns offer similar structures, their goals are different. While the primary goal of a Proxy is to provide easy usage or manage access, a Decorator adds in extra responsibilities.
6. Though the structure of the Adapter and Decorator patterns are similar, the aim of each pattern differs. The adapter pattern is used to connect two interfaces, whereas the Decorator pattern is used to introduce additional functionality without changing the current code.

Summary:
The decorator design pattern is a structural design pattern in object-oriented programming that enables behaviour and functionality to be dynamically extended to an object while not impacting other objects in the same class. Decorator classes are designed to upgrade the underlying class's capabilities. This technique employs abstract classes or interfaces with composition to implement the wrapper. It adheres to the Single Responsibility Principle, which argues that a monolithic class can be divided into multiple classes, each with its own set of responsibilities and tasks. As a potential alternative to subclassing for functionality extension, the decorator design pattern delivers a lot more fluidity.

FAQs:
1.Why is decorator a structural pattern and not a behavioural pattern?

Relationships between entities are the focus of structural design patterns, which make it simpler for these entities to collaborate. Behavioural Design Patterns are used to maintain simpler and more flexible communication between entities. Decorator is a method for constructing functionality, so it fits well with structural patterns.

2. What is the difference between decorator pattern and chain of responsibility pattern?

The chain-of-responsibility pattern is fairly similar in structure to the decorator pattern, with the exception that in the decorator, all classes handle the request, but in the chain of responsibility, the request is handled by one class only.
