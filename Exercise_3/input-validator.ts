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

// Ejemplo de uso
const validator = new InputValidator();
console.log(`Validating 'test': ${validator.validate('test')}`);
console.log(`Message for 'test': ${validator.getMessage('test')}`);
console.log(`Validating 'test@example': ${validator.validate('test@example')}`);
console.log(`Message for 'test@example': ${validator.getMessage('test@example')}`);
console.log(`Validating null: ${validator.validate(null as any)}`);
console.log(`Message for null: ${validator.getMessage(null as any)}`);