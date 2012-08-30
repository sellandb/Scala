import scala.actors.Actor
import scala.actors.Actor._

def timeMethod(method: () => Unit) = {
	val start = System.nanoTime
	method()
	val end = System.nanoTime
	println("Method took " + (end - start)/1000000000.0 + " seconds")
}

case class Accumulate(file: String)
case class Total


object Accumulator extends Actor{
	def act = {
		var sum = 0;
		
		loop {
		    react{
				case Accumulate(f) => scala.io.Source.fromFile(f).getLines().foreach(n => sum += n.toInt)
				case Total => reply(sum); exit
		    }
		}
	}
}
 

def parseFilesCon() = {
	Accumulator.start
	val f = new java.io.File("sampleFiles")
	for(files <- f.list()) {
		Accumulator ! Accumulate("sampleFiles\\" + files)
	}

	Accumulator !? Total match {
		case result: Int => println(result)
	}
}

def parseFilesSeq() = {
	var sum = 0;
	val f = new java.io.File("sampleFiles")
	for(files <- f.list()) {
		scala.io.Source.fromFile("sampleFiles\\" + files).getLines().foreach(n => sum += n.toInt)
	}
	println(sum)	
}

timeMethod(parseFilesCon)

timeMethod(parseFilesSeq)