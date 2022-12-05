package main

import (
	"testing"

	"github.com/gonutz/check"
)

func TestRightScoreOnExampleINput(t *testing.T) {
	createMap()

	input := []string{"A Y", "B X", "C Z"}
	got := playPart1(input)
	check.Eq(t, got, 15)
}

func TestMatchingPoints(t *testing.T) {
	createMap()
	check.Eq(t, match["A X"], 4)
	check.Eq(t, match["A Y"], 8)
	check.Eq(t, match["A Z"], 3)
	check.Eq(t, match["B X"], 1)
	check.Eq(t, match["B Y"], 5)
	check.Eq(t, match["B Z"], 9)
	check.Eq(t, match["C X"], 7)
	check.Eq(t, match["C Y"], 2)
	check.Eq(t, match["C Z"], 6)
}

func TestTurnReturnsRightMatch(t *testing.T) {
	createMap()
	check.Eq(t, turn["A X"], "A Z")
	check.Eq(t, turn["A Y"], "A X")
	check.Eq(t, turn["A Z"], "A Y")
	check.Eq(t, turn["B X"], "B X")
	check.Eq(t, turn["B Y"], "B Y")
	check.Eq(t, turn["B Z"], "B Z")
	check.Eq(t, turn["C X"], "C Y")
	check.Eq(t, turn["C Y"], "C Z")
	check.Eq(t, turn["C Z"], "C X")
}
