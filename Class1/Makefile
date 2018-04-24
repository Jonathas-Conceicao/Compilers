SHELL = /bin/bash

PACKAGE = Parser						\
					Compilador				\
					CodeGen					\
					ArvoreSintatica	\
					CodeInterpret		\
					AnaliseLexica


JAVAC = javac
JC_FLAG = # -Xlint:all
CLASSPATH =

JD = javadoc
JD_FLAG = -Xdoclint:all

JR = jar
JR_FLAG = cmvf
JR_MANIFEST = META-INF/MANIFEST.MF
TARGET = compilador

SRC = src
BIN = bin
DOC = docs

RM = rm
RM_FLAG = -rf

BIN_LOCATION ?= .
JAR_LOCATION ?= .
MAN_LOCATION ?= .
MV = mv
MV_FLAG = -u
CP = cp
CP_FLAG = -u

all:
	$(JAVAC) $(JC_FLAG) $(addprefix $(SRC)/, $(addsuffix .java, $(PACKAGE))) -d $(BIN)/

clean:
	$(RM) $(RM_FLAG) $(BIN)/*.class

cleanTarget:
	$(RM) $(RM_FLAG) $(TARGET)*

cleanDoc:
	$(RM) $(RM_FLAG) $(DOC)/*
