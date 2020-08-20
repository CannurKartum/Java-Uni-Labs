def copy(times:Int, item:Int):Stream[Int] = {
    if (times > 0) item #:: copy(times - 1, item)
    else Nil.toStream
  }

def evaluate(numbers:Stream[Int], multitimes:Stream[Int]):Stream[Int] =numbers match {
    case Stream(h, t @_*)  => multitimes match {
      case Stream(head, tail @_*) => copy(head, h)#::: evaluate(t.toStream, tail.toStream)
    }
  }


  println(evaluate( Stream.from(1), Stream.from(1)).take(10).force)
  println(evaluate( Stream.from(1), Stream.from(1)))
  print(evaluate(Stream(1,2,3), Stream(0,3,1,4)).take(4).force)

