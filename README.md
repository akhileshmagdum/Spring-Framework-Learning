# Spring Framework FAQs

### Why is Dependency Injection needed?

---

Before getting into why DI is needed we need to understand the difference between Tight Coupling & Loose Coupling!

```java
class TennisCoach{
	Coach t = new Coach();
		public void excercise(){
			t.workout();
	}
}

class Coach{
	public void workout(){
		System.out.println("Run");
	}
}
```

Here you can see TennisCoach depends upon the Coach class this is called **tight coupling** because if workout() method is changed to warmUp() then we have to change the same with excercise() method to warmUp().

```java
Interface Coach{
	public void workout();
}

class TennisCoach implements Coach{
	@Override
	public void workout(){
		System.out.println("Run")
	}
}
```

Here Coach is loosely interfaced to TennisCoach we can change its method as per our needs this is called as **loose coupling.**

> Tight Coupling means one class is dependent on another class, , there are hard-coded dependency declared in methods.
Loose Coupling means one class is dependent on interface rather than class, we must pass dependency externally at runtime instead of hard-coded dependency.

[Coupling in Java](https://www.geeksforgeeks.org/coupling-in-java/)

Moving on with DI now

---

We need to instantiate an implementation of the Coach interface within the TennisCoach class itself.

```java
public class TennisCoach {
	private Coach t;
	//Constructor
	public TennisCoach() {
		t = new CoachImplementation();
	}
}
```

By using DI, we can rewrite the example without specifying the implementation of the Coach.

```java
public class TennisCoach {
	private Coach t;
	public Store(Coach t) {
		this.t = t;
	}
}
```

We can provide the implementation by using spring .xml configuration or by using Java @Annotations

```java
Coach theCoach = applicationContext.getBean("tennisCoach",Coach.class);
```

### Why use dependency injection when you can create an object using `new` keyword?

---

Well, they're not exactly comparable. You will always have to create a new object by instantiating a class at some point. Dependency injection also requires creating new objects.
Dependency injection really comes into play when you want to control or verify the behavior of instances used by a class that you use or want to test. (For Test Driven Development, dependency injection is key for all but the smallest example).
Assume a class Holder which requires an object of class Handle. The traditional way to do that would be to let the Holder instance create and own it:

```java
class Holder {
    private Handle myHandle = new Handle();
    public void handleIt() {
        handle.handleIt();
    }
}
```

The Holder instance creates myHandle and no one outside the class can get at it. In some cases, unit-testing being one of them, this is a problem because it is not possible to test the Holder class without creating the Handle instance which in turn might depend on many other classes and instances. This makes testing unwieldy and cumbersome.

By injecting the Handle instance, for example in the constructor, someone from the outside becomes responsible for the creation of the instance.

```java
class Holder {
    private Handle myHandle;

    public Holder(Handle injectedHandle) {
        myHandle = injectedHandle;
    }

    public void handleIt() {
        handle.handleIt();
    }
}
```

As you can see the code is almost the same, and the Handle is still private, but the Holder class now has a much loser coupling to its outside world which makes many things simpler. And when testing the Holder class a mock or stub object can be injected instead of a real instance making it possible to verify or control the interaction between the Holder, its caller and the handle.

The actual injection would take place at some other place, usually some "main" program. There are multiple frameworks that can help you do that without programming, but essentially this is the code in the "main" program:

```java
private Handle myHandle = new Handle(); // Create the instance to inject
private Handler theHandler = new Handler(myHandle); // Inject the handle
```

In essence, the injection is nothing more than a fancy `set` method. And of course, you can implement the injection mechanism using that instead of in the constructor like the simple example above.


## Common Errors with Solution
### Error: localhost 8080 already in use

Step 1: Run on command prompt administrator

```java
netstat -ano | findstr 8080
```

Step 2: 1088  must be changed as per the port number

```java
taskkill /F /pid 1088
```
