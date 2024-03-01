package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * O(n) time complexity
 * O(n) space complexity
 */
public class TwoSum {
  public int[] getTwoSumIndexes(int[] numbers, int target) {
    Map<Integer, Integer> numberToIndex = new HashMap<>();

    for (int i = 0; i < numbers.length; i++) {
      if (!numberToIndex.containsKey(numbers[i])) {
        numberToIndex.put(numbers[i], i);
      }
      else {
        return new int[] {numberToIndex.get(numbers[i]), i};
      }
    }
    return new int[0];
  }


  /**
   * O(n) time complexity
   * O(1) space complexity
   */
  public int[] getTwoSumIndexes2(int[] numbers, int target) {
    // sliding window
    int left = 0;
    int right = numbers.length - 1;

    while (left < right) {
      int sum = numbers[left] + numbers[right];
      if (sum == target) {
        return new int[] {left, right};
      }
      else if (sum < target) {
        left++;
      }
      else {
        right--;
      }
    }
    return new int[0];
  }
}
