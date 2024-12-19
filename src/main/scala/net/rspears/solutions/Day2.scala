package net.rspears.solutions

import net.rspears.Day

import scala.io.BufferedSource

class Day2 extends Day {
  val num = 2

  def solutionA(input: BufferedSource): Unit = {
    val answer = input.getLines().map(_.split(" ").map(_.toInt)).count { rpt =>
      validReport(rpt)
    }
    println(answer)
  }

  def solutionB(input: BufferedSource): Unit = {
    val answer = input.getLines().map(_.split(" ").map(_.toInt)).count { rpt =>
      reportCombos(rpt).count { subRpt =>
        validReport(subRpt)
      } > 0
    }
    println(answer)
  }

  def validReport(rpt: Array[Int]): Boolean = {
    val ascOrDesc = (rpt sameElements rpt.sorted) || (rpt sameElements rpt.sorted.reverse)
    val valsClose = (1 until rpt.length).forall { i =>
      math.abs(rpt(i) - rpt(i - 1)) > 0 && math.abs(rpt(i) - rpt(i - 1)) < 4
    }
    ascOrDesc && valsClose
  }

  def reportCombos(rpt: Array[Int]): IndexedSeq[Array[Int]] = {
    rpt.indices.map { i =>
      rpt.take(i) ++ rpt.drop(i + 1)
    } :+ rpt
  }
}
