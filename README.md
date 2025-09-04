# Java upskilling notes

- [Java upskilling notes](#java-upskilling-notes)
  - [Basics](#basics)
  - [Refactoring](#refactoring)
  - [Code smells](#code-smells)
  - [Memory model \& value and reference types](#memory-model--value-and-reference-types)
    - [Garbage collection](#garbage-collection)
  - [Naming conventions](#naming-conventions)
  - [Debugging in IntelliJ](#debugging-in-intellij)
  - [Conditionals](#conditionals)
  - [*pom.xml* file](#pomxml-file)
- [Testing with JUnit](#testing-with-junit)
  - [`@Test`](#test)
  - [`ParameterizedTest` (for ranges etc.)](#parameterizedtest-for-ranges-etc)
  - [BeforeAll, BeforeEach, AfterAll, AfterEach](#beforeall-beforeeach-afterall-aftereach)
  - [Order](#order)
  - [Hamcrest](#hamcrest)
- [Data types](#data-types)
  - [Enums](#enums)
  - [Dates and times](#dates-and-times)
- [Methods](#methods)
  - [Constructor methods](#constructor-methods)
  - [Static methods](#static-methods)
  - [Static variables](#static-variables)
  - [Built-in methods](#built-in-methods)
    - [Overriding `.equals()` and `.hashCode()`](#overriding-equals-and-hashcode)
  - [Abstract classes](#abstract-classes)
  - [`final` keyword](#final-keyword)
- [OOP](#oop)
  - [Encapsulation](#encapsulation)
    - [Access modifiers (for methods, classes, \& variables)](#access-modifiers-for-methods-classes--variables)
  - [Polymorphism](#polymorphism)
    - [Interfaces](#interfaces)
  - [Inheritance](#inheritance)
- [SOLID principles](#solid-principles)
- [Collections](#collections)
  - [ArrayLists](#arraylists)
  - [HashSets](#hashsets)
  - [Queues and deques](#queues-and-deques)
    - [Queues](#queues)
    - [Deques](#deques)
- [Maps](#maps)
  - [HashMaps](#hashmaps)
- [Generics](#generics)
- [Exceptions (`try`, `catch`)](#exceptions-try-catch)
  - [Handling unchecked exceptions](#handling-unchecked-exceptions)
  - [Handling checked exceptions](#handling-checked-exceptions)
  - [`finally` keyword](#finally-keyword)
- [File I/O](#file-io)
- [Logging](#logging)
  - [Console handler](#console-handler)
  - [File handler](#file-handler)
- [Streams](#streams)
- [Lambda expressions](#lambda-expressions)
- [Helpful info](#helpful-info)
  - [IntelliJ plugins](#intellij-plugins)

## Basics

![Java components](image-4.png)

- the JDK includes everything needed to run your Java code
- once Java code (stored in *.java* files) is compiled (into *.class* files), it's in byte code, which is then converted into machine-readable code that can be read by different OSes
- when you run Java code, the JDK runs it on a virtual machine, which are different across OSes
- the `main` method of a class is where all the code runs from — i.e. it calls all the classes and libraries etc. needed to run an app
- methods should have a single responsibility to conform to SOLID principles
  - however, production code (e.g. for webapps) **doesn't have a `main` method** because it does not run as an independent thread; instead, it includes classes and methods which are all called somewhere else
- the **method signature** is the first line of code that creates it e.g. `public static void...`
- external libraries in IntelliJ hold code from the JDK
- **compiling** doe turns it into executable code
  - **running** code executes those executables
- use the wildcard `*` to import everything from a package, e.g. `import org.junit.jupiter.api.*`
- you can use `var` if you want Java to infer the data type of a variable
- **scope** in Java is outside of the curly brackets
- **dependency injection**: injecting an implementation of an interface/class/object into another interface/class/object (e.g. `public Person(String fName, String lName, Address address) {...}` which injects an implementation of the Address class into the Person class) -- it's using an interface/object/class etc. as an argument e.g. in a constructor
- **feature envy**: when a method accesses the data of another object to perform a task -- the method should instead be in that object's definition as methods that deal with a variable should also belong to the class that "owns" the variables

## Refactoring

- **refactoring**: restructuring code to align with best practices (readability, extending, maintaining), ***without modifying its behaviour***
  - refactor when the code is causing an issue
  - try to get the code working first via unit tests, and push this working version before refactoring
- if you want to rename something, right click it, choose *Refactor*, and rename it there — this way, it will rename it everywhere it's used

## Code smells

- **inappropriate names**: names should be clear, concise, and meaningful
- **redundant comments**: comments need to be maintained along with code, and also should largely be replaced by descriptive & meaningful code
- **dead code:** code that is never used
- **duplicate code:** keep code DRY (don't repeat yourself)
- **long methods**: 2-4 lines, maximum of 20 in a method -- otherwise, check if it's doing what it needs to do or doing more
- **data clumps**: when the same group of instance variables keep appearing together (e.g. the separate elements of an address always appearing together) -- it might be a better idea for it to be grouped together in a separate class
- [More here](https://refactoring.guru/refactoring/smells)

## Memory model & value and reference types

- the RAM contains the stack and the heap
- depending on the Java data type, it will either be stored in the stack or the heap
- **stack**:
  - fast-access memory
  - last in, first out; when you leave the scope, everything is **popped** from it
- **heap**:
  - a larger area of memory holding data belonging to reference types
  - when a new reference type is created, the system finds space for it on the heap
- **value types**:
  - written in lowercase
  - smaller, simple data types with fixed sizes like int, char, boolean, enum, float
  - each variable has a copy of its own data
  - stored in the stack
- **reference types**:
  - written in title case
  - larger and have variable size
  - e.g. String, Integer, ArrayList
  - variables containing these data types contain a reference (i.e. an address) in the stack to where to find the data in the memory (the heap)
  - stored in the heap
  - use references because copying these may be quicker than copying the object itself (as they are larger)

### Garbage collection

- data stored on the heap that isn't linked to a variable (e.g. if it was originally but has been overwritten with a new value) is a **dead object**
  - the heap **regularly gets rid of dead objects** (via the **garbage collector**) to prevent them filling up the memory and free up memory
  - the garbage collector also moves live objects closer to each  other to optimise space (**compaction**)
- once you go out of scope (i.e. the curly brackets), data in the stack is removed (i.e. not accessible unless you go back into the previous scope)
- arguments used in method calls are *copied* into method's memory space as *local* parameters (either the value of the address is copied, depending on the argument's type)
  - if the argument is a value type and it's modified in the method, these modifications are local
  - if the argument is a reference type and modified, it will modify it globally (unless it has been reassigned to a new variable, which effectively copies the value of a reference type to a new memory address)

## Naming conventions

- packages are named like `com.sparta.fc.refactoring` as the dot notation creates multiple directories (i.e. *com/sparta/fc/refactoring* all within *src/*)
  - you could then also have a package called `com.sparta.fc.selection` which would be another subfolder under *fc/*
- classes are NamedLikeThis
- vars and methods are named likeThis

## Debugging in IntelliJ

- set a break point to stop the code from running past that point, and click *Debug*
- click *step into* to go into any method being called
- click *step over* to go to the next line

## Conditionals

- for simple if-else statements, use the **ternary operator** `?` like `condition ? <what to return if successful>: <what to return if not successful>;`
  - e.g. `mark>= 65 ? "Pass": "Fail";`
- you can also chain these by nesting like `1st condition ? (2nd condition ? <what to return if 2nd condition successful> : <what to return if 2nd condition not successful>) : <what to return if 1st condition is unsuccessful>` (though it's best not to as this is less readable)
  - e.g. `mark >= 65 ? (mark >= 85 ? "Distinction": "Pass") : "Fail";`

## *pom.xml* file

- ***pom.xml***: a fundamental Maven file that defines the config & dependencies for building a Java project
- within the file, you can right click, choose *Generate dependency*, and search for existing artifacts/classes to insert into the file (note that these use the naming format of `org.package.subpackage:version` e.g. `org.junit.jupiter:junit-jupiter:5.9.3`)
- once done editing the *pom.xml* file, click the little M icon in the right-hand corner to reload and download the new libraries

# Testing with JUnit

- developers write **unit tests** for code, testers do other types of testing
- **unit tests**: testing that the smallest testable parts of an app (.e.g functions/methods) work correctly in isolation
- **unit tests effectively document your code**, so they should cover all test boundaries 
- shouldn't be **any control flow logic in a test** — it should just test boundaries
- if you are **in any doubt** about changing a test that relies on external input, **consult the product owner** -- benefits need to be weighed
- write unit tests to test edge cases (i.e. **boundary value analysis**) because exhaustive testing is impossible
- **boundary value analysis**: testing the boundaries of ranges (e.g. the minimum and maximum, and just outside the range) to ensure the code's logic is correct
  - example edge cases for `timeOfDay`: ![alt text](image-1.png)
  - most errors cluster around boundaries of `>=` (i.e. because one value can be accounted for by 2 tests)
- follow the **arrange, act, assert** format to design tests

## `@Test`

- allocate a method as a test method by using `@Test` above the method (**this method is best for testing single values; see below for passing a set of values to a test**)
  - then give the test a **descriptive display name** in the general format of `@DisplayName("function, when given a value of x, returns y")
  - **also use a descriptive name for the test method itself**
- example:
```
@Test
@DisplayName("getGreeting, when given a time of 21, returns Good Evening")
public void getGreeting_GivenATimeOf21_ReturnsGoodEvening(){
        // Arrange
        int time = 21;
        String expected = "Good evening!";

        // Act
        String actual = App.getGreeting(time);

        // Assert
        Assertions.assertEquals(expected, actual);
    }
```
- note that the above can also be written in one line like `Assertions.assertEquals("Good evening", App.getGreeting(21));`
- example failing test ![alt text](image.png)

## `ParameterizedTest` (for ranges etc.)

- **parameterised tests** allow you to test a method with a set of values via `@ValueSource`, not just one; e.g.:
```
@ParameterizedTest
    @ValueSource(ints = {5, 11})
    @DisplayName("getGreeting, when given a time from 5 to 11, returns Good morning!")
    public void getGreeting_GivenATimeFrom50To11_ReturnsGoodMorning(int time){
        Assertions.assertEquals("Good morning!", App.getGreeting(time));
    }
```
- for pairs of values, you can also use `CsvSource` instead of ValueSource (which only works with one dimension of values); e.g.:
```
@ParameterizedTest
    @DisplayName("getGreeting, when given a time, returns an appropriate greeting")
    @CsvSource({
            "Good evening!, 2",
            "Good morning!, 8",
            "Good afternoon!, 15",
            "Good evening!, 21"
    })
    public void givenATime_Greeting_ReturnsAnaAppropriateGreeting(String expected, int time){
        Assertions.assertEquals(expected, App.getGreeting(time));
    }
```
  - however, the testing best practice is to **split tests up so that they are readable and clearly document the code, so it's better to use `@ValueSource`**

## BeforeAll, BeforeEach, AfterAll, AfterEach

- `BeforeAll` runs once before all tests, and must be static (as it needs to be accessible by the other methods in the test class)
- `BeforeEach` runs before each test, and can't be static (as it needs to be independent)
- `AfterAll` runs once after all tests, and must be static (as it needs to be accessible by the other methods in the test class)
- `AfterEach` runs after each test, and can't be static (as it needs to be independent)

## Order

- 

## Hamcrest

- a testing framework that allows you to write more flexible tests
- makes unit tests more readable
- the failure method (when a test fails) is more descriptive
- examples for `String testString = "The quick brown fox jumps over the lazy dog.";`:
  - `assertThat(exampleResult, is(expectedResult))`
  - `assertThat(testString, startsWith("The"));`
  - `assertThat(testString, containsStringIgnoringCase("the"));`
  - `assertThat(testString, stringContainsInOrder("quick", "jump", "lazy"));`
  - `assertThat(testString, not(emptyOrNullString()));`

# Data types

## Enums

- a group of constants (i.e. unchangeable variables)
  - helpful when you want to restrict values to a set list 
- naming convention for constant variables should be in upper case
- declare a class an Enum class
- there are existing Enums e.g. days of week
- defining constants starts with making them static and final
- defined like:
```
public enum SeasonsEnum {
        SPRING,
        SUMMER,
        AUTUMN,
        WINTER
    }
```
- you can loop through Enum values like:
```
for(SeasonsEnum season: SeasonsEnum.values()){
            System.out.println(season);
        }
```

## Dates and times

- **three classes for dates**:
  - `java.util.Date`
  -   `java.sql.Date`: a subclass of the above that conforms to the way dates are represented in SQL
  - `java.time.LocalDate` is the preferred method as many of the methods in `java.util.Date` are deprecated
- ![alt text](image-2.png)  

# Methods

## Constructor methods

- the constructor **must have the same name as the class** (so that it's called when a new object of the class is created)
- this method initialises an object instance of a class
- shortcut: right-click and choose *Generate* > *Constructor* to make a constructor method for a class
- **constructor chaining**: method overloading the constructor method so it takes less than the full number of parameters and provides a default value for the remaining params
  - this is also called compile-time polymorphism because, if you right click the use of a chained constructor method and click go to > implementations, you'll see that IntelliJ takes you to the correct constructor (and it knows to do this even before you have run the programme)
- if you don't add a constructor method to a class, by default, a parameter-less one is put into the class in the background
  - however, once you create another constructor, the parameter-less one will disappear (unless you recreate it explicitly like `public Member(){}`)

## Static methods

- belong to the class itself, not the instances, e.g. `Math.pow()` is static
- can be run without the class having an object
- to use non-static methods, you have to create an object of the class first e.g. `Member me = new Member();`  

## Static variables

- can be used by the entire class

## Built-in methods

- these are inherited by everything from the Object class
- they can be overridden (if not `final` methods) to perform custom behaviour

- `.getClass()` returns the class of the object
- `.toString()` returns class and memory location of an object
- `.equals(x)` checks if two objects contain the same value 
- `.hashCode()` returns unique identifier for object

### Overriding `.equals()` and `.hashCode()`

- you must **override both** if you're going to override one because they're linked
- you can do this automatically by right-clicking and choosing *Generate* > *equals() and hashCode()*
- standard format of overriding `.equals()` so that it returns true when two objects with the same parameter values are the same (this is not the default):
```
public boolean equals(Object obj) {
        if (!(obj instanceof ExampleClass example))
            return false; // checking to see if obj is not an object of the ExampleClass class, but if it is, storing it in example variable
        else { // if it is an ExampleClass object
            return Objects.equals(this.firstName, example.firstName) && Objects.equals(this.lastName, example.lastName) && Objects.equals(this.joinDate, example.joinDate); // do this for every parameter taken by the ExampleClass
        }
    }
```
- standard format of overriding the `hashCode()` method so that it returns the same hash code if each of an object's parameter values are the same:
```
public int hashCode() {
        return Objects.hash(firstName, lastName, joinDate); // include every parameter taken by the given class (e.g. Member or Animal)
    }
```

## Abstract classes

- the purpose of abstract classes is to ensure that **they can't be instantiated as an object** — their purpose is ***to be derived from***
- they don't need constructors
- along with normal methods, you can also have abstract (i.e. empty) methods in an abstract class e.g. a `speak()` method in an abstract Animal class (empty because every derived class will speak differently)
  - the derived classes must then fill in the method
- example:
```
public abstract class Animal {
    public abstract String speak();
}
```

## `final` keyword

- if used on a class, it can't have any sub-classes ("vasectomy")
- if used on a variable, its value can never be changed
- if used on a method, it can't be overridden

# OOP

- **abstraction**:
  - the concept of classes, which is that classes are blueprints of real-life objects (an object is an instance of a class)
- **encapsulation**:
  - concept of data hiding & exposing e.g. thru `private` & `public` methods & variables
- **polymorphism**:
  - different implementations of the same thing
  - has two types: **method overriding** & **method overloading** 
- **inheritance**:
  - a hierarchical relationship between classes (e.g. subclasses)

## Encapsulation

### Access modifiers (for methods, classes, & variables)

- these are how data is exposed & hidden

- **public**: accessible in any class or package (never make fields public)
- **private**: accessible only within the same class (you can get around this in sub-classes using getters & setters)
- **protected**: accessible within the same package and sub-classes
- **default**: accessible only within the same package (doesn't need to be explicit stated as it's the default)

## Polymorphism

- different implementations of the same thing
- **method overriding:** creating a method with the same name & parameters as an existing inherited method, except it does something different — this is *run-time polymorphism*
  - example of overriding an inherited method:
```
@Override
    public String toString(){
        return super.toString() + " and is a " + this.getPosition();
    }
```
- **method overloading:** methods that have the same method signature, but take different (types or number of) parameters — this is *compile-time polymorphism*
  - example of overloading a method:
```
public int add(int a, int b){
        return a + b;
    }

    public double add(double a, double b){
        return a + b;
    }
```

### Interfaces

- single inheritance causes an issue if you want a class to inherit from multiple classes
- interfaces solve this issue by allowing classes to inherit from them (and there is no limit on them)
- interfaces are entirely abstract
- the idea is that unrelated classes can inherit from them
- all their methods are abstract -- you just provide the return type and the method name like `void Printable();` or `String move();`
- you add them to a class like `public class exampleClass implements ExampleInterface` in the method signature
- if you implement an interface in a concrete class, you **must fill in (i.e. implement) its methods**
  - however, if you implement an interface in an abstract class, you don't need to implement (fill in) its methods as abstract classes take abstract methods

## Inheritance

- Java **only allows single inheritance, i.e. inheriting from one super-class**
- derived (child) classes are essentially **specialisations** of the super-class
- inheritance allows your code to remain DRY (don't repeat yourself)
- use `extends` in the class signature to establish the inheritance relationship
- sub-class constructors use the `super()` method not `this.` like:
```
public class BaseballMember extends Member{

    private String position; // new BaseballMember-specific variable

    public BaseballMember(String firstName, String lastName, int year, int month, int day, String position) {
        super(firstName, lastName, year, month, day); // inherited
        this.position = position; // BaseballMember-specific
    }
}
```
- the super-class can access all of the objects of its sub-class(es)
- sub-classes **cannot access private variables & methods from the super-class**
  - but they can access `protected` variables & methods
- any time you create a class, you inherit from the Object class, which has methods like `.clone()` and `.toString()`
  - some of these built-in methods are private, which mean you can't override them
- **note that you cannot inherit from `final` classes**

# SOLID principles

- principles that make sure you take advantage of OOP

- **S: Single responsibility**
  - a class (e.g. testing class) should only have one responsibility (e.g. don't have inventory management, payment, receipts in one programme, and don't have one program do the conditional logic as well as printing out the results)
  - **benefits**:
      - fewer test cases for test classes
      - lower coupling (i.e. fewer dependencies with other classes)
      - better readability and easier to search smaller, well-organised classes
- **O: Open/closed**
  - classes should be **open for extension**, but **closed for modification** (except for fixing bugs) so that the blueprint stays a blueprint and not a specialisation
  - i.e. create **specialised iterations of objects** and **don't modify the blueprint** (e.g. Shirt class and a BlueShirt class so that non-blue shirts can still inherit from the Shirt class)
  - **benefits**:
    - stops causing new bugs
    - allows others to inherit from the same library for their own uses
- **L: Liskov substitution**
  - about doing polymorphism correctly & **expected behaviour**
  - based on the **principle of least astonishment**: a component of a system should behave in a way that most users will expect it to behave, and therefore not astonish or surprise users
  - **a child class should be able to do everything its parent class can** (i.e. if class A is a subtype of class B, we should be able to replace B with A without disrupting the behaviour of the program)
  - i.e. don't inherently change the behaviour of the program (e.g. don't have a penguin class inheriting from a flying bird class, make it a child class of a non-flying bird class)
  - if every class is implementing the interface `Move`, we expect it can move so it should do, or it should inherit another interface (**don't just throw an exception** -- this may work code-wise, but doesn't make sense in the real world) 
- **I: Interface segregation**
  - larger interfaces should be split into smaller, focused ones that do not force their child classes to implement behaviour they don't need
  - **benefits**:
    - ensures that classes that implement interfaces only need to be concerned about the methods of interest to them (e.g. card-only checkouts shouldn't implement an interface with a `giveChange()` method, the interface should be split up)
- **D: Dependency inversion**
  - high-level modules should not depend on low-level modules, they should both depend on an abstraction
  - a module shouldn't care about the implementation details of its dependencies (e.g. a Toaster class shouldn't have to include code on turning the power supply on; that should be the business of the Power class)
  - modules should depend on abstractions, not concrete implementations
  - **benefits**:
    - loose coupling, which allows for flexibility

# Collections

- an advantage of using the Collections interface is that they can be resized
- you can only use non-primitive data types like String, Integer etc. with objects from the Collections interface
- interfaces included:
  - **List**:
    - ordered
    - allows duplicates
    - supports null elements (depending on implementation)
  - **Set**:
    - unique values only
    - unordered (except LinkedHashSet)
    - one null allowed
    - includes HashSet, EnumsSet, LinkedHashSet, TreeSet
  - **Queue**:
    - first in, first out
    - cannot be accessed by index
    - includes PriorityQueue, ArrayQueue
  - **Deque**:
    - 
- have methods like:
  - `add`
  - `addAll`
  - `toArray`
  - `clear`
  - 

## ArrayLists

- unlike Arrays, these can be resized and have more methods
- **List**: an interface that has more methods than an array (e.g. add, set, clear)
- **ArrayLists**: a class that implements the List interface & inherits its methods; **can be resized**; must use an object as a data type
  - created like: `ArrayList<Integer> ints = new ArrayList();` or with values like
```
ArrayList<Integer> dates = new ArrayList<>(List.of(5, 10, 15, 20, 25));
dates.add(20); // resizing arraylist by adding
dates.remove(Integer.valueOf(20)); // removing element by value
dates.remove(1);
```
- **note that you can use `List<data type>` too, but this has some subtle differences from `ArrayList<data type>`, e.g. it won't be able to use ArrayList methods like `.ensureCapacity()` or .`trimToSize()`**
- example with strings:
```
ArrayList<String> alphabetList = new ArrayList<String>();
        alphabetList.add("A");
        alphabetList.add("B");
        alphabetList.add("C");
        alphabetList.add("D");
        alphabetList.add("E");
        alphabetList.add("F");
        alphabetList.add("G");
```
- example methods:
  - `.size()`: gets length
  - `.sort()` sorts A-Z
    - `.sort(Comparator.reverseOrder())` sorts in reverse order
  - `.add(x)` adds given element to ArrayList
    - .`addAll(collection)` adds a whole collection of items to a list
  - `.remove(x)` removes the given element from the list
    - `.removeIf(x>1)` removes all items from the list that match the given condition
  - `.replaceAll(x+5)` replaces each item in the list with the result of the given action
  - `.clear()` removes **all items** from list
  - `.clone()` creates a copy of the list
  - `.contains(x)` checks whether x exists in the list
  - `.forEach(action)` performs an action on element of the list
  - `.get(0)` returns the element at the given index
  - `.indexOf(x)` returns the index of the first element in the list that matches the given value
  -  `.isEmpty()` checks if list is empty

## HashSets

- uses Set interface
- only contains unique values
- are ordered by their hashcodes, but not indexed
- most commonly used to search for elements

## Queues and deques

### Queues

- first in, first out,
- created and modified like:
```
Queue<String> myNameQueue = new LinkedList<>();
        myNameQueue.add("Farah"); // adds to the back of the queue
        myNameQueue.add("Hannah");

        myNameQueue.peek(); // returns the first thing added to the stack
        myNameQueue.remove(); // removes the first thing added to the stack
        myNameQueue.poll(); // returns AND removes the first thing in the queue

```

### Deques

- double-ended queue
- push and pop (enqueue and dequeue) off the queue (i.e. stack)
- use cases:
  - undoing last action
  - joining a queue
- created and modified like:
```
Deque<String> myNameStack = new ArrayDeque<>()
myNameStack.push("Farah");
myNameStack.push("Hannah");

myNameStack.peek(); // returns the last thing added to the stack
```

# Maps

## HashMaps

- dictionary-like object with a key-value pair
- initialised with the data type of both e.g. `HashMap<String, Integer>` 
- no duplicate keys, but duplicate values allowed
- `.put(exampleKey, exampleValue)`: adds a key-value pair to the HM
- `.get(exampleKey)`: gets the value associated with a given key 
- `.remove(exampleKey)`: removes the given pair
- `.containsKey(exampleKey)`: returns a boolean value of whether the key exists or not
- `.keySet()`: returns a collection of the keys; useful when iterating over
- `.values()` returns a collection of the values; useful when iterating over

# Generics

- a type of polymorphism (**parametric polymorphism**)
- allow you to write classes, interfaces, etc. that work with different data types and handle them identically
- means you don't have to do any casting of types
- example (note the non-specification of data types in the class creation):
```
public class GenericRectangle<E> { // the E can be replaced with anything
    private E width;
    private E height;
}
``` 
- you must then specify the data type when you create an object of this class, but it can be any data type, e.g.:
```
GenericRectangle<Integer> giRect = new GenericRectangle<>(2, 4);
GenericRectangle<Double> gdRect = new GenericRectangle<>(2.0,4.0);
```
- you may want to set some type limits (via the `extends` keyword) so that not *every* kind of type can be passed to the class & its methods (e.g. if it's a class that only makes sense to pass numbers to, you can specify this)
  - example:
```
public class GenericRectangle<E extends Number> { // the E can be replaced with anything
    private E width; // these can now only be number-types
    private E height; // these can now only be number-types
}
```

# Exceptions (`try`, `catch`)

- **exception types**:
  - **checked**: must be handled in the code before running (e.g. `throws ParseException`)
  - **unchecked** or runtime exceptions: only picked up at runtime (e.g. when you try to access an index that doesn't exist, which is an ArrayIndexOutOfBounds exception; or an Arithmetic exception when you try to divide by 0)
- when an exception is thrown, it creates an Exception object in Java
- we have to handle all exceptions in Java code, preferably when you're actually calling the code (e.g. `main` method) as the handling code may be different depending on the context
- the order of the `catch` blocks matters as it won't accept catching specialised exceptions if it's already caught general ones, so you should order these from specific (like `NullPointerException`) >>> general (like `Exception`)
- `throws` is used in the method signature of a method that has a checked exception **to tell people the method can throw an exception**, whereas `throw` is used in a method body to **actually throw the exception**

## Handling unchecked exceptions

- preferably do this when the method is called
```
try {
            System.out.println(myDog.getName());
            System.out.println(myCat.getName()); // will throw an exception
        } catch(NullPointerException ex) {
            System.out.println("Sorry, that animal does not have a name");
        }
```
- or catch it in the original class:
```
public String getName() {
        try{
            return name.toUpperCase();
        }
        catch(NullPointerException ex){
            System.out.println("---Caught: " + ex);
            System.out.println("---Message: " + ex.getMessage());
            return "No name";
        }
    }
```

## Handling checked exceptions

- add the exception to the method signature (IntelliJ can do this automatically):
```
public void setVaccinationDate(String dateString) throws ParseException {
        vaccinationDate = new SimpleDateFormat("dd-MM-yyy").parse(dateString);
    }
```
- and then handle it in the calling method, e.g.:
```
try {
            myDog.setVaccinationDate("31-02-2020"); // will throw an exception
        } catch (ParseException e) {
            System.out.println("Sorry, that date is invalid");
        }
```
- or handle it in the class with a try/catch block (less preferable):
```
public void setVaccinationDate(String dateString){
        try {
            vaccinationDate = new SimpleDateFormat("dd-MM-yyy").parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
```

## `finally` keyword

- the code in this block (included after a `try`/`catch` block pair) will run **whether or not there is an exception thrown**
```
      try {
            System.out.println(myDog.getName());
            System.out.println(myCat.getName()); // will throw an exception
        }
      catch(NullPointerException ex) {
            System.out.println("Sorry, that animal does not have a name");
        }
      finally {
            System.out.println("This will always run");
        }
```

# File I/O

- Java has 2 packages for file operations: `java.io` (original) and `java.nio` (new)
- `java.nio` is easier to use and better at throwing exceptions
- `Files.readAllLines()` is a good method for small files; it reads everything at once
- if the file is 100s or 1000s of lines long, though, use `Files.newBufferedReader` as it will then read line by line (so you don't have to wait for all the output, and so it doesn't overwhelm system resources)

# Logging

- start logging with `public static final Logger LOGGER = Logger.getLogger(App.class.getName()); // only logs for this class` (changing `App` to whatever the class name is)
- levels of logging:
  1. SEVERE (highest)
  2. WARNING
  3. INFO
  4. CONFIG
  5. FINE
  6. FINER
  7. FINEST (lowest) 
- set logs to a given level and above like `LOGGER.setLevel(Level.WARNING);` which will log `WARNING` logs and above
- log all levels with `logger.setLevel(Level.ALL)`
- turn off logging completely with `logger.setLevel(Level.OFF)`
- - you can set the logging level in your code (e.g. in a `catch` block if an exception is thrown) by adding a line like `LOGGER.log(Level.WARNING, "WARNING: this has been logged as a warning");`
- Apache Log4j is good for Java logging
  
## Console handler

- by default, the console handler will only output a log event if it's `INFO` level or above
- you can override it like:
```
ConsoleHandler consoleHandler = new ConsoleHandler();
consoleHandler.setLevel(Level.FINE); // or another minimum level

LOGGER.addHandler(consoleHandler); // puts the handler into action
LOGGER.setUseParentHandlers(false); // tells java not to use the default handler, which means we won't get duplicate console messages
```
- you can change the format of the console logs like `consoleHandler.setFormatter(XMLFormatter());`

## File handler

- good practice to add logging for all projects
- creates a log file
```
try{
 FileHandler fileHandler = new FileHandler("src/main/resources/example.log", true);
 fileHandler.setFormatter(new SimpleFormatter());
 LOGGER.addHandler(fileHandler);
  } // true means the file won't be overwritten each time, just appended with new events
catch(Exception e){
  e.printStackTrace();
  }
```

# Streams

- a way to process collections of data in a functional manner (alternative to a loop)
- represents a sequence of all the elements in a collection
- more declarative (i.e. functional) than imperative (step-by-step, e.g. `for` loops)
- e.g.:
```
ArrayList<String> beatles = new ArrayList<>(List.of("John", "Paul", "George", "Ringo"));
beatles.stream().forEach(System.out::println);
```
- filtering with streams (i.e. iterating with a condition):
```
beatles.stream()
                .filter(name -> name.startsWith("J"))
                .forEach(name -> System.out.println(name));

```
- applying methods with streams:
```
beatles.stream()
                .filter(App::startsWithJ) // assuming I've created a startsWithJ method and I'm in an App class
                .forEach(name -> System.out.println(name));
```

# Lambda expressions

- shorter way of running some code
- format: `arg -> expression to run on arg`
- e.g. checking a number is even: `num -> num % 2 == 0`
- combining with a stream like `beatles.stream().filter(name -> name.startsWith("J")).forEach(name -> System.out.println(name))`
- this can be further shortened with a method reference like:
```
beatles.stream()
       .filter(name -> name.startsWith("J"))
       .forEach(System.out::println);
```

# Helpful info

## IntelliJ plugins

- UML Generator: creates UMLs (Unified Modelling Language) diagrams of classes and methods, e.g. ![alt text](image-3.png)