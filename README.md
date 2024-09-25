# 📋 Task Tracker CLI APP

This is a simple command-line interface (CLI) application built with Java, designed to help you track and manage your tasks. The project uses the `com.google.code.gson` package to handle JSON file operations for storing and retrieving task data.

## ✨ Features

- **➕ Add new task**
- **❌ Delete task**
- **🔄 Mark task as**: done, in-progress, to-do
- **✏️ Update task**
- **📋 List all tasks**
- **📊 List tasks by status**

## 🛠️ Installation

1. **Clone the repository:**
   
   ```bash
   git clone https://github.com/Software-Backend-Training/TaskTracker.git
   ```

2. **Change directory to the project folder:**
   
   ```bash
   cd TaskTracker/TaskTracker
   ```

3. **Compile the source code:**
   
   ```bash
   mvn compile
   ```

## 🚀 Usage

### ➕ Add a New Task

```bash
./task-cli.sh add <description>
```

### ❌ Delete a Task

```bash
./task-cli.sh delete <task_id>
```

### ✏️ Update Task Description

```bash
./task-cli.sh update <new_description> <task_id>
```

### ✅ Mark Task as Done

```bash
./task-cli.sh mark-done <task_id>
```

### 🔄 Mark Task as In-Progress

```bash
./task-cli.sh mark-in-progress <task_id>
```

### 📋 List All Tasks

```bash
./task-cli.sh list
```

### 📊 List Tasks by Status

```bash
# To-Do
./task-cli.sh list to-do

# In-Progress
./task-cli.sh list in-progress

# Done
./task-cli.sh list done

# Not Done
./task-cli.sh list not-done
```

## 🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

I hope this version is more appealing! Let me know if there’s anything else you’d like to adjust. 😊
