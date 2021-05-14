
A has two dependencies: B and C.

B has a dependency: C.

A and B both depend on C but with different version.

A dependends on C.v2

B dependends on C.v1


dependency graph:

    A
    |
    |___ C.v2
    |
    |___ B
         |
         |__ C.v1
         

Calling a B's method that uses C.v1 from within B itself works.

Calling a B's method that uses C.v1 from within A is failing because C.v2 takes over in A.  Therefore, B's method can't use C.v1.