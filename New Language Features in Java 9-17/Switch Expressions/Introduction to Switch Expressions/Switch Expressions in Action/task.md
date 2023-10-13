## Introduction to switch expressions

Switch expressions (sometimes also called "enhanced switch") were added in their final form with
[JEP 361](https://openjdk.org/jeps/361) to Java 14.

They are an improvement over switch statements in multiple ways:

* No fall through semantics – each case acts as a true branch.
* Can be used as an expression (i.e., everywhere you could also write "1 + 1").
* Enforces exhaustiveness for enums (and in the future, for records and sealed types).
* Allows to omit the default branch if the switch is exhaustive.
* Can define blocks.

We have updated the example to use switch expressions (and also fixed the fall through bug).
