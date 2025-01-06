# NullPointerException Example in Java

This project demonstrates how to generate and handle a `NullPointerException` in Java.

## Overview

The project consists of two classes:

1. **NullPointerExceptionExample**: This class contains a method `generateNullPointerException` which intentionally causes a `NullPointerException` by attempting to access a method on a `null` object.

2. **Main**: This class contains the `main()` method where the `generateNullPointerException` method is called inside a `try` block. If a `NullPointerException` occurs, it is caught in the `catch` block, where a message is printed, followed by the call to `printStackTrace()` and `toString()` to display the exception details.

## How it Works

- In `NullPointerExceptionExample.java`, the method `generateNullPointerException()` creates a `null` reference and tries to call the `length()` method on it, which triggers the exception.
- In `Main.java`, the exception is caught in the `try/catch` block. The `catch` block prints a message informing the user of the exception and then uses `printStackTrace()` to display the stack trace, followed by the exception's `toString()` method to provide a brief description of the error.

## Expected Output

When you run the program, you should see the following output:

