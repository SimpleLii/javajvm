# Java JVM

using java to implement a simple jvm 8

# Start from an example of running a java program

## What happened when we type java in terminal?

Mostly, you run own java program like follow

```shell
java -jar java-program-package.jar
```

Before use command above, one needs to set up System Environment of **Java Runtime Environment**, like `JAVA_HOME`，`PATH`, otherwise the terminal would show like follow

```shell
-bash: java: command not found
```

After setting up System Environment well, we have a Java Runtime Environment to run your java program.

Actually, the command input **java** is a program, mostly compiled by C/C++, i.e it is a runnable program write in C/C++ programming language Like [openjdk](http://openjdk.java.net/).

## How java knows where is our main function?

### A simple class

When we write a *hello, world* program like follow

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
}
```

And save it as file **Main.java**, then type some command  in terminal

```shell
javac Main.java
java Main
```

We will get some output like that

```shell
Hello, world!
```

Because java **promise** that it will run our program start with a `main` function. It is a tradition.

But just waiting, how java know where is `main` function? 

The answer is obvious, `java Main`, we tell it that our class name `Main`, so java virtual machine will start from `Main` class, load `Main` class, then find a `main` function in `Main` class.

### But when it is a package?

Well, 

# Reference

[java specification](https://docs.oracle.com/javase/specs/)

[自己动手写Java虚拟机](https://book.douban.com/subject/26802084/)


