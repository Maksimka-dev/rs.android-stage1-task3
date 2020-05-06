package subtask3

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int
    {
        val number: Array<Int> = itemsFromArray.filterIsInstance<Int>().toTypedArray()

        if (number.size == 0)
        {
            return 0
        }

        number.sortByDescending { Math.abs(it) }

        var res = 1
        var lNeg = 0
        var lPos = 0
        for(i in 1..number.size)
        {
            val this_is = number[i-1]
            if( i > numberOfItems )
            {
                if(res < 0)
                {
                    var nextPos = 0
                    var nextNeg = 0
                    for(j in i..number.size)
                    {
                        val nextNumb = number[j - 1]
                        if(nextNumb < 0)
                        {
                            if(nextNeg == 0)
                            {
                                nextNeg = nextNumb
                            }
                        }
                        else
                        {
                            if(nextPos == 0)
                            {
                                nextPos = nextNumb
                            }
                        }
                    }

                    if( lPos * nextPos > lNeg * nextNeg )
                    {
                        res = res / lNeg * nextPos
                    } 
                    else
                    {
                        res = res / lPos * nextNeg
                    }
                }
                return res
            }

            if(this_is < 0)
            {
                lNeg = this_is
            } else
            {
                lPos = this_is
            }

            res = res * this_is
        }
        return res
    }
}
