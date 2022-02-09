I try to design a Class Registration System. Students can log into the system and register in the courses.
I use MVC pattern, strategy pattern and Data Access Object pattern.

   For the flexibility, I use strategy pattern between my view layer and controller layer.
There is two panel in my view layer, each panel inherit from the class AbstractPanel
Each panel has strategy to do the request which is doAction() method.
And ActionController refers to the AbstractPanel for performing the strategy doAction(). 
Method getActionCommand() get the command from panel and ActionController will know which panel should call its strategy algorithm.
And I can add new strategy or new pattern easily by inherit from AbstractPanel class.

And MVC pattern also bring benefits to me.
We have the View layer, Controller layer.model layer and etc. We can read code clearly.
People can come to this project easily.
If I need new function in the login panel, I only need to create a new service and modify the controller.
And also if I only need new panel, I can create a new one and call the existed controller.

DAO pattern can make me easier to employ my system on different platform using the different database.
When we need to achieve data from other database or storage mechanism,
we only need to modify the dao layer to adapt to the new storage mechanism.
#project implementation
For this project I use maven to insert  dependency and add a jar file as 
library in the lib file.







# Project Template

This is a Java Maven Project Template


# How to compile the project

We use Apache Maven to compile and run this project. 

You need to install Apache Maven (https://maven.apache.org/)  on your system. 

Type on the command line: 

```bash
mvn clean compile
```

# How to create a binary runnable package 


```bash
mvn clean compile assembly:single
```


# How to run

```bash
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
```

We recommand the above command for running the Main Java executable. 




# Run all the unit test classes.


```bash
mvn clean compile test checkstyle:check  spotbugs:check
```

# Using Spotbugs to find bugs in your project 

To see bug detail using the Findbugs GUI, use the following command "mvn findbugs:gui"

Or you can create a XML report by using  


```bash
mvn spotbugs:gui 
```

or 


```bash
mvn spotbugs:spotbugs
```


```bash
mvn spotbugs:check 
```

check goal runs analysis like spotbugs goal, and make the build failed if it found any bugs. 


For more info see 
https://spotbugs.readthedocs.io/en/latest/maven.html


SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.


# Run Checkstyle 

CheckStyle code styling configuration files are in config/ directory. Maven checkstyle plugin is set to use google code style. 
You can change it to other styles like sun checkstyle. 

To analyze this example using CheckStyle run 

```bash
mvn checkstyle:check
```

This will generate a report in XML format


```bash
target/checkstyle-checker.xml
target/checkstyle-result.xml
```

and the following command will generate a report in HTML format that you can open it using a Web browser. 

```bash
mvn checkstyle:checkstyle
```

```bash
target/site/checkstyle.html
```




