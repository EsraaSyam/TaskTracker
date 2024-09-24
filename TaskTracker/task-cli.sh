#!/bin/bash

COMMAND=$1
ARGUMENT=$2

case $COMMAND in
    add)
        mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="add \"$ARGUMENT\""
        ;;
    update)
        ID=$3
        mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="update $ID \"$ARGUMENT\""
        ;;
    delete)
        ID=$2
        mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="delete $ID"
        ;;
    mark-in-progress)
        ID=$2
        STATUS="in-progress"
        mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="mark \"$ID\" \"$STATUS\""
        ;;
    mark-done)
        ID=$2
        STATUS="done"
        mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="mark \"$ID\" \"$STATUS\""
        ;;
    list)
        STATUS=$2
        if [ -z "$STATUS" ]; then
            mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="list"
        else
            mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="list $STATUS"
        fi
        ;;
        help)
         mvn exec:java -Dexec.mainClass="org.example.Main" -Dexec.args="help"
        ;;
    *)
        echo "Invalid command. Use add, update, delete, mark-in-progress, mark-done, or list."
        ;;
esac
