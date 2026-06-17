JAVAC = javac
JAVA = java

SOURCES = Main.java \
          exception/*.java \
          model/*.java \
          repository/*.java \
          util/*.java
MAIN = Main

all:
	$(JAVAC) $(SOURCES) 

run: all
	$(JAVA) $(MAIN)

clean:
	find . -name "*.class" -delete

re: clean all