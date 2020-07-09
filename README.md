# CaptecChallenge
Calculator challenge for Captec

## Overview
This calculator is a CLI application, distributed as a JAR file. Application lifecycle is managed by Maven; in case you want to do some changes in the codebase and create a new version, please download, install and configure Maven. 

***Important***
Following instructions only provide support for application execution.

## Prerequisites
First, make sure you have already Java install. For this, run: 

``` bash
java -version
```

If executed successfully, you will see the installed version of Java in your computer. If it is higher than 1.8, procede to the next step. 
Otherwise, follow the following tutorial to install Java:
https://medium.com/w-logs/installing-java-11-on-macos-with-homebrew-7f73c1e9fadf

## Execution
Run the following command in the root folder of the project:
``` bash
java -jar Calculator-1.0-SNAPSHOT.jar 
```

This will start the Calculator Application. In order to exit the current process, press 'e'. 

## Description and Rules
- ***+*** input will display the result of adding the runningTotal (initialized as zero) and the current value.
- ***+*** input, after a previous ***+***, will reset the runningTotal to zero.
- ***C*** input will reset the runningTotal to zero.
- ***=*** input will reset the runningTotal to zero but will display the latest value of the runningTotal.
- If the result of an addition or the current value overflows, ***ERROR!*** will be displayed, and runningTotal is reset to zero.

## Testing
- JUnit was used as testing framework.
- Tests intend to replicate the obtained result after the input of a series of characters. Each step is validated.
- In order to run the test locally, Maven is requiered. If installed, run:
``` bash
mvn clean test
```
<img width="771" alt="Screen Shot 2020-07-09 at 00 00 10" src="https://user-images.githubusercontent.com/23660935/86999092-64861800-c177-11ea-917a-c9836283a885.png">



## Further developing
- Maven installed and configured is needed.
- After a change, run:
``` bash
mvn clean install
```
to generate a new JAR. This will be located at /target/Calculator-1.0-SNAPSHOT.jar
- Generated JAR can be executed with command:
``` bash
java -jar Calculator-1.0-SNAPSHOT.jar
```



