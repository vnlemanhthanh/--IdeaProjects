## When to use var?

Introducing `var` to your codebase can reduce the amount of boilerplate in your code:

`JavaBeanMemeServiceLocatorFactory memeServiceLocatorFactory = new JavaBeanMemeServiceLocatorFactory();`

becomes

`var memeServiceLocatorFactory = new JavaBeanMemeServiceLocatorFactory();`

However, it can also obfuscate the return type of methods:

```java
var product = getCheapestItem(order);
// many lines inbetween...
System.out.println(product.getName()); // Compile error: "Optional" does not have method "getName()"
```

Whoops! The method returns `Optional`, not `Product`.
Specifying the type would have made that clearer.

Particularly when you have different versions of the same object (entities, projections, DTOs...), you may want to be either very specific in naming your variables, or specify the type explicitly.

## Set up rules

When upgrading to Java 10 or later, your team should decide how you use `var` early on and record your decision in your style guide.

Your team may decide against using `var` at all – that's perfectly fine.
Java developers have lived without it for decades.

A good read on when to use `var` is [_Stuart W. Marks:_ Local Variable Type Inference: Style Guidelines](https://openjdk.org/projects/amber/guides/lvti-style-guide) by the OpenJDK team.

## Exercise

As an exercise, try replacing type declarations with `var` in the `Task` class where it makes sense to you.
Apart from that, leave the program untouched (it can be made significantly shorter using `BufferedReader.lines()` and stream collectors, but that is not the focus of this exercise).

The code should still compile and the tests should be green afterwards.