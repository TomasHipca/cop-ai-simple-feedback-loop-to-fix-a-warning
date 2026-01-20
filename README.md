# AI Feedback Loop Practice

Practice projects for creating feedback loops with AI to fix compiler/linter warnings.

## Projects

- **[csharp/](csharp/)** - C# TodoApp with intentional warnings
- **[typescript/](typescript/)** - React + TypeScript + Vite with intentional warnings

## Purpose

These projects are exercises for practicing AI feedback loops. The intent is to:

1. Give AI the ability to see compiler/linter warnings
2. Define a workflow where AI fixes the warnings
3. Provide a way to verify that warnings were fixed (tests pass, build succeeds)
4. Integrate the code via pull request

## Going Meta

A useful approach is to guide the AI step by step through fixing a single warning deliberately. Once successful, have the AI write this workflow into a markdown file so it can follow the same process autonomously for future warnings.

1. Pick one warning from the build output
2. Walk the AI through understanding the warning
3. Have it propose a fix
4. Verify the fix (build, test)
5. Ask the AI to document the workflow it just followed
6. Use that workflow for subsequent warnings

**Bonus:** Vibe code scripts that distill the feedback for the AI. Instead of dumping raw build output, create scripts that extract and format exactly what the AI needs to see - warning codes, file locations, relevant context - without bloating the context window.

## Out of Scope

Ideally, you prevent warnings from entering the codebase in the first place. Many warnings can also be auto-fixed by IDEs or tools like `dotnet format`, `eslint --fix`, etc. That's more efficient.

This exercise is not about that. It's about learning to work with AI agents: guiding them, giving them feedback, and letting them run in a loop on your desired workflow.
