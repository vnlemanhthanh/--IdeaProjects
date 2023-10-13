# Switch Expressions

## The Problem with Switch Statements

You've probably written dozens of switch statements in Java.
They allow to check a String, Enum, or number against multiple conditions.
You typically use `switch` when you want to perform several tests on the same constant expression.

There are a number of problems with switch statements as we know them.

### A curious case

Unfortunately, Java took inspiration from C when designing the switch statement.
Therefore, it behaves in a confusing way: rather than being the equivalent of a chain of if-else
branches where only one of the branches is executed, it behaves like a jump table.

A switch matches the value under test against each constant in a `case`.
The program jumps to the single `case` that matches, and executes all code from there, until the
end of the switch block. The only way to get out is to `break` free.
When you don't exit with a break, execution can even pass other case branches.
It doesn't matter that they don't match, as once a case has been selected, no further tests are
performed.

This is called "fall through".
Sometimes, fall through is a desirable property; but in most cases, it is a dangerous trap.

The example code in this lesson demonstrates the dangers of fall through.
The program is intended to print whether a compass direction is used on the longitudinal (east-west)
or latitudinal (north-south) axis.
If you run the program, it will print "longitude" for `NORTH`, which is wrong.

The error stems from the missing `break` after the first section of cases.
When `NORTH` matches, the `coordinate` variable is set to the correct value, but because of fall
through, the next assignment is also executed.

IntelliJ warns you in this example that the first assignment is useless, but if you were to
execute side effects instead of assigning a variable, it couldn't know whether you intended
to do fall through or not.

### An exhausting default

We are using an uninitialized variable so the compiler can verify for us that every case
assigns to the `coordinate` variable.
This is called "definite assignment".
Before we can access the variable in line 24, it has to be definitely assigned, otherwise the
compilation fails.

You can see this in action when you remove the `default` section.

But, wait a minute – we covered all enum values – more formally, the statement is **exhaustive**.
After exiting the switch, the variable *is always* definitely assigned!

Why can't the compiler see this?

### Going Weast

Having to add the unnecessary default now creates another problem.
While we ensured that every case assigns to the variable, we don't have a check that all possible
cases are covered when a *new* enum value is added.
Since the default branch covers all non-matching values, the new value will cause the switch to
jump there, and lead to a runtime exception.

Couldn't the compiler detect this for us?

### A tedious assignment

All cases in our switch statement have the goal of assigning to a variable.
Similarly, you often find yourself in a situation where you want to return from every branch.
It would be great if we could just say `return switch` once instead of every branch.

But, as the name suggests, switch statements are – well – statements.
You can't use them like an expression.