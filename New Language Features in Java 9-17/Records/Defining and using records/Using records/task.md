## Using Records

You can create records at all places that allow defining a class:

* in top file declarations
* as nested classes inside other classes or records
* as local classes inside methods

When declared as nested or local classes, records are implicitly `static` (they cannot reference
`this` of the enclosing instance).

There are no anonymous records.

### Defining a record

In its simplest form, a record is defined by using the `record` keyword instead of `class`, followed
by the record's name, followed by the list of record components:

```java
public record Book(String author, String title) {}
```

It is perfectly legal for the list of record components to be empty.
Here's a use case for a fictional version of `Optional` that can be inspected with `instanceof`:

```java
sealed interface Maybe<T> {}

record Just<T>(T aValue) implements Maybe<T> {}
record Nothing<T>() implements Maybe<T> {}
```

> The example uses `sealed` classes, which we will learn about in a later lesson.

### Batteries included

A record automatically includes a constructor that initializes the fields (the _canonical constructor_),
sensible implementations for `hashCode()`, `equals()` (component-wise equality) and `toString()`
(printing out all components).

Furthermore, for each record component `<name>`, it declares an accessor method `<name>()`.

Note that the accessor name does _not_ follow JavaBeans naming conventions (no _get_).
This is something you may have to get used to, but trust me, it's better this way – the JavaBeans
specification has some strange capitalization rules when a name consists of multiple capital letters.
The record way of using the name with unaltered capitalization leaves no room for ambiguity.

Annotations on record components are propagated to the fields, and Javadoc on the record allows
using the `@param` tag to document components, which gets passed on to the accessors.

### Overriding default implementations

As we will see in the next lessons, you can override any of these methods, but you should be careful
not to destroy the semantics of a record.
Normalization in constructors is okay, but you should not distort the values returned by accessors.
The default `equals()` implementation is **not** obliged to call your accessors to compare components.

For example, with my version of OpenJDK, I get:

```java
record Answer(int result) {
  public int result() {
    return 42;
  }
}

var a = new Answer(12);
var b = new Answer(19);

a.equals(b); // false
Objects.equals(a.result(), b.result()); // true
```

In particular, you should always adhere to the following invariant outlined in the Javadoc of
[java.lang.Record](psi_element://java.lang.Record):

----
if a record R's components are c1, c2, ... cn, then if a record instance is copied as follows:
R copy = new R(r.c1(), r.c2(), ..., r.cn());

then it must be the case that r.equals(copy).

----

The invariant can't be enforced by the compiler, but not following it will lead to problems with
future language features.

### Looking under the hood

You can see how a record would look like as an ordinary class by invoking the _Convert record to class_
quick action in IntelliJ IDEA.

Look at all that boilerplate! Records are neat, huh?
