## Sealed classes and the module system

We won't cover the Java module system (JPMS) in this course, but for the sake of completeness, know
that if you use it, you are not restricted to place permitted subtypes in the same package anymore.
They only need to be in the same module as the sealed type.

We added a `module-info.java` to make the example a module and organized the code into packages. 