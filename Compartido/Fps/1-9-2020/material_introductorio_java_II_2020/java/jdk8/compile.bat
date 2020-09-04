@echo off
echo Cleaning
del  classes\*.class
echo Compiling
javac -cp .;lib -d classes src\*.java
