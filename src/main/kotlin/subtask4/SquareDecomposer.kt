package subtask4

class SquareDecomposer {

    private fun dec(y: Long, r: Long): MutableList<Long>? {
        if (r == 0L)
        {
            return mutableListOf(y)
        }

        for (x in y - 1 downTo 0)
        {
            val d = r - x * x

            if (d >= 0)
            {
                val res = dec(x, d)

                if (res != null)
                {
                    res.add(y)
                    return res
                }
            }
        }

        return null
    }
    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>?
    {
        //throw NotImplementedError("Not implemented")

        if (number < 0)
        {
            return null
        }

        val longNumber = number.toLong()
        val decomposeArr: MutableList<Long>? = dec(longNumber, longNumber * longNumber)

        if (decomposeArr != null)
        {
            val result = mutableListOf<Int>()
            decomposeArr.remove(decomposeArr.last())

            decomposeArr.forEach{ result.add(it.toInt()) }

            return result.toTypedArray()
        }

        return null
    }
}
