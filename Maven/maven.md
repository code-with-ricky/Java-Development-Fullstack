## basic command for creating a java project using maven build tool
`mvn archetype:generate -DgroupId=com.amrik -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.0 -DinteractiveMode=false`

## Command Breakdown
- `archetype:generate` → create a single java project
- `-DgroupId` → name of the package usually name of company under which this project is built
- `-DartifactId` → name of the application, by this name only jar/war file will be created
- `-DarchetypeArtifactId` → what type of java project we are creating; here quickstart means standalone whose jar file will be created later  [ Optional ]
- `-DarchetypeVersion` → specify the version of the application that we are creating
- `-DinteractiveMode` → weather to ask or not the values of parameters for creating the application; here false means don't ask as all parameters already provided

### Note:
- anything starting as -D is parameter

## Maven Terminologies
- `Archetype`: template that defines the structure of a Maven Project
