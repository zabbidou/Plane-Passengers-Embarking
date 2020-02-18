.PHONY: build run

build: 
	javac -sourcepath src -d build src/tema1/*.java

run: build
	java -cp .:build:tema1/*.class tema1.Main

clean:
	rm ./build/tema1/*.class
