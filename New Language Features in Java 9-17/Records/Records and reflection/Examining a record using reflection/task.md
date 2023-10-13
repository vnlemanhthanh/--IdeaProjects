## Examining a record using reflection

_You can skip this lesson if you've never written reflective code yourself._

To support the transparent nature of records, the `Class` class has been extended with two new
methods: [`boolean isRecord()`](psi_element://java.lang.Class#isRecord) tells you whether a class is a record, and [RecordComponent[] getRecordComponents()](psi_element://java.lang.Class#getRecordComponents)
returns the components of a record.
A [RecordComponent](psi_element://java.lang.reflect.RecordComponent) allows you to inspect its name and get a reflective reference to the accessor
[Method](psi_element://java.lang.reflect.Method).

Therefore, it is much more straightforward to reflectively read records than objects in JavaBeans
style.
Obtaining the accessor for record fields is baked right into the language, whereas JavaBeans can
only be inspected through convention.

## Exercise

Implement the `getRecordValues(Object)` method:

* if the input parameter isn't a record, return an empty Optional.
* otherwise, return an Optional containing a Map mapping from component name to component value.
* the input will never be null.

Example:

```java
record User(String firstName, String lastName){}

var input = new User("Jane", "Doe");
var result = task.getRecordValues(input); // should be equal to Map.of("firstName", "Jane", "lastName", "Doe");
```