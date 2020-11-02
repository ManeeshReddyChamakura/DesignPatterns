# Facade Pattern

## What is it
- It provides a simple interface for the client to interact with a complex subsystem.
- It doesn't reduce the complexity but just hides it.
- Client is decoupled from the complex subsystem.
- we can still access the subsystem directly if we want.

## When
- Use facade when you want to provide a simple interface for a complex subsystem

## More
- Facade acts as a layer between the client and subsystem. If the subsystem changes then the changes should also be done on the facade but the client remains same.