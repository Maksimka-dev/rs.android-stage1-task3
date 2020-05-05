package subtask1

class PolynomialConverter {

    // TODO: Complete the following function
    fun convertToStringFrom(numbers: Array<Int>): String? {
        //throw NotImplementedError("Not implemented")
        var resultStr: String? = ""

        if (numbers.isEmpty())
        {
            resultStr = null
        }
        else
        {
            for (i in numbers.indices)
            {
                if (numbers[i] == 0)
                {

                }
                else
                {
                    if (i == numbers.size - 1)
                    {
                        if (numbers[i] < 0)
                        {
                            resultStr = "$resultStr - ${numbers[i]}"
                        } else
                        {
                            resultStr = "$resultStr + ${numbers[i]}"
                        }
                    }

                    else if (i == numbers.size - 2)
                    {
                        if (numbers[i] < 0)
                        {
                            if (numbers[i] == -1)
                            {
                                resultStr = "$resultStr - x"
                            }
                            else
                            {
                                resultStr = "$resultStr - ${numbers[i] * -1}x"
                            }

                        } else
                        {
                            if (numbers[i] == 1)
                            {
                                resultStr = "$resultStr + x"
                            }
                            else
                            {
                                resultStr = "$resultStr + ${numbers[i]}x"
                            }

                        }
                    }

                    else if (i == 0)
                    {
                        resultStr = "${numbers[i]}x^${numbers.size - i -1}"
                    }
                    else
                    {
                        if (numbers[i] < 0)
                        {
                            resultStr = "$resultStr - ${numbers[i] * -1}x^${numbers.size - i -1}"
                        }
                        else
                        {
                            resultStr = "$resultStr + ${numbers[i]}x^${numbers.size - i -1}"
                        }

                    }
                }
            }
        }

        return resultStr
    }
}
