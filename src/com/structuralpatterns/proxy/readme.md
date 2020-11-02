Proxy Pattern
=====

* In proxy design pattern, **a proxy object provides a surrogate or placeholder for another object to control access to it**. 
* Proxy provides extra layer of abstraction on top of the real object.

When to use
=====
* Used to provide additional security layer on top of the real object.
* Proxy is used extensively in lazy loading where we do not want to create a full object until it is really needed.

Real World scenarios
=====
* Lazy loading

[Architecture](https://howtodoinjava.com/wp-content/uploads/2018/12/Proxy-design-pattern.jpg)

Types of proxies
-----------
* **Remote proxy** - represents a remote object. to talk with remote objects(remote objects are the objects that are in another JVM than the current one)
* **Virtual Proxy** - delays the creation and initialization process(creating them on demand)
* **Protection Proxy** - helps to implement security over original object
* **Smart Proxy** - Ensures whether the real object is locked before it is accessed to make sure no other object can change it