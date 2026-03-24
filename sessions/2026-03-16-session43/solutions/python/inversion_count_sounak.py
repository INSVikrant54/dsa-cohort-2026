class Solution:
    
    count = 0
    
    def countI(self, arr, s, mid, e):
        i = s
        j = mid + 1
        
        while i <= mid and j <= e:
            if arr[i] > arr[j] and i < j:
                self.count += 1
                self.count += (mid - i)
                j += 1
            else:
                i += 1
        
    def mergeL(self, arr, s, mid, e):
        i = s
        j = mid + 1
        temp = []
        
        
        while i <= mid and j <= e:
            if arr[i] <= arr[j]:
                temp.append(arr[i])
                i += 1
            else:
                temp.append(arr[j])
                j += 1
                
        
        while i <= mid:
            temp.append(arr[i])
            i += 1
            
        while j <= e:
            temp.append(arr[j])
            j += 1
            
        for i in range(len(temp)):
            arr[i+s] = temp[i]
                
        
        
    def sortandm(self, arr, s , e):
        if s == e:
            return
        
        mid = (s+e)//2
        
        self.sortandm(arr ,s, mid)
        self.sortandm(arr ,mid+1, e)
        self.countI(arr, s, mid, e)
        self.mergeL(arr, s, mid, e)
        
    
    def inversionCount(self, arr):
        # Code Here
        
        lenn = len(arr)
        strt = 0
        end = lenn - 1
        
        self.sortandm(arr, strt, end)
        
        return self.count
        
        
        
        