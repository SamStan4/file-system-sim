exit 1

# this is the command that I used to create this project :)

mvn archetype:generate \
  -DgroupId=io.github.samstan4 \
  -DartifactId=file-system-simulator \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

# this is the command that I use to build the project

mvn clean build

# here is the command that I use to run the thing

