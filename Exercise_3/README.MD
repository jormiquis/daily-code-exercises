# 🏋️‍♀️ Code Exercise #4: Refining Input Validation with Object Calisthenics & Clean Code

## ✨ Overview
This exercise challenges you to take a simple TypeScript `InputValidator` class and refactor it by strictly adhering to the principles of **Object Calisthenics** and **Clean Code**. The goal is to demonstrate your ability to write well-structured, highly readable, and maintainable code under specific design constraints, showcasing your commitment to software craftsmanship.

---

## 🎯 Learning Goals
- Rigorously apply the **9 principles of Object Calisthenics**.
- Internalize and apply key principles of **Clean Code**.
- Practice refactoring existing code to meet stringent design and readability standards.
- Write effective unit tests to ensure the correctness of the refactored code.
- Showcase your ability to produce high-quality code suitable for professional portfolios.

---

## ⚙️ The Challenge
You are provided with a basic `InputValidator` class in TypeScript. Your task is to refactor this class to:

1.  **Strictly adhere to all 9 principles of Object Calisthenics:**
    * One level of indentation per method.
    * No `else` keyword.
    * Wrap all primitives and Strings in objects.
    * One member variable per class.
    * The first class in any collection must contain the collection.
    * No getters/setters/properties.
    * One dot per line.
    * No abbreviations.
    * Keep entities small (less than 50 lines).

2.  **Apply the principles of Clean Code:**
    * Use meaningful and pronounceable names.
    * Create small functions that do one thing.
    * Express intent through code.
    * Avoid side effects.
    * Handle errors gracefully.
    * Maintain code readability and consistency.

3.  **Preserve the original functionality** of the `validate` and `getMessage` methods.

4.  **Write comprehensive unit tests** using Jest to verify the behavior of the refactored code for various input scenarios (valid, too short, missing '@', null, undefined).

---

## 🤯 Estimated Difficulty
**Advanced**. While the initial code is simple, strictly applying all the rules of Object Calisthenics and Clean Code simultaneously, especially the "wrap all primitives" and "one member variable per class" rules, will require significant thought and creative design. You'll need to decompose the logic into numerous small objects with very specific responsibilities. This exercise goes beyond basic refactoring and tests your ability to design under tight constraints, pushing you to think deeply about object-oriented principles.

---

## 💡 Interesting Considerations
- **The "Wrap All Primitives" Constraint:** This rule will likely lead to the creation of small value objects for the input string and potentially for the validation outcomes (e.g., a `ValidationResult` object).
- **Eliminating `else`:** You'll need to use techniques like guard clauses or extracting conditional logic into separate methods or objects.
- **One Member Variable:** This rule will force you to pass state around through method parameters and potentially rely heavily on the interaction between different small objects.
- **Testing the Refactored Code:** Your tests will be crucial in ensuring that the extensive refactoring hasn't introduced any regressions in the original functionality.

---