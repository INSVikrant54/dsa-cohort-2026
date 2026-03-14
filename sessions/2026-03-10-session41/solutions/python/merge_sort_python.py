class Solution:
    def mergeSorted(self, arr, l,mid, r):
        temp = []
        right = mid+1
        left = l
        
        while left <= mid and right <= r:
            if arr[left] <= arr[right]:
                temp.append(arr[left])
                left += 1
            else:
                temp.append(arr[right])
                right += 1
        
        while left <= mid:
            temp.append(arr[left])
            left += 1
        
        while right <= r:
            temp.append(arr[right])
            right += 1
            
        
        for i in range(len(temp)):
            arr[i+l] = temp[i]
                
                
    
 
    def mergeSort(self, arr, l, r):
        
        if l == r:
            return
        
        #code here
        mid = (l+r)//2
        
        self.mergeSort(arr, l, mid)
        self.mergeSort(arr, mid+1, r)
        self.mergeSorted(arr, l, mid, r)
        
        