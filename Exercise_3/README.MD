# 🏋️‍♀️ Code Exercise #3: Domain-Driven Input Validation with Object Calisthenics & Clean Code

## ✨ Overview
This exercise builds upon the previous challenge by requiring you to refactor a simple TypeScript `InputValidator` class while strictly adhering to the principles of **Object Calisthenics** and **Clean Code**, and now explicitly incorporating concepts from **Domain-Driven Design (DDD)**. The goal is to demonstrate your ability to model domain concepts effectively, write well-structured and maintainable code under design constraints, and showcase your understanding of advanced software design principles.

---

## 🎯 Learning Goals
- Rigorously apply the **9 principles of Object Calisthenics**.
- Internalize and apply key principles of **Clean Code**.
- Incorporate fundamental concepts of **Domain-Driven Design (DDD)**, such as Value Objects and focusing on domain logic.
- Practice refactoring existing code to align with DDD, Object Calisthenics, and Clean Code.
- Write effective unit tests that reflect the domain behavior.

---

## ⚙️ The Challenge
You are provided with a basic `InputValidator` class in TypeScript. Your task is to refactor this class to:

1.  **Strictly adhere to all 9 principles of Object Calisthenics** (as outlined in the previous README).

2.  **Apply the principles of Clean Code** (as outlined in the previous README).

3.  **Incorporate Domain-Driven Design (DDD) principles:**
    * **Model domain concepts as Value Objects:** Instead of using primitive strings directly, create meaningful Value Objects that encapsulate the input and its properties (e.g., an `EmailAddress` object).
    * **Focus on domain logic:** Ensure that the validation rules are expressed in a way that reflects the domain (in this case, the rules for a valid input).
    * **Potentially identify a Bounded Context:** Although small, consider the "input validation" as a distinct part of your application with its own specific language and rules.

4.  **Preserve the original functionality** of the `validate` and `getMessage` methods, now expressed through your domain model.

5.  **Write comprehensive unit tests** using Jest to verify the behavior of the refactored code, focusing on testing the domain logic encapsulated within your Value Objects and validator.

---

## 🤯 Estimated Difficulty
**Expert**. This exercise significantly increases in difficulty due to the explicit requirement of applying DDD principles alongside Object Calisthenics and Clean Code. You will need to think carefully about how to model the concept of an "input" as a domain entity or set of Value Objects. The constraints of Object Calisthenics will further challenge how you structure your domain model and validation logic. This goes beyond simple refactoring and requires a solid understanding of advanced software design patterns and domain modeling.

---

## 💡 Interesting Considerations
- **Modeling the "Input":** Consider what aspects of the "input" are important from a domain perspective. Should it be a simple `Input` Value Object, or perhaps a more specific `ValidatedInput` that holds both the raw value and its validation status?
- **Expressing Validation Rules in the Domain:** How can you express the validation rules (not null, longer than 5 characters, contains '@') as behaviors or properties of your domain objects?
- **The Role of a Validator (Service vs. Domain Logic):** Should the validation logic reside within the `Input` Value Object(s) themselves, or should you have a separate validation service that operates on these objects? Consider the SRP from SOLID in this context as well.
- **Error Reporting as Domain Feedback:** How can your `getMessage` functionality provide meaningful feedback in the language of the domain? Could a `ValidationResult` Value Object hold both the validity status and a specific error message?

---

## 🚀 Next Steps
1.  Fork this repository (or create a new one for this exercise).
2.  Design your domain model for the "input" concept, focusing on Value Objects.
3.  Implement the refactoring of the `InputValidator` class in TypeScript, adhering to Object Calisthenics, Clean Code, and DDD principles.
4.  Write comprehensive unit tests using Jest that focus on testing the domain logic and the behavior of your Value Objects.
5.  Commit your solution and push it to your GitHub repository.

```javaScript
class InputValidator {
  validate(input: string): boolean {
    if (input !== null && input !== undefined && input.length > 5) {
      if (input.includes("@")) {
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }

  getMessage(input: string): string {
    if (input === null || input === undefined) {
      return "Input cannot be null or undefined.";
    } else if (input.length <= 5) {
      return "Input must be longer than 5 characters.";
    } else if (!input.includes("@")) {
      return "Input must contain an '@' symbol.";
    } else {
      return "Input is valid.";
    }
  }
}

// Example
const validator = new InputValidator();
console.log(`Validating 'test': ${validator.validate('test')}`);
console.log(`Message for 'test': ${validator.getMessage('test')}`);
console.log(`Validating 'test@example': ${validator.validate('test@example')}`);
console.log(`Message for 'test@example': ${validator.getMessage('test@example')}`);
console.log(`Validating null: ${validator.validate(null as any)}`);
console.log(`Message for null: ${validator.getMessage(null as any)}`);
```
