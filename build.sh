#!/bin/sh

mvn clean package -U -Dmaven.test.skip=true -Djar.finalName=main

if [ $1 = "run" ]; then
  java -jar target/main.jar
fi
