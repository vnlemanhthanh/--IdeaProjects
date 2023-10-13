## The canonical constructor

Each record has a constructor that assigns the input arguments to its components, the so called
_canonical constructor_.

The compiler will create it for you if you didn't define it, but you can also specify it
explicitly:

```java
record Point(int x, int y) {
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
```

Defining the constructor yourself makes sense when you want to validate the input (which you should).
You can also modify the values if that makes sense for your domain model.

### Additional constructors and methods

You can add non-canonical constructors, but these **must** call the canonical one; you cannot
assign to the record components anywhere but in the canonical constructor.

```java
record User(long id, String name, String favoriteAnimal) {
  
  User(long id, String name) {
    this(id, name, null);
    // following line does not compile
    favoriteAnimal = "elephant";
  }
  
}
```

You are also free to add any instance or static methods:

```java
record ISBN(String isbn) {
  
  static boolean isValid(String isbn) {
    // ...
  }
  
  int getChecksumDigit() {
    return // ...
  }
  
}
```

### Exercise

Add a canonical constructor to the `Range` class that checks that `to` is not less than `from`;
throw a `java.lang.IllegalArgumentException` otherwise.