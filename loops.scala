def whileloop {
	var i = 1
	while(i <= 3) {
		println(i)
		i+=1
	}
}

whileloop

def forloop {
	println("For loop using Java-stlye iteration")
	for(i <- 0 until args.length) {
		println(args(i))
	}
}

forloop

def foreachLoop {
	println("For each loop")
	args.foreach{ arg =>
		println(arg)
	}
}

foreachLoop