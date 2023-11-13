def hasSingleCycle(array)
    if (array[0] == 0)
        return False
    
    ind = 0
    count = 0
    ln = len(array)
    
    while True
        count += 1
        ind = (ind + array[ind]) % ln

        if (ind == 0)  (count  ln)
            break
        
    return count == ln