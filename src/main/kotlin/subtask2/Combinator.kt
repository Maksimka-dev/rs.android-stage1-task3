package subtask2

class Combinator {

    // TODO: Complete the following function
    fun checkChooseFromArray(array: Array<Int>): Int?
    {
        //throw NotImplementedError("Not implemented")
        var result: Int? = 0

        for (i in 1..array[1])
        {
            var comb: Long = factorial(array[1]) / (factorial(i) * factorial(array[1] - i))
            if (comb == array[0].toLong())
            {
                result = i
                break
            }
        }
        if (result == 0)
        {
            result = null
        }

        return result
    }

    fun factorial(argument: Int): Long
    {
        var result: Long = 1
        for (i in 1..argument)
        {
            result = result * i
        }

        return result
    }
}
