package org.example;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;


public class TaskManager {
    private static final String FILE_PATH = "tasks.json";
    private static final String CNT_FILE_PATH = "task_count.txt"; // File to store the current count
    private List < Task > tasks;
    private int cnt = 0;

    public TaskManager() {
        this.cnt = loadCountFromFile();
        tasks = readTasksFromJsonFile();
    }

    private static void writeTasksToJsonFile(List<Task> tasks) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(tasks, writer);
            // System.out.println("Tasks have been written to " + FILE_PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Task> readTasksFromJsonFile() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type taskListType = new TypeToken<ArrayList<Task>>(){}.getType();
            return gson.fromJson(reader, taskListType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private int loadCountFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CNT_FILE_PATH))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            return 0; // Default to 0 if the file doesn't exist or can't be read
        }
    }

    private void saveCountToFile(int count) {
        try (FileWriter writer = new FileWriter(CNT_FILE_PATH)) {
            writer.write(String.valueOf(count));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(String description) {
        cnt++;
        Task newTask = new Task(description, cnt);
        tasks.add(newTask);
        System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
        writeTasksToJsonFile(tasks);
        saveCountToFile(cnt);
    }

    public void update(int id, String description) {
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task == null) {
            System.out.println("Task with ID " + id + " not found");
            return;
        }
        task.setDescription(description);
        System.out.println("Task updated successfully");
        writeTasksToJsonFile(tasks);
    }

    public void delete(int id){
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task == null) {
            System.out.println("Task with ID " + id + " not found");
            return;
        }
        tasks.remove(task);
        System.out.println("Task deleted successfully");
        writeTasksToJsonFile(tasks);
    }

    public void list(){
            if(tasks.isEmpty()){
                System.out.println("No tasks available.");
            }else{
                int taskNumber = 1;
                for(Task t : tasks){
                    System.out.println("Task " + taskNumber + ":");
                    System.out.println("    ID: " + t.getId());
                    System.out.println("    Description: " + t.getDescription());
                    System.out.println("    Status: " + t.getStatus());
                    System.out.println();
                    taskNumber++;
                }
                System.out.println("Total tasks: " + tasks.size());
            }
    }

    public void list(String status){
        List < Task > filteredTasks = new ArrayList<>();
        if(status.equals("not-done")){
            for(Task t : tasks){
                if(t.getStatus().equals("todo") || t.getStatus().equals("in-progress")){
                    filteredTasks.add(t);
                }
            }
        }else{
            for(Task t : tasks){
                if(t.getStatus().equals(status)){
                    filteredTasks.add(t);
                }
            }
        }
        if(filteredTasks.isEmpty()){
            System.out.println("No tasks with status " + status);
        }else{
            int taskNumber = 1;
            for(Task t : filteredTasks){
                System.out.println("Task " + taskNumber + ":");
                System.out.println("    ID: " + t.getId());
                System.out.println("    Description: " + t.getDescription());
                System.out.println("    Status: " + t.getStatus());
                System.out.println();
                taskNumber++;
            }
            System.out.println("Total tasks: " + filteredTasks.size());
        }
    }

    public void mark(int id, String status){
        Task task = tasks.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
        if (task == null) {
            System.out.println("Task with ID " + id + " not found");
            return;
        }
        task.setStatus(status);
        System.out.println("Task marked as " + status);
        writeTasksToJsonFile(tasks);
    }


}

