package org.example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        TaskManager t = new TaskManager();
        if(args.length < 1){
            System.out.println("must provide operation");
            return;
        }

        String op = args[0];

        switch (op){
            case "add" :
                if(args.length < 2){
                    System.out.println("must provide description");
                    return;
                }
                t.add(args[1]);
                break;
            case "update" :
                if(args.length < 3){
                    System.out.println("must provide id and description");
                    return;
                }
                t.update(Integer.parseInt(args[1]), args[2]);
                break;
            case "delete" :
                if(args.length < 2){
                    System.out.println("must provide id");
                    return;
                }
                t.delete(Integer.parseInt(args[1]));
                break;
            case "list" :
                if(args.length < 2){
                    t.list();
                }else{
                    t.list(args[1]); 
                }
                break;
            case "mark" :
                if(args.length < 3){
                    System.out.println("must provide id and status");
                    return;
                }
                t.mark(Integer.parseInt(args[1]), args[2]);
                break;
            case "help":
                System.out.println("add <description> - add a new task\n" +
                        "update <id> <description> - update the description of a task\n" +
                        "delete <id> - delete a task\n" +
                        "list - list all tasks\n" +
                        "list <status> - list all tasks with the given status\n" +
                        "mark <id> <status> - mark a task as done or undone\n" +
                        "help - display this help message");
                break;
            default:
                System.out.println(op + " is not a valid operation use help to see all operations");
                break;
        }


    }
}

