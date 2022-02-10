Skip to content
Search or jump to…
Pull requests
Issues
Marketplace
Explore
 
@Nalaaaaa 
metcs
/
met-cs665-assignment-project-Nalaaaaa
Private
generated from kiat/JavaProjectTemplate
Code
Issues
Pull requests
Actions
Projects
Wiki
Security
Insights
met-cs665-assignment-project-Nalaaaaa
/
README.md
in
master
 

Spaces

3

Soft wrap
1
I try to design a Class Registration System. Students can log into the system and register in the courses.
2
I use MVC pattern, strategy pattern and Data Access Object pattern.
3
​
4
   For the flexibility, I use strategy pattern between my view layer and controller layer.
5
There is two panel in my view layer, each panel inherit from the class AbstractPanel
6
Each panel has strategy to do the request which is doAction() method.
7
And ActionController refers to the AbstractPanel for performing the strategy doAction(). 
8
Method getActionCommand() get the command from panel and ActionController will know which panel should call its strategy algorithm.
9
And I can add new strategy or new pattern easily by inherit from AbstractPanel class.
10
​
11
And MVC pattern also bring benefits to me.
12
We have the View layer, Controller layer.model layer and etc. We can read code clearly.
13
People can come to this project easily.
14
If I need new function in the login panel, I only need to create a new service and modify the controller.
15
And also if I only need new panel, I can create a new one and call the existed controller.
16
​
17
DAO pattern can make me easier to employ my system on different platform using the different database.
18
When we need to achieve data from other database or storage mechanism,
19
we only need to modify the dao layer to adapt to the new storage mechanism.
20
#project implementation
21
For this project I use maven to insert  dependency and add a jar file as 
22
library in the lib file.
23
​
24
​
25
​
26
​
27
​
28
​
29
​
30
# Project Template
31
​
32
This is a Java Maven Project Template
33
​
34
​
35
# How to compile the project
36
​
37
We use Apache Maven to compile and run this project. 
38
​
39
You need to install Apache Maven (https://maven.apache.org/)  on your system. 
40
​
41
Type on the command line: 
42
​
43
```bash
44
mvn clean compile
45
```
46
​
47
# How to create a binary runnable package 
48
​
49
​
50
```bash
51
mvn clean compile assembly:single
52
```
53
​
54
​
55
# How to run
56
​
57
```bash
58
mvn -q clean compile exec:java -Dexec.executable="edu.bu.met.cs665.Main" -Dlog4j.configuration="file:log4j.properties"
59
```
60
​
61
We recommand the above command for running the Main Java executable. 
62
​
63
​
64
​
65
​
66
# Run all the unit test classes.
67
​
No file chosen
Attach files by dragging & dropping, selecting or pasting them.
@Nalaaaaa
Commit changes
Commit summary
Create README.md
Optional extended description
Add an optional extended description…
 Commit directly to the master branch.
 Create a new branch for this commit and start a pull request. Learn more about pull requests.
 
© 2022 GitHub, Inc.
Terms
Privacy
Security
Status
Docs
Contact GitHub
Pricing
API
Training
Blog
About
