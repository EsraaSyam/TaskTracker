#!/bin/bash

command=$1

if [ "$command" == "add" ]; then
    shift  
    description="$*"  
    mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="add \"$description\""
else
    # Handle other commands (you can add more conditions here)
    mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="$*"
fi
