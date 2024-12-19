package net.rspears.solutions

import net.rspears.Day

import scala.io.BufferedSource

class Day1 extends Day {
  val num = 1

  def solutionA(input: BufferedSource): Unit = {
    val answer = input.getLines()
      .map(_.split("   ").map(_.toInt)).toList
      .transpose
      .map(_.sorted)
      .transpose
      .map(l => math.abs(l(0) - l(1)))
      .sum
    println(answer)
  }

  def solutionB(input: BufferedSource): Unit = {
    val lists = input.getLines()
      .map(_.split("   ").map(_.toInt)).toList
      .transpose
    val answer = lists.head.map { n =>
      lists.last.count(_ == n) * n
    }.sum
    println(answer)
  }
}
