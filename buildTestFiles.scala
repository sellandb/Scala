for(i <- 1 to 100000){
	val rnd = new scala.util.Random()
	var out_file = new java.io.FileOutputStream("sampleFiles\\"+i+".txt")
	var out_stream = new java.io.PrintStream(out_file)
	for(j <- 1 to 10) {
		out_stream.println(rnd.nextInt()%100)
	}
	out_stream.close
}