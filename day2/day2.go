package main

import (
	"fmt"
	"os"
	"strings"
)

var match = make(map[string]int)
var turn = make(map[string]string)

func createMap() {
	match["A X"] = 4
	match["A Y"] = 8
	match["A Z"] = 3
	match["B X"] = 1
	match["B Y"] = 5
	match["B Z"] = 9
	match["C X"] = 7
	match["C Y"] = 2
	match["C Z"] = 6

	turn["A X"] = "A Z"
	turn["A Y"] = "A X"
	turn["A Z"] = "A Y"
	turn["B X"] = "B X"
	turn["B Y"] = "B Y"
	turn["B Z"] = "B Z"
	turn["C X"] = "C Y"
	turn["C Y"] = "C Z"
	turn["C Z"] = "C X"
}

func main() {
	bytes, err := os.ReadFile("./input.txt")
	if err != nil {
		panic(err)
	}
	createMap()

	lines := strings.Split(string(bytes), "\r\n")
	score := playPart1(lines)

	fmt.Printf("Day 2 - part 1\nMy final score will be %d\n", score)
	score = playPart2(lines)
	fmt.Printf("Day 2 - part 2\nMy final score will be %d\n", score)
}

func playPart1(lines []string) int {
	score := 0

	for _, l := range lines {
		score += match[strings.TrimSpace(l)]
	}

	return score
}

func playPart2(lines []string) int {
	score := 0

	for _, l := range lines {
		score += match[turn[strings.TrimSpace(l)]]
	}

	return score
}
