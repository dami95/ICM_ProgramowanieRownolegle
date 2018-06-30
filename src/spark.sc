val NUM_SAMPLES = 2100000000; val t = System.nanoTime(); val count = sc.parallelize(1 to NUM_SAMPLES).filter { _ =>
  val x = math.random
  val y = math.random
  x*x + y*y < 1
}.count(); val pi = 4.0 * count / NUM_SAMPLES; val t2 = System.nanoTime(); print("2,"); print(NUM_SAMPLES); print(","); print(pi); print(",");  print((t2-t) * 1e-9);  println("");
