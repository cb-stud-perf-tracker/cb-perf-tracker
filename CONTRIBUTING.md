Below is a practical daily workflow for each team member to manage their tasks and contributions via GitHub. It follows a simple variant of “GitHub Flow,” which is suitable for small-to-medium projects and keeps collaboration straightforward.

---

## 1. Start Your Day: Sync with the Main Repository

1. **Open Your Project’s Repository on GitHub**  
   - Make sure you’re on the organization or team repository that everyone is using (not on your personal fork, unless your team specifically requires forking).

2. **Pull the Latest Changes**  
   - Open a terminal/command prompt in your local project folder.  
   - Ensure you’re on the `main` (or `master`) branch:
     ```bash
     git checkout main
     ```
   - Pull the latest changes:
     ```bash
     git pull origin main
     ```
   This ensures your local environment matches the current state of the repository.

3. **Check the Project Board / Issues**  
   - Go to **GitHub → Projects** or **GitHub → Issues** to see the tasks assigned to you.  
   - If your team uses issues for tasks, locate the issue you want to work on.  

---

## 2. Pick a Task and Create a Branch

1. **Create a Branch for Your Task**  
   - In your local terminal:
     ```bash
     git checkout -b feature/<short-description>
     ```
   - For example:  
     ```bash
     git checkout -b feature/csv-upload-parser  
     ```
   - This isolates your work and makes it easier to collaborate without breaking the main branch.

2. **Link the Branch to an Issue (Optional but Recommended)**  
   - If there’s an open GitHub Issue #123 that matches your task, you can name the branch like `feature/123-csv-upload` or just reference the issue in your pull request/commits later.  

3. **Move the Task to “In Progress”**  
   - On GitHub Projects (or in Issues), drag the card to **In Progress** or add a label / status note if you’re using Issues only.  

---

## 3. Write Code & Commit Regularly

1. **Implement Your Changes**  
   - Make small, logical commits rather than one huge commit at the end of the day. This helps with code reviews and rollback if needed.  
   - For each significant change or fix, do:
     ```bash
     git add <files-you-changed>
     git commit -m "Add CSV parsing logic for file uploads #123"
     ```
     - Using “#123” in the commit message will link this commit to Issue #123 in GitHub, keeping the issue conversation connected to your code changes.

2. **Test Locally**  
   - If you have unit tests, run them locally.  
   - If the code compiles and tests pass, you’re good to push.

3. **Push Your Branch to GitHub**  
   - Push your commits to GitHub:
     ```bash
     git push origin feature/<short-description>
     ```
   - This makes your branch visible to the rest of the team.

---

## 4. Open a Pull Request (PR)

1. **Create a Pull Request**  
   - On GitHub, once you push your branch, you’ll see a prompt: **“Compare & pull request.”** Click it, or manually go to your repo’s “Pull requests” tab and click “New pull request.”  
   - Make sure the base branch is `main` and the compare branch is your `feature/` branch.  
   - Provide a **descriptive title** and summary:
     - What problem does this PR solve or which feature does it add?
     - Reference the relevant issue(s), e.g., “Closes #123” or “Resolves #45.”  

2. **Request Reviews**  
   - Assign one or more team members to review your changes.  
   - Keep the PR short if possible. That makes reviews much faster.  

3. **Update the Task to “Review”**  
   - In GitHub Projects or Issues, move the task to “Review” or indicate that it’s awaiting review.  

---

## 5. Peer Review & Merge

1. **Review (Another Team Member)**  
   - A teammate reviews your code, checks for correctness, potential bugs, or improvements. They can leave comments or request changes.  
   - If changes are requested:
     1. Make your edits locally on the same branch.
     2. Commit & push again.
   - The pull request will update automatically.

2. **Approve & Merge**  
   - Once it’s approved (or if the team decided you can self-approve small PRs), click “Merge Pull Request.”  
   - Typically, choose “Squash and merge” or “Rebase and merge” to keep a clean commit history.  

3. **Delete the Feature Branch**  
   - After merging, GitHub can automatically delete the branch. Or do it manually.  
   - Locally, you can switch back to `main` and do:
     ```bash
     git checkout main
     git pull origin main
     git branch -d feature/<short-description>
     ```
     This ensures your local `main` has the merged code, and you no longer keep stale branches.

4. **Update the Task to “Done”**  
   - Move the GitHub Issue or Project card to **Done** (or mark the Issue as closed).

---

## 6. End of Day Wrap-Up

1. **Verify Merged PRs**  
   - Check if any open pull requests need your review or if you have unaddressed comments.  
   - Merge or rebase as needed so that `main` remains up to date.

2. **Check the Board**  
   - Ensure that tasks you finished have been moved to **Done** and that your next tasks are still in **To Do** or backlog.  

3. **Document / Comment**  
   - If you discovered anything that should be documented (e.g., set up instructions, changes to environment variables), add that to the **README** or a Wiki.  
   - Leave brief notes on the Issues if needed: “Completed CSV parser; next step is integration with the UI.”

---

