# Task Tracker CLI APP
This is a simple command-line interface (CLI) application built with Java, designed to help you track and manage your tasks. The project uses the `com.google.code.gson` package to handle JSON file operations for storing and retrieving task data.

## Features
- Add new task
- Delete task
- Mark task as (done , in-progress , to-do)
- update task
- list all tasks
- list tasks with their status 


## Installation
1. Clone the repository 
```bash
git clone https://github.com/Software-Backend-Training/TaskTracker.git
```

2. Change directory to the project folder
```bash
cd TaskTracker/TaskTracker
```

3. Compile the source code:
```bash
mvn compile
```

## Usage
```bash
# add new task
./task-cli.sh add <discrption>

# delete task
./task-cli.sh delete <task_id>

# update task description
./task-cli.sh update <new_description> <task_id>

# mark task as done
./task-cli.sh mark-done <task_id>

# mark task as in-progress
./task-cli.sh mark-in-progress <task_id>

# list all tasks
./task-cli.sh list

# list tasks with their status
./task-cli.sh list to-do
./task-cli.sh list in-progress
./task-cli.sh list done
./task-cli.sh list not-done
```


## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.






