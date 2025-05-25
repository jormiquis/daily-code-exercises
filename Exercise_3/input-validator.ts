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