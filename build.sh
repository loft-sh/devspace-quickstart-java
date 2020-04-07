#!/bin/sh

# Build jar file
mvn package -U -Dmaven.test.skip=true

# Rename jar file
mv target/*.jar main.jar

# Start application if `run` argument is passed
if [ $1 = "run" ]; then
  java -jar main.jar
fi
