@echo off
echo Cleaning 
del /s /q build\eif400fp.jar classes\* 1>nul
echo Compiling
javac -Xlint -cp .;lib -d classes src\*.java
echo Building jar
jar cf eif400fp.jar -C classes .
rem jar tf eif400fp.jar
echo copying jar
move eif400fp.jar build\eif400fp.jar