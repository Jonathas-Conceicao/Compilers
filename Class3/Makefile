J=java
JC=javac
JCC=javacc

MAIN_CLASS=Lugosi

FILE ?= minimal.lug

all: $(MAIN_CLASS).class

$(MAIN_CLASS).class:
	$(JCC) Lugosi.jj
	$(JC)  *.java

run: $(MAIN_CLASS).class
	$(J) $(MAIN_CLASS) $(FILE)

clean:
	rm -rf *.java
	rm -rf *class
