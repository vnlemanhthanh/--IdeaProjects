## Where you can and can't use var

As the name "local variable type inference" suggests, you can use the `var` keyword in local variable declarations **only**.

This includes the parameters of lambda expressions, but not parameters of methods, their return types, generic type arguments, catch clauses, or fields.

Also, in order for Java to be able to infer the type, it must be part of the variable declaration.
Uninitialized variables cannot be inferred, as well as `null`.

Other forbidden uses are multiple declarations (` var a = 4, b = 3`), array initializers (`var a = {4}`), or self-reference.

`var` is only a keyword when used at the position of a type.
You can continue to use it as the name of variables, if you desire.
If that wouldn't have been the case, hundreds of Java programs would no longer compile when upgrading to Java 9.

Type inference gets interesting when you use ternary expressions (`(condition) ? a : b`).
The rules for this are outlined in the [Java Language Specification §15.25](https://docs.oracle.com/javase/specs/jls/se17/html/jls-15.html#jls-15.25), but in layman's terms they can be summarized as _"find the common supertype(s)"_.

---

_If you want, you can try to make the code compile as an exercise._