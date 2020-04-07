#!/bin/sh

# Build jar file
mvn clean package -U -Dmaven.test.skip=true

# Rename jar file
mv target/*.jar target/main.jar

# Start application if `run` argument is passed
if [ $1 = "run" ]; then
  java -jar target/main.jar
fi
