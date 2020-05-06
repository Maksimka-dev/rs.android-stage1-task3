package subtask6

class FullBinaryTrees {

    inner class nodeTree
    {
        var source = 0
        var left: nodeTree? = null
        var right: nodeTree? = null
    }

    fun createTrees(n: Int): ArrayList<nodeTree>
    {
        if(n % 2 == 0)
        {
            return ArrayList()
        }
        if(n == 1)
        {
            return arrayListOf(nodeTree())
        }
        val result = ArrayList<nodeTree>()
        for(i in 1..(n-1) step 2)
        {
            val left = createTrees(i)
            val right = createTrees(n - 1 - i)
            for(ln in left)
            {
                for(rn in right)
                {
                    val Tree_root = nodeTree()
                    Tree_root.left = ln
                    Tree_root.right = rn
                    Tree_root.source = maxOf(ln.source, rn.source) + 1
                    result.add(Tree_root)
                }

            }
        }
        return result
    }

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String
    {
        //throw NotImplementedError("Not implemented")
        val r = createTrees(count)
        //println("Count is ${r.size}")
        val result = ArrayList<ArrayList<Int?>>()
        for(n in r)
        {
            val res = ArrayList<Int?>()
            res.add(0)
            val maxd = n.source
            val child = ArrayList<nodeTree?>()
            child.add(n.left)
            child.add(n.right)
            var currentLevel = 0
            while(child.isNotEmpty())
            {
                val newChildren = ArrayList<nodeTree?>()
                for(c in child)
                {
                    if(c == null)
                    {
                        if(currentLevel != maxd) res.add(null)
                    }
                    else
                    {
                        res.add(0)
                        newChildren.add(c.left)
                        newChildren.add(c.right)
                    }
                }
                child.clear()
                child.addAll(newChildren)
                newChildren.clear()
                currentLevel++
            }
            while (res[res.size - 1] == null)
            {
                res.removeAt(res.size - 1)
            }
            result.add(res)
        }
        return result.toString()

    }
}
