package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	bytes, err := os.ReadFile("./input.txt")
	if err != nil {
		panic(err)
	}
	input := string(bytes)
	s := strings.Split(input, "\r\n\r\n")

	result1, result2 := moveCrates(s)
	fmt.Printf("Day 5 - part 1\nThe stacks' tops are: '%s'\n", result1)
	fmt.Printf("Day 5 - part 2\nThe stacks' tops are: '%s'\n", result2)
}

type crateStack struct {
	stack [][]rune
}

func moveCrates(input []string) (cm9000, cm9001 string) {
	crateMove9000 := createStack(input[0])
	crateMove9001 := createStack(input[0])
	operations := strings.Split(input[1], "\r\n")
	for _, l := range operations {
		partialLine := strings.Split(l, " ")

		amount, err := strconv.ParseInt(partialLine[1], 10, 64)
		if err != nil {
			panic(err)
		}
		from, err := strconv.ParseInt(partialLine[3], 10, 64)
		if err != nil {
			panic(err)
		}
		to, err := strconv.ParseInt(partialLine[5], 10, 64)
		if err != nil {
			panic(err)
		}
		crateMove9000.moveOneAtATime(int(amount), int(from), int(to))
		crateMove9001.moveAllAtATime(int(amount), int(from), int(to))
	}
	cm9000 = crateMove9000.getLastElements()
	cm9001 = crateMove9001.getLastElements()
	return
}

func createStack(input string) crateStack {
	stack := make([][]rune, 9)
	for i, _ := range stack {
		stack[i] = make([]rune, 0)
	}
	for i, l := range strings.Split(input, "\r\n") {
		temp := stack[i]
		for _, b := range l {
			if b != ' ' {
				temp = append(temp, b)
			}
		}
		stack[i] = temp
	}

	return crateStack{stack: stack}
}

func (c *crateStack) moveOneAtATime(amount, from, to int) {
	for i := 0; i < amount; i++ {
		move := c.stack[from-1][len(c.stack[from-1])-1:]
		c.stack[from-1] = c.stack[from-1][:len(c.stack[from-1])-len(move)]
		temp := c.stack[to-1]
		temp = append(temp, move...)
		c.stack[to-1] = temp
	}
}

func (c *crateStack) moveAllAtATime(amount, from, to int) {
	move := c.stack[from-1][len(c.stack[from-1])-amount:]
	c.stack[from-1] = c.stack[from-1][:len(c.stack[from-1])-len(move)]
	temp := c.stack[to-1]
	temp = append(temp, move...)
	c.stack[to-1] = temp
}

func (c *crateStack) getLastElements() string {
	result := ""
	for _, s := range c.stack {
		fmt.Println(len(s), s)
		if len(s) > 0 {
			result += string(s[len(s)-1])
		}
	}
	return strings.TrimSpace(result)
}
