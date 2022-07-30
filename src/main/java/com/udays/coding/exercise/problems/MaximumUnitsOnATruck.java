package com.udays.coding.exercise.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 1710
 * Problem statement:
 * You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 *
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 *
 * Return the maximum total number of units that can be put on the truck.
 *
 *
 *
 * Example 1:
 *
 * Input: boxTypes = [[1,3],[2,2],[3,1]], truckSize = 4
 * Output: 8
 * Explanation: There are:
 * - 1 box of the first type that contains 3 units.
 * - 2 boxes of the second type that contain 2 units each.
 * - 3 boxes of the third type that contain 1 unit each.
 * You can take all the boxes of the first and second types, and one box of the third type.
 * The total number of units will be = (1 * 3) + (2 * 2) + (1 * 1) = 8.
 * Example 2:
 *
 * Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
 * Output: 91
 *
 *
 * Constraints:
 *
 * 1 <= boxTypes.length <= 1000
 * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
 * 1 <= truckSize <= 106
 */

public class MaximumUnitsOnATruck {

    //Time complexity: O(NlogN) due to sorting
    //Space complexity: O(logN) as arrays.sort uses quicksort, O(1) auxiliary space if sorting algo is heapsort,

    public int maximumUnits(int[][] boxTypes, int truckSize) {

        //boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]
        //box[numberOfBoxes][noOfUnitsPerBox]
        //sort the boxes, descending noOfUnitsPerBox,
        //if same noOfUnitsPerBox, then descending numberOfBoxes
        Arrays.sort(boxTypes, (a, b)-> (a[1]==b[1]) ? b[0]-a[0] : b[1]-a[1] );

        int units = 0;

        for(int[] box: boxTypes){
            //no of boxes
            int noOfBoxes = box[0];
            //truckSize = max no of boxes
            //if no of boxes is greater than trucksize, truck will fit all boxes of this type
            if(noOfBoxes>truckSize)
                noOfBoxes = truckSize;

            //units=no of boxes * units per box
            units += noOfBoxes*box[1];
            //truck filled with this many no of boxes, so reduce truck size
            truckSize -= noOfBoxes;

            //if truck is full, break
            if(truckSize==0)
                break;
        }

        return units;

    }

}
