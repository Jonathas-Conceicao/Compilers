FLEX=flex

CC=gcc
C_FILE=lex.yy.c
OUT_FILE=lex.out

FILE ?= TokensTest.lug

RM = rm -rf

all: $(C_FILE)

$(C_FILE): Lugosi.l
	$(FLEX) Lugosi.l
	$(CC) $(C_FILE) -o $(OUT_FILE)

run: $(C_FILE)
	./$(OUT_FILE) < $(FILE)

clean:
	$(RM) $(C_FILE)
	$(RM) $(OUT_FILE)

