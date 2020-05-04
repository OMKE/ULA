# Description

## Simple CLI Spring Boot Code Generator written in python3

### Generate DTOs, Repository, Service and Controllers

# Usage

Add the script to the path so it's easy accessible from anywhere

1. Create directory, for example ~/.bin/
2. Navigate to the created directory and clone the repository with git clone or download manually
3. Add the script to the PATH
   for Unix-like OS:
   open your .bashrc or .zshrc with your favourite text editor and add
   <br>
   `export PATH="/Users/<your-username>/bin/generator/":\$PATH`

   for Windows:
   #TODO

4. Navigate to your Spring Boot Applicaiton project, whre pom.xml is located and you can start generating code
5. keyword for script is `$ spring-cli`

Pass -h or --help to show all possible arguments

After you navigated to the project root, we can set a main root class (it helps generator to catch package name and in the future every method so you don't have to manually specify class properties)
<br>
We set it with
`$ spring-cli -m=<Root application class file>`

### Example: `$ spring-cli -m=SpringBootApplication` (without .java extension)

If you typed the right file name, it will show a message of success, otherwise it will show that project main class is not found and the project root was not set.
<br>
After project main class was set. You can now generate DTOs, Repository, Service and Controllers with one simple command
<br>
`$ spring-cli -g -md=<ModelFileName> -p "<type propertyName>" <type propertyName> <type propertyName> "<etc etc>"`

### Example:

We have an entity/model with properties as follows:

```java
java/com.omaririskic.fun_project/model/User.java
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Colum
    @Type(type = "text")
    private String firstName;
    @Colum
    @Type(type = "text")
    private String lastName;
    @Colum
    @Type(type = "text")
    private String email;

    ...constructor, getters, setters, equals, hashcode
}
```

Command - `$ spring-cli -g -md=User -p "String firstName" "String lastName" "String email"`
If the model file name is correct, we should get an output that it generated four files successfully, otherwise it will say that model is not found.

For convinience, everytime the script is run, it will display a current project so we are sure that we're working with the correct one.
If you want to use the script with another project, simply pass the -r argument to reset the config file.
<br>
`$ spring-cli -r`

## All possible arguments and explanation:

| Argument     | Short | Description                                                                                             |
| ------------ | :---: | :------------------------------------------------------------------------------------------------------ |
| --main       |  -m   | Sets the main application root file (File that bootstraps SpringBootAplication)                         |
| --generate   |  -g   | Generates files with given model (unallowed to be used alone)                                           |
| --model      |  -md  | Finds a model with given file name and makes templates around it                                        |
| --properties |  -p   | Takes the passed arguments (separated with space) as a list and generates properties and methods in DTO |
| --reset      |  -r   | Resets the config so it can be used with others projects                                                |

#### future plans:

- parse the java file so properties do not have to be manually typed
