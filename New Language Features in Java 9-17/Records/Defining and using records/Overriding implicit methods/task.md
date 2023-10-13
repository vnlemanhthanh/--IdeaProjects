## Overriding implicit methods

You can override all the implicit methods of a record.
In practice, you should rarely find yourself in a situation that requires you to do so.
For the sake of learning, this lesson will make you anyway.

### Exercise

The `ArrayHolder` record has a problem: it is not immutable.
The array passed in and returned by the accessor can be mutated by the user of this class.

Add necessary overrides and constructor(s) to satisfy these constraints:

* after creating, mutating the array that was passed to `ArrayHolder` should not mutate the state
  of the `ArrayHolder` array.
* mutating the array returned by `ArrayHolder.items()` should not mutate the array inside `ArrayHolder`.
* The "copy invariant" should hold: An `ArrayHolder` should be equal to a copy made by supplying
  the array from the `items()` accessor back into a `new ArrayHolder()` expression.

When you're done, the record will no longer look "boilerplate free", rather like it should have
been a regular class all along.
Remember, it's just an exercise :)

<div class="hint">
  You should make a copy of the incoming array. You can use <a href="psi_element://java.util.Arrays#copyOf">Arrays.copyOf()</a> for that.
</div>

<div class="hint">
  To fulfill the invariant, the arrays should be equals element-wise.
</div>
