package main

import (
	"testing"

	"github.com/gonutz/check"
)

func TestNothing(t *testing.T) {
	check.Eq(t, 0, 0)
}

func TestSimpleStackPerformsActionsCorrectly(t *testing.T) {
	got := []string{"A B C D\r\nE", "m 1 f 1 t 2"}
	res1, _ := moveCrates(got)
	check.Eq(t, res1, "CD")
}

func TestExamplePart1(t *testing.T) {
	got := []string{"Z N\r\nM C D\r\nP", "move 1 from 2 to 1\r\nmove 3 from 1 to 3\r\nmove 2 from 2 to 1\r\nmove 1 from 1 to 2"}
	res1, _ := moveCrates(got)
	check.Eq(t, res1, "CMZ")
}

func TestExamplePart2(t *testing.T) {
	got := []string{"Z N\r\nM C D\r\nP", "move 1 from 2 to 1\r\nmove 3 from 1 to 3\r\nmove 2 from 2 to 1\r\nmove 1 from 1 to 2"}
	_, res2 := moveCrates(got)
	check.Eq(t, res2, "MCD")
}
