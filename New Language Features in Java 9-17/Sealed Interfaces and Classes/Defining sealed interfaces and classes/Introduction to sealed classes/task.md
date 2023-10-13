# Sealed Interfaces and Classes

[JEP 409](https://openjdk.org/jeps/409), finalized in Java 17, added sealed types to the Java language.
They are also known as _sum types_ or _tagged unions_ in other programming languages.

Sometimes you want to express that a type is either A or B or C, and use that knowledge at runtime
to narrow down an instance to one of these types.
Sealed types help you achieve that.

A sealed interface restricts which classes can implement or which interfaces can extend it, and a
sealed class restricts which classes can extend it directly.
In other words, it "knows" its direct descendants at compile time.

Up until now, you could either forbid extending a class entirely (with the `final` keyword), or
anyone, or at least anyone with access to the base class, could extend it.

In the past, techniques existed to restrict extending a base class.
JEP 409 contains an example where the base class was made package-private to make it impossible to
be inherited from types in other packages.
While this achieves restriction, it doesn't allow external code to reference the base class, not even as
the type of a local variable.

_Sealed classes and interfaces_ close this gap.
When you got an instance of a sealed type A with subclasses B and C, you know that the instance is
either A, B, or C.
The `instanceof` check for one of these types **will** succeed.

## Defining a sealed class or interface

You make an interface or class sealed by adding the `sealed` keyword to its list of modifiers.
A sealed class is not required to be abstract.

```java
sealed class Planet {...}

sealed interface Result {...}
```

A sealed type needs to know its direct descendants at compile time.
We will see how they can be declared explicitly in a later lesson, but let's look at the simpler
implicit case first: when the descendants are in the same source file, you do not need to list them
explicitly.
This is shown in the example class `Vertebrate`<sup>1</sup>.
The descendants are declared as inner classes of the parent.

Try creating a class outside of this file and extend from `Vertebrate`: the compiler won't let you.

Note that we did not add any behavior or fields to the classes to keep the example simple.
Except for inheritance, sealed types work exactly like their non-sealed counterparts
and can declare methods etc.

## Sealed classes and enums

Sealed classes are similar to enums: Both know their concrete subtypes.
The big difference is that enums are singletons, while you can have multiple instances of sealed
types (or their descendants), each having independent values for their fields.

----

<sup>1</sup> [Vertebrates](https://en.wikipedia.org/wiki/Vertebrate) are part of the animal taxonomy.
The subclasses depicted here are not correct classifications; don't get your biology lessons from a
Java course.