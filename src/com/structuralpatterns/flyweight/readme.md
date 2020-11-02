# Fly Weight Pattern

- Is a structural pattern which is used to minimize the amount of memory consumed when creating huge number of objects.
- The sole purpose is to reduce memory consumption.
- Achieved by finding the common data among the objects and this common data is created as a object and its reference is used among multiple real objects.
- Uses the cached objects instead of creating new ones.

## More
- There are two types of attributes **intrinsic** and **extrinsic** Intrinsic attributes is the state data that is common among shared objects. It is recommended to make the instrinsic attribute immutable.
- On the other hand extrinsic attributes are the ones whose values change between objects.

## where is this already used?
- Used in `java.lang.String`, In java string constants are flyway objects.
For the below example, there will be only instance of **hello** created in the string constant pool and that object is only referenced for s2.
```
String s = "hello";
String s2 = "hello";
s == s2 // returns true
```
- Also used in [Integer.valuesOf](https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html#valueOf-int-) and also in valueOf method of other Wrapper classes.

