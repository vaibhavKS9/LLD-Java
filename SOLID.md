# SOLID Design Principles

This repository contains a concise guide to the **SOLID** principles of object-oriented design, aimed at improving code simplicity, maintainability, and scalability.

---

## 1. Single Responsibility Principle (SRP)
> **"A class should have only one reason to change."**

Every class or component should have only one functionality. When a class handles multiple concerns, it becomes difficult to maintain and time-consuming to update.

* **The Violation:** An `Invoice` class that calculates prices, prints the invoice, and saves it to a database.
* **The Solution:** Split responsibilities into distinct classes: `Invoice` (data), `InvoicePrinter` (display), and `InvoicePersistence` (storage).
* **Key Benefit:** Smaller, self-explanatory classes that are easier to test and modify.



---

## 2. Open/Closed Principle (OCP)
> **"Software artifacts should be open for extension, but closed for modification."**

Systems should be easy to improve by adding new code (extension) rather than changing the core existing code (modification). This protects the core identity and reusability of your software.

* **The Violation:** Using a `VolumeCalculator` with a function that must be manually updated with a new `if/else` block every time a new shape (like a `Cylinder`) is added.
* **The Solution:** Use an abstract `Shape` class. Each new shape extends `Shape` and implements its own `volume()` logic. The calculator then simply sums the volumes without needing to know the specific shape type.
* **Key Benefit:** Core code remains protected from new feature bugs.



---

## 3. Liskov Substitution Principle (LSP)
> **"Objects of a subclass should be replaceable for objects of the superclass without breaking functionality."**

LSP ensures that inheritance is used correctly. A subclass must behave in the same way as its superclass so that they are interchangeable.

* **The Violation:** A `Bicycle` class extending a `Vehicle` class that requires a `startEngine()` method. Since a bicycle has no engine, the substitution fails.
* **The Solution:** Segregate the hierarchy into `MotorizedVehicle` and `ManualVehicle`. Now, a `Car` can substitute `Motorized`, and a `Bicycle` can substitute `Manual` correctly.
* **Key Benefit:** Avoids incorrect generalizations and system breakdowns.



---

## 4. Interface Segregation Principle (ISP)
> **"An interface should be client-specific rather than general-purpose."**

ISP discourages "fat" interfaces. It is better to have multiple small, specific interfaces than one large interface that forces classes to implement methods they don't use.

* **The Violation:** A 2D `Square` class being forced to implement a `volume()` method because it inherits from a general `Shape` interface.
* **The Solution:** Split the interface into `TwoDimensionalShape` and `ThreeDimensionalShape`.
* **Key Benefit:** Results in cleaner, more intuitive design and efficient refactoring.



---

## 5. Dependency Inversion Principle (DIP)
> **"High-level modules should not depend on low-level modules. Both should depend on abstractions."**

Details should depend on abstractions, not the other way around. This reduces the coupling between different layers of the application.

* **The Violation:** A `Headmaster` class that is explicitly programmed to manage `Teacher` and `Assistant` classes. Adding a `Secretary` would require changing the `Headmaster` class.
* **The Solution:** Create a `Faculty` abstraction. The `Headmaster` interacts with the `Faculty` interface, allowing any new role (like `Secretary`) to be added without modifying the high-level logic.
* **Key Benefit:** Higher flexibility, stability, and module reusability.



---

## Summary
Adhering to SOLID principles ensures that software remains robust and flexible as it grows. By focusing on **abstractions** and **separation of concerns**, developers can create systems that are easier to refactor, test, and extend.
