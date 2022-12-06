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

	pairs := createPairs(bytes)
	score := 0
	for _, p := range pairs {
		if p.bx <= p.ax && p.ax <= p.by && p.bx <= p.ay && p.ay <= p.by ||
			p.ax <= p.bx && p.bx <= p.ay && p.ax <= p.by && p.by <= p.ay {
			score++
		}
	}
	fmt.Printf("Day 4 - Part 1\nThere are %d pairs containing each other\n", score)
	score = 0
	for _, p := range pairs {
		if p.bx <= p.ax && p.ax <= p.by || p.bx <= p.ay && p.ay <= p.by ||
			p.ax <= p.bx && p.bx <= p.ay || p.ax <= p.by && p.by <= p.ay {
			score++
		}
	}
	fmt.Printf("Day 4 - Part 2\nThere are %d pairs that overlap at any point\n", score)
}

func createPairs(bytes []byte) (pairs []pair) {
	lines := strings.Split(string(bytes), "\r\n")
	pairs = make([]pair, 0)
	for _, l := range lines {
		splitted := strings.Split(l, ",")
		pairs = append(pairs, createPair(splitted))
	}
	return
}

func createPair(in []string) pair {
	p1 := strings.Split(in[0], "-")
	p2 := strings.Split(in[1], "-")

	ax, err := strconv.ParseInt(p1[0], 10, 64)
	if err != nil {
		panic(err)
	}
	ay, err := strconv.ParseInt(p1[1], 10, 64)
	if err != nil {
		panic(err)
	}
	bx, err := strconv.ParseInt(p2[0], 10, 64)
	if err != nil {
		panic(err)
	}
	by, err := strconv.ParseInt(p2[1], 10, 64)
	if err != nil {
		panic(err)
	}
	return pair{ax: int(ax), ay: int(ay), bx: int(bx), by: int(by)}
}

type pair struct {
	ax int
	ay int
	bx int
	by int
}
