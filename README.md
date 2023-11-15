# Commit Message Convention

## Format
<type>(<scope>): <message>

### Example
feat(controller): add product creation endpoint

## Types
- feat: Introduce a new feature for the user.
- fix: Resolve a bug for the user.
- chore: Perform routine tasks, maintenance, or refactors.
- docs: Make changes to documentation.
- style: Implement code style changes (e.g., formatting).
- test: Add or modify tests.
- refactor: Conduct code refactoring.
- perf: Improve performance.
- ci: Make changes to the CI/CD pipeline.

## Scope
- The area or module of the project that the commit affects (e.g., inventory, reports).

## Message
- A concise and clear description of the change.

## Additional Sections

### MVC Components
- controller: Make changes related to Spring MVC controllers.
- service: Implement changes related to Spring services.
- repository: Introduce changes related to Spring Data JPA repositories.

### SQL
- sql: Introduce changes related to SQL queries or database schema.

## Examples
- Adding a new endpoint in the controller:
  feat(controller): add product creation endpoint

- Fixing a service logic issue:
  fix(service): resolve product validation issue

- Refactoring a repository method:
  refactor(repository): optimize product retrieval query

- Adding or modifying SQL queries:
  sql: update database schema for the product table

- Documentation changes for a controller:
  docs(controller): update API documentation for product endpoints

- Code style changes in a service:
  style(service): format code using Checkstyle

- Adding unit tests for a repository:
  test(repository): add unit tests for the product repository

- Performance improvement in a controller:
  perf(controller): optimize response time for product endpoints

- CI/CD changes:
  ci: update build configuration for deployment

- Routine tasks or maintenance:
  chore: clean up unused dependencies
