package net.rspears.solutions

import net.rspears.Day

import scala.io.BufferedSource

class Day3 extends Day {

  override val num: Int = 3

  override def solutionA(input: BufferedSource): Unit = {
    val regex = """mul\(\d+,\d+\)""".r
    val answer = input.getLines().map { line =>
      regex.findAllIn(line).map { mtch =>
        mtch.drop(4)
          .dropRight(1)
          .split(",")
          .map(_.toInt)
          .product
      }.sum
    }.sum

    println(answer)
  }

  override def solutionB(input: BufferedSource): Unit = {
    val regex = """mul\(\d+,\d+\)|don't\(\)|do\(\)""".r
    var doState = true
    val answer = input.getLines().map { line =>
      val matches = regex.findAllIn(line).toList
      val includeMul = matches.indices.map { i =>
        if (isMul(matches(i))) {
          doState
        } else {
          doState = isDo(matches(i))
          doState
        }
      }
      matches.zip(includeMul)
        .filter(m => m._1.startsWith("mul") && m._2)
        .map { mtch =>
          mtch._1.drop(4)
            .dropRight(1)
            .split(",")
            .map(_.toInt)
            .product
        }.sum
    }.sum

    println(answer)
  }

  def isMul(s: String): Boolean = {
    s.startsWith("mul")
  }

  def isDo(s: String): Boolean = {
    s == "do()"
  }
}
