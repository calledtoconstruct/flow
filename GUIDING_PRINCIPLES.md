# Guiding principles: calledtoconstruct/flow

## Purpose and scope
Flow: a small Java library of classes (Either, Left/Right, Tuple1 to Tuple8 and related types) for streamlining process flow, published to Maven Central and GitHub Packages.

## Stack and layout
Java 17, Maven. Two modules in separate folders: `flow/` (the library, `net.calledtoconstruct:flow`, JUnit 5 tests under `flow/src/test/java`) and `example/` (a Spring Boot 3 app that uses the library). Dev container with Java 17 and Maven.

## Commands
| Check | Command | Evidence |
|---|---|---|
| Build | `mvn package` from `flow/` (Maven project; the publish workflow runs Maven from `./flow`) | flow/pom.xml, .github/workflows/maven-publish.yml |
| Type-check | Covered by the Maven compile | - |
| Lint / architecture guard | None configured | - |
| Changed-feature tests | `mvn test -Dtest=<TestClass>` from `flow/` (Surefire 3 is configured) | flow/pom.xml |
| Full suite | `mvn test` from `flow/`; not run by any PR workflow | flow/pom.xml |
| CI | CodeQL on push/PR to main (security scan only, no tests); Maven Package publishes on release | ./.github/workflows/ |

Commands marked as not written down come from the build files, not from project docs; confirm them before relying on them.

## Before every push
Before every push: run the build and type-check/lint that exist here, plus only the tests for the files or feature you changed (team rule, ideas #14 note 6797). Do not run the full suite locally as a routine gate; the full suite belongs in CI. Merge needs a positive review and green CI. Explain any new failure your change caused. Never weaken a valid test to make it pass, and never invent a command this file does not list.

## Project rules
- Tests follow the given/when naming seen in `flow/src/test/java/net/calledtoconstruct/given*/WhenInvoking*Test.java`: one behavior per test class.
- Keep the library dependency-free at runtime (only JUnit, test scope).
- Public API changes need a version bump in `flow/pom.xml` and a matching update to `example/` and README examples.

## What to avoid
- Committing to the default branch; work on a branch and open a pull request.
- Deleting files, branches or history, or changing repository settings.
- Adding tooling, CI or dependencies that the change does not need.
- Rules copied from other projects (file-size limits, clocks, quotas) that this repository never adopted.

## Delivery and safety
- Publishing happens only when a GitHub release is created; it signs with GPG and deploys to OSSRH and GitHub Packages. Never create a release or tag as part of a routine change.

## Open questions
- No PR workflow runs the unit tests; the full suite runs nowhere automatically. Report this gap rather than assume CI covers it.

## Sources
Read from the `main` branch on 2026-11-08 ET: `README.md`, `flow/pom.xml`, `example/pom.xml`, `.github/workflows/codeql.yml`, `.github/workflows/maven-publish.yml`, `.devcontainer/devcontainer.json`.

## Instruction updates
Check `guiding-principles.version` at the start of each turn and when you enter this project; reload this file when the version changes. Change this file, its version and date, and `PRINCIPLES_HISTORY.md` in the same commit. Team-wide role instructions are versioned separately in the team-process repository.
