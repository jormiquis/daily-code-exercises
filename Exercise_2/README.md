# 📅 Code Exercise #2: Task Management System

## ✨ Overview
This challenge focuses on building a robust, flexible **Task Management System** that models real-world workflows while applying clean architecture, SOLID principles, and test-driven development (TDD).

---

## 🎓 Learning Goals
- Apply **SOLID principles** in software design
- Practice **TDD**: test-first, refactor later
- Implement core **design patterns** (e.g., Observer, Strategy, Factory)
- Write maintainable and efficient **business logic**
- Optimize for **search/filter performance**

---

## 🏋️ Domain Requirements
A Task includes:
- `ID`: Unique identifier
- `title`: Short name
- `description`: Details of the task
- `dueDate`: Deadline
- `priority`: Low | Medium | High
- `status`: To Do | In Progress | Done
- `assignees`: One or more users
- `primaryAssignee`: One primary user
- `completionDate`: Recorded when task is marked done

### Business Rules:
- Valid status transitions: `To Do → In Progress → Done`
- Completion sets `completionDate`
- High priority + due in 24h → flagged as **Urgent**
- Tasks can have multiple assignees, but only one primary

---

## 📅 Technical Stack & Principles
- **SOLID**: Clean, modular, testable code
- **Design Patterns**:
  - `Strategy` for filtering & searching
  - `Observer` for notifications
  - `Factory` for task creation
- **TDD**: All logic tested before implementation
- **Search Efficiency**: Optimized search over large task lists
- **Interfaces**: Abstract and decouple behaviors

---

## ⚖️ TDD Progression
### Domain Modeling
- [ ] Define `Task`, `Assignee`, `Status`, `Priority`
- [ ] Write tests for validation logic

### Business Logic
- [ ] Task creation with validation
- [ ] Status transitions with exceptions on invalid paths
- [ ] Completion date logic
- [ ] Urgency flagging logic

### Search & Filter
- [ ] Filter by status, priority, due date
- [ ] Use Strategy pattern for different search modes
- [ ] Performance tests on large datasets

### Extras
- [ ] Observer-based notifications (e.g., task updates)
- [ ] Assignment logic with primary user validation
- [ ] Audit trail of task changes

---

## 🔢 Example Initial Test Cases
- [ ] Creating a valid task returns task with ID
- [ ] Missing title or dueDate throws validation error
- [ ] Invalid status transition throws exception
- [ ] Marking task as complete sets `completionDate`
- [ ] Filtering tasks by status returns correct tasks

---

## 🚀 Running the Project
TBD - Instructions coming soon as implementation progresses.

---

## 🙌 About This Series
This is part of a **Daily Code Exercise** series focused on:
- Clean architecture
- Hands-on TDD
- SOLID design
- Practice via small but complete systems