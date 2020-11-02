# Composite Pattern
- Composite design pattern is a structural pattern which modifies the structure of an object. This pattern is most suitable in cases where you need to work with objects which form a tree like hierarchy. In that tree, each node/object (except root node) is either composite or leaf node. 
- Implementing the composite pattern lets clients treat individual objects and compositions uniformly.

# Participants
- **Component**
    - contains the objects common in the composition
    - implements the default behaviour for the operations
    - optionally you can also have an interface which can access the parents in the recursive tree
- **Leaf**
    - represents leaf objects and has no children
- **Composite**
    - contains the list of children components
    - delegates the work to its children
- **Client**
    - performs composition through component interface
