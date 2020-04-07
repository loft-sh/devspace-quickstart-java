#!/bin/sh

mvn clean package -U -Dmaven.test.skip=true -Djar.finalName=app.jar

if [ $1 = "run" ]; then
  java -jar main.jar
fi
