@echo off
title Java Lexical Analyzer Runner

REM Go to the folder where this .bat file lives
cd /d "%~dp0"

REM Ensure bin folder exists
if not exist bin mkdir bin

echo Compiling LexicalAnalyzer.java ...
javac -Xlint:-options -source 8 -target 8 -d bin test\src\main\LexicalAnalyzer.java
if errorlevel 1 (
    echo.
    echo ❌ Compilation failed! Please check your code for errors.
    pause
    exit /b
)

echo.
echo ✅ Compilation successful! Launching program...
echo.

REM Run the program
cd bin
java LexicalAnalyzer
if errorlevel 1 (
    echo.
    echo ❌ Failed to run LexicalAnalyzer. Make sure the class name matches the file.
    pause
    exit /b
)

echo.
echo Program finished. Press any key to exit.
pause
