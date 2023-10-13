## The `yield` keyword

Sometimes you want to execute multiple statements inside a case expression.
If appropriate, you should extract these into a separate method.
However, for a small number of lines it is acceptable to keep them in the switch.

The right-hand side of a case can be a block.
Since the block needs to evaluate to a value, Java introduced the `yield` keyword.
It returns a value from the block of a switch case expression.

The `yield` keyword can only be used in the block of switch expressions.
This ensures backwards compatability (in case you named any of your classes "yield").
There is no other use of `yield` – yet.