# java learning & practice from UTuber

javap Tool in Java: Class File Disassembler
  -The javap command disassembles a class file. The javap command displays information about the fields, constructors and methods present in a class file.

[Java Reflection API](https://www.oracle.com/technical-resources/articles/java/javareflection.html)
===================
- Java Reflection is a process of examing/modifying the runtime behaviour of a class at runtime.
- Pckage of Java Reflection API:
  - [java.lang.reflect.*](https://docs.oracle.com/javase/8/docs/api/index.html?java/lang/reflect/package-summary.html)
    - java.lang.reflect.Array;
    - java.lang.reflect.Constructor;
    - java.lang.reflect.Field;
    - java.lang.reflect.Method;
    - java.lang.reflect.Modifier;
    - java.lang.reflect.Proxy;
  - [java.lang.Class](https://docs.oracle.com/javase/8/docs/api/java/lang/Class.html)
- The java.lang.Class
  - This class perfoms 2 tasks
    - provides methods to get the metadata of a class at run time.
    - provides methods to examine & change the run time behaviour of a class.
  - Class is final class in java.lang package which extends Object class. Instance of this class represents classes & interfaces in a running java application. It is used to analyze & chage dynamic behaviour of class at runtime.
  - This class defines several methods using which we can get information about methods,constructors,modifiers and members of a class at runtime.
- The Reflection API is mainly used in:
  - IDE (eg: Eclipse,NetBeans,.....etc)
  - Debugger
  - Test Tools
  - Loading drivers & providing dynamic information
- Using Java Reflection we can inspect java class at runtime. Inspecting classes is often the first thing we do when using Reflection. From the classes we can obtain information about
  - Class Name
  - Class Modifier (like public, private, synchronized, .....etc)
  - Package Info
  - Implemented Interfaces
  - Constructor
  - Methods
  - Fields
  - Annotation
- Dis-Advantage of Reflection
  - Low Performance
  - Security Risk
  - Violation of OOPs Concept

