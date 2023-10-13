## Exhaustive Switch on Enums

When you switch over an enum value in expression form, the compiler will make sure that you cover
all cases, or you've added a default case.
A switch that covers all cases is called _exhaustive_.

The compiler will raise an error when you extend the enum with a new value.
This helpful property ensures you adjust all places of your codebase to take the new value into
account.
Of course, when you're using a default case, the compiler won't be able to help you.

Since Java is a separately compiled language, it could happen that the enum you switch over has
more values at runtime than at compile time.
Because of this, the compiler silently adds a default case to exhaustive switches which will throw
a runtime exception if the enum value is not covered.

Exhaustiveness is **not** enforced when using the enhanced switch syntax for statements.
The following compiles:

```java
switch (direction) {
  case NORTH -> System.out.println("It's north");
}
```

However, future versions of Java may emit a warning, and pattern matching for switch (to be introduced by
[JEP 441](https://openjdk.org/jeps/441)) requires even switch statements to be exhaustive.
Thus, it is best to always add an empty default case to switch statements if you really didn't
want to cover all cases.

### Exercise

Let's see the compiler error in action.
Add the value "PLATINUM" to the `Achievement` enum and return the appropriate sentence in the `Task`
class by adding a case for it.
