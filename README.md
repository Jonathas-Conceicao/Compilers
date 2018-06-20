# Compilers
A repository for my exercises for my Compilers course at UFPel.

## List of Activities
List of activities to be done divided by classes.

### Class 1
- Exercise  
	1. [X] Implement subtraction and division  
	2. [X] Implement support to natural numbers  
- Task  
	1. [X] Change the code generator to a Interpreter  
	2. [ ] Implement the stack machine  

### Class 2
Lexical analysis class.
- Task  
	1. [X] Make a lexic analiser for Lugosi using flex  
	2. [X] Make some correct and incorrect Lugosi examples  

## Class 3
Syntactic analysis class.  
-  Task  
	1. [ ] Finish implementing the Lugosi compiler  
	2. [ ] Create at least 3 programs examples (can be the same of class 2)  

## Class 4
First & Follow
- Task
	1. Tasks deadline for 19/05
### Class exercise
S -> if E then S else S | id := E  
E -> S v T | T  
T -> ¬ id | id | (E)  

first(T) = {¬, (, id}  
first(E) = {¬, (, if, id}  
first(S) = {if, id}  

follow(S) = {EOF, v, else}  
follow(E) = {then, EOF, ), v}  
follow(T) = {then, EOF, ), v}  

E -> -E | (E) | VL  
L -> -E | £  
V -> id S  
S -> (E) | £  

first(S) = {(, £}  
first(V) = {id}  
first(L) = {-, £}  
first(E) = {-, (, id}  

follow(E) = {EOF, )}  
follow(L) = {EOF, )}  
follow(V) = {-, EOF, )}  
follow(S) = {-, EOF, )}  

E -> TX  
X -> + E  
X -> £  
T -> int Y | (E)  
Y -> \*T | £  

first(E) = {\*, £}  
first(X) = {+, £}  
first(T) = {int, (}  
first(Y) = {\*, £}  

follow(E) = {EOF, )}  
follow(X) = {EOF, )}  
follow(T) = {+, \*, )}  
follow(Y) = {+, \*, )}  

# Class 5
-  Task
	1. [x] Implement Parser
		- [ ] refactor the language
	2. [ ] Generate Syntactic Tree
		- [ ] Define classes for the language
	3. [ ] Pretty Printer for Lugosi
	4. [ ] Compile Lugosi to another language
	5. [ ] Make tree example programs in Lugosi

Tips from teacher:
``` Java
import java.util.ArrayList;

class Lugosi {
	Main main;
	ArrayList <Func> funcs;
}

class Main {
	ArrayList <VarDecl> decls;
	ArrayList <Commands> commands;
}

class VarDecl {
	String id;
	Tipo tipo;
}

class Tipo {}
class Int extendes Tipo {}
class Bool extands Tipo {}
```
