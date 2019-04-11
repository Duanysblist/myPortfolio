import java.util.ArrayList;
import java.util.List;
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0){
            nums1 = nums1;
        }
        else{

    List<Integer> theArray = new ArrayList<>();//make an array list because it's easier to manipulate
    
    int[] newNums1 = new int[nums1.length - n];
    
    for(int z = 0; z < newNums1.length; z++){
        newNums1[z] = nums1[z];
    }

    int j = 0; //counter for the second array
    int  i = 0; //counter for the first array

    int currentSize = theArray.size(); //get the actualy size of the array currently (at the beginning of the program, it's zero).
        
    int newArraySize = newNums1.length + nums2.length; //gets the length of the array that we want
    
    //As long as we haven't met our desired amount of items in our array, i is less than the length of the first array, and j is less than the length of the second array, then continue. Keeping i and j less than the length of their respective arrays is important because we don't want it checking in non-existant indexes and giving us an Out Of Bounds exception.
    for(int  k = 0; k < newArraySize && i < newNums1.length && j < nums2.length; k++){
        if(newNums1[i] < nums2[j]){  //the counters help compare the respective current values
        theArray.add(newNums1[i]);
        i++;
        currentSize++;//keep increasing current size of the array to use later
      } else if(newNums1[i] > nums2[j]){
        theArray.add(nums2[j]);
        j++;
        currentSize++;
      }else if(newNums1[i] == nums2[j]){ //they are the same value, so they should be placed next to each other
        theArray.add(newNums1[i]);
        theArray.add(nums2[j]);
        i++;
        j++;
        currentSize += 2;
      }
    }

    //The above array is only good for the shortest array. After that, there will be a problem. So make another for loop to use the current size of the array and compare it against how many values we actually need in the array to meet our goal. The conditionals inside while check which array is longer and add the remaining values from that array into our new array. If they are both the same length, it will find which ending value of each array is larger, and then add that to the new array. This is because one of the arrays is going to hit the end of it's values before the other. 

      for(int d = currentSize; d < newArraySize; d++){
        if(newNums1.length != i){
          theArray.add(newNums1[i]);
          i++;
        }else if(nums2.length != j){
          theArray.add(nums2[j]);
          j++;
        }else if(newNums1.length == nums2.length){
            while(newNums1.length > i || nums2.length > j){
          if(newNums1[newNums1.length - 1] > nums2[nums2.length -1]){
            theArray.add(newNums1[i]);
              i++;
          }else if(newNums1[newNums1.length - 1] < nums2[nums2.length -1]){
            theArray.add(nums2[j]);
              j++;
          }
                }
        }
      }
     

   Object[] almostFinalArray = theArray.toArray();//changing the ArrayList to an array
    int[] finalArray = new int[almostFinalArray.length];
    for(int h = 0; h < almostFinalArray.length; h++){
        finalArray[h] = (int)almostFinalArray[h];
    }
        
        for(int g = 0; g < nums1.length; g++){
            nums1[g] = finalArray[g];
        }

  }      
    }
}

