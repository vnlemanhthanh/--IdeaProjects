## The compact canonical constructor

The canonical constructor can also be declared in a _compact_ form by omitting the list of
parameters.
You assign to the components in this form by just assigning to the implicit (invisible) parameters.
These will be assigned to the fields after the constructor body ran.

For example, this `CrazyPoint` swaps x and y:

```java
record CrazyPoint(int x, int y) {

  CrazyPoint {
    int temp = x;
    x = y;
    y = temp;
  }

}
```

You can think of this as the compiler adding

```java
this.x = x;
this.y = y;
```

automatically at the end of the compact canonical constructor.

> **Caution:** `CrazyPoint` violates the invariant we mentioned in [Using records](course://Records/Defining and using records/Using records):
> 
> ```java
> var point1 = new CrazyPoint(1, 3);
> var point2 = new CrazyPoint(point1.x(), point1.y());
> assert point1.equals(point2); // assertion error, [3, 1] != [1, 3] 
> ```

### Exercise

The record `Absolute` should only contain positive values.
Add a canonical constructor that sets `value` to the absolute value of its input.