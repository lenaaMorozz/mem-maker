# Mem-maker

Mem-maker is a console application that allows you to create memes by adding text to images.

| before | after | 
|-------------|-------------|
| <img src="https://github.com/lenaaMorozz/mem-maker/blob/master/src/main/resources/image/dog.jpg" width="300">  | <img src="https://github.com/lenaaMorozz/mem-maker/blob/master/src/main/resources/image/dog-mem.jpg" width="300">| 


## Running the Application

To run Mem-maker, follow these steps:

### 1.Clone the repository on your computer:

```bash
git clone https://github.com/lenaaMorozz/mem-maker.git
```


### 2. Compile and package the project using Maven:

```bash
mvn clean package
```

### 3. Run the application using the java -jar command, specifying the path to the compiled JAR file:


```bash
java -jar target/mem-maker-1.0-SNAPSHOT.jar <command> <parametres>
```

## Usage

Mem-maker supports two commands:

### 1. help
The `help` command displays the usage manual for the program and provides descriptions of all available commands and their arguments.

Example usage:

```bash
java -jar target/mem-maker-1.0-SNAPSHOT.jar help
```
### 2. mem
The `mem` command allows you to create memes by adding text to images.

Example usage:
```bash
java -jar target/mem-maker-1.0-SNAPSHOT.jar mem ./cat.png 'your text' top 60
```
- ./cat.png - the path to the image to which you want to add text.
- 'your text' - the text that will be added to the image.
- top - the position of the text, options: top, center, bottom (default - bottom).
- 60 - the font size (default is 50).

After executing the mem command, a new image will be saved in the current directory with the added text, and its name will contain "-mem" (example: `cat-mem.png`).

## Dependencies

For Mem-maker to work successfully, make sure you have the following dependencies installed:

- Java 17 or higher
- Apache Maven