## Putting It All Together: Daily Flow Summary

1. **Morning**: 
   - Pull latest `main`.  
   - Check tasks (GitHub Issues or Project board).  
   - Start a feature branch from `main`.  

2. **During the Day**:
   - Commit small, meaningful changes that address one part of the issue at a time.  
   - Push to your feature branch on GitHub.  
   - Keep an eye on Slack/Discord (or whichever communication tool) for any discussions.

3. **End of Day**:
   - If the feature is complete, open (or update) your Pull Request.  
   - Request reviews.  
   - If merged, switch to `main` and pull changes.  
   - Update the Project board (move your card to Review or Done).  
   - Provide any comments on the Issue.  

---

## Key Tips for Smooth Collaboration

- **Always Branch from `main`**: Keeps your environment fresh and avoids merge conflicts.  
- **Commit Often**: Granular commits make it easier to track changes or revert if needed.  
- **Use Descriptive Commit Messages**: Summarize the “why” and “what” of your change.  
- **Reference Issue Numbers**: Use `#<issue_number>` in commit messages and PR descriptions to link code to tasks.  
- **Small Pull Requests**: Easier for reviewers, leads to quicker merges.  
- **Perform Code Reviews Politely and Promptly**: Offer constructive feedback, and keep the team’s coding standards in mind.  
- **Keep `main` Deployable**: In real-world projects, `main` is often the production-ready code. Don’t merge unfinished or broken features.

---

### Example of a Day in the Life

- **Alice** checks GitHub Projects, sees she’s assigned Issue #42: “Implement archiving scheduler.”  
- She pulls the latest `main`, creates branch `feature/42-archiving-scheduler`.  
- She codes the scheduler logic, commits with messages referencing #42.  
- She pushes to GitHub, opens a pull request, writes: “Implements the basic scheduling logic to archive old records (closes #42).”  
- Bob reviews the code, requests a small change to the cron expression.  
- Alice fixes it, pushes again. Bob re-checks and approves.  
- Alice merges the PR, deletes the branch, closes Issue #42, moves the card to “Done.”  

With this process, every team member’s daily tasks are clearly traced, versioned, and documented in GitHub. You’ll be able to track progress easily, revert problematic changes if needed, and keep `main` stable.

---

## Git Process Steps (Example Workflow)

### **Common Steps for Both Teams**

1. **Clone the Repository** (if not already done):
   ```bash
   git clone https://github.com/YourOrg/student-performance-tracker.git
   cd student-performance-tracker
   ```
2. **Navigate to the Project Folder**:
   ```bash
   cd phase1-servlets-jdbc
   ```

3. **Always Pull Latest Changes Before Starting Work**:
   ```bash
   git checkout main
   git pull origin main
   ```

---

### **Team A – Backend Workflow**

1. **Create a Feature Branch**:
   ```bash
   git checkout -b feature/teamA-hello-servlet
   ```
2. **Make Changes**:  
   Add or update the `HelloWorldServlet.java` with the minimal code provided above.

3. **Stage and Commit Changes**:
   ```bash
   git add src/com/example/HelloWorldServlet.java
   git commit -m "Team A: Add minimal HelloWorldServlet"
   ```

4. **Push the Feature Branch to GitHub**:
   ```bash
   git push -u origin feature/teamA-hello-servlet
   ```

5. **Create a Pull Request** (using GitHub CLI for example):
   ```bash
   gh pr create --title "Add HelloWorldServlet" \
     --body "Team A adds a minimal HelloWorldServlet to output 'Hello, world!'" \
     --base main --head feature/teamA-hello-servlet
   ```
6. **Code Review & Merge**:  
   Wait for a review (by you or a designated reviewer), resolve any conflicts if necessary, then merge the PR into `main`.

---

### **Team B – Frontend Workflow**

1. **Create a Feature Branch**:
   ```bash
   git checkout -b feature/teamB-index-page
   ```
2. **Make Changes**:  
   Add or update the `index.jsp` file with the minimal code provided above.

3. **Stage and Commit Changes**:
   ```bash
   git add WebContent/index.jsp
   git commit -m "Team B: Add index.jsp landing page"
   ```

4. **Push the Feature Branch to GitHub**:
   ```bash
   git push -u origin feature/teamB-index-page
   ```

5. **Create a Pull Request**:
   ```bash
   gh pr create --title "Add index.jsp landing page" \
     --body "Team B adds a basic landing page for the frontend" \
     --base main --head feature/teamB-index-page
   ```
6. **Code Review & Merge**:  
   After review and any necessary changes, merge the PR into `main`.

---

## Coordination to Avoid Conflicts

- **Frequent Integration:**  
  Both teams should regularly pull changes from `main` into their feature branches:
  ```bash
  git checkout feature/<branch-name>
  git pull origin main
  ```
- **Pull Request Reviews:**  
  All changes merge via pull requests, ensuring that conflicts are detected early and resolved during code review.
- **Communication:**  
  Use daily stand-ups or a shared project board to coordinate which parts of the code each team is modifying.

---
