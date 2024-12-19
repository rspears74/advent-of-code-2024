package net.rspears

import scala.io.{BufferedSource, Source}

trait Day {
  val num: Int
  def readInput: BufferedSource = {
    Source.fromResource(s"input${num}.txt")
  }

  def runA: Unit = {
    val input = readInput
    solutionA(input)
  }

  def runB(): Unit = {
    val input = readInput
    solutionB(input)
  }

  def solutionA(input: BufferedSource): Unit
  def solutionB(input: BufferedSource): Unit
}
