# File System Simulator

## Overview

The File System Simulator is a Java project designed to simulate basic file system operations and behaviors. This project serves as a hands-on exercise to deepen my familiarity with Java and Maven, building on my previous experience creating a similar simulator in C using Makefiles. It demonstrates Java project structure, Maven build automation, and core file system concepts.

## Features
 - Simulated file creation, deletion, and modification.
 - Navigation of directories
 - Basic file system commands (ls, mkdir, touch, rm, echo, cat, mv, etc.)

## Prerequisites

 - Java 21 installed ([Download JDK](https://www.oracle.com/java/technologies/downloads/#java21))
 - Maven 3.8 installed ([Download Maven](https://maven.apache.org/download.cgi))

## Building and Running

### Build the project
```bash
mvn clean install
```

### Run the application
```bash
mvn exec:java -Dexec.mainClass="io.github.samstan4.App"
```

## Clone the Repository
```bash
git clone git@github.com:SamStan4/file-system-sim.git
cd file-system-sim
```