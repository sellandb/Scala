import scala.io.Source
import scala.collection.mutable.HashMap

def fact(num:Int)=(1 /: (2 to num)){(prod, item) => prod * item}

trait Censor
{
	var words = HashMap[String,String]()
	def loadWords() = {		
		words = HashMap("shoot" -> "pucky", "darn" -> "beans")
	}
	def loadWords(fileName:String) = {
		Source.fromFile(fileName).getLines().foreach(n => words += n.split(",")(0) -> n.split(",")(1))
	}
	def replace(input:String):String = {
		var output = input
		words.foreach(word => output = output.replace(word._1,word._2))
		return output
	}
}

class Test extends Censor
{
	def run() = {
		Console.println(replace("One Two fuck Three shoot Four darn five shit"))
	}

}

var blah = new Test()
blah.loadWords("censorDictionary.csv")
blah.run()