
/*
 * GDG El Paso Github Workshop
 * Purpose: To practice insertion sort and merge sort using arrays
 * Last Modified: 17 April 2019
 */

public class Runner1 {
  public static void main(String[] args) {
    // Demonstrate the code works by generating a random list of 20 boxes, printing the list before AND sorting using via insertion and merge sort.
    int numOfBoxes = 20;

    Box firstArray[] = arrayOfBoxes(numOfBoxes); // Create the array
    printArrayOfBoxen(firstArray); // Print the list
    Box copy[] = copyArray(firstArray); // Copy the array
    Box iSort[] = insertionSort(copy); // Sort via insertion sort

    // Verify insetionSort is working
    int i = 0;
    System.out.println();
    System.out.println("After Insertion Sort:");
    while (i < numOfBoxes) {
      System.out.println("The length, width, & height of Box #" + (i + 1) + " are " + (int) iSort[i].length + ", "
          + (int) iSort[i].width + ", " + (int) iSort[i].height + ", with a volume of "
          + (int) iSort[i].calculateVolume());
      i++;
    }

    printArrayOfBoxen(firstArray); // Print the list again
    Box mSort[] = mergeSort(copy); // Implement merge sort

    // Verify mergeSort is working
    int j = 0; // You're in main; int i was already used
    System.out.println();
    System.out.println("After Megre Sort:");
    while (j < numOfBoxes) {
      System.out.println("The length, width, & height of Box #" + (j + 1) + " are " + (int) mSort[j].length + ", "
          + (int) mSort[j].width + ", " + (int) mSort[j].height + ", with a volume of "
          + (int) mSort[j].calculateVolume());
      j++;
    }

  }

  /**
   * Generate a random list of boxes for testing. Method should take in (20) the
   * size of the list and return an array of that many boxes
   */
  public static Box[] arrayOfBoxes(int numOfBoxes) {

    // Your Code here

    return null;
  }

  /**
   * Print the array of boxes. Each line should be the l,w,h && v of a specific box
   */
  public static void printArrayOfBoxen(Box[] firstArray) {

    // Your Code here
  }

  /** Create a new array of boxes with identical values of the given one */
  public static Box[] copyArray(Box[] firstArray) {
    Box[] boxCopy = new Box[firstArray.length];
    int i = 0;
    while (i < boxCopy.length) { /// Only less than, NOT EQUALS; otherwise nullPointerException error
      boxCopy[i] = new Box(); // Iniatiate the boxes
      boxCopy[i].length = (int) (firstArray[i].length); // set them equal to ints
      boxCopy[i].width = (int) (firstArray[i].width);
      boxCopy[i].height = (int) (firstArray[i].height);
      i++; // increment/traverse as you go along
    }
    return boxCopy;
  }

  /** Sort the boxes using the insertion sort algorithm */
  public static Box[] insertionSort(Box[] copy) {

    // Your Code Here

    return copy;
  }

  /** Sort the boxes using the merge sort algorithm */
  /** 1st half of the merge sort algorithm */
  public static Box[] mergeSort(Box[] arrayCopy) {
    if (arrayCopy.length <= 1) // Base case; if 1, array is sorted by default
      return arrayCopy;

    Box[] leftHalf = new Box[arrayCopy.length / 2]; // left side will be 1st (1/2) of array |\/ 1/2 via each iteration
                                                    // |\/ use center as random split
    Box[] rightHalf = new Box[arrayCopy.length - leftHalf.length]; // right side will be 2nd (1/2) of array |\/ 1/2 via
                                                                   // each iteration

    System.arraycopy(arrayCopy, 0, leftHalf, 0, leftHalf.length); // copies leftHalf.length-elements of arrayCopy to the
                                                                  // new leftHalf array
    System.arraycopy(arrayCopy, leftHalf.length, rightHalf, 0, rightHalf.length); // copies rightHalf.length-elements of
                                                                                  // arrayCopy to the leftHalf array

    mergeSort(leftHalf); // recursive calls
    mergeSort(rightHalf);

    merge(leftHalf, rightHalf, arrayCopy); // call a second merge method to combine everything togetheer

    return arrayCopy;
  }

  /** 2nd half of the merge-sort algorithm */
  private static Box[] merge(Box[] leftHalf, Box[] rightHalf, Box[] modifiedCopy) {

    int leftCounter = 0, rightCounter = 0; // to traverse through each array

    int i = 0; // genral counter

    while (leftCounter < leftHalf.length && rightCounter < rightHalf.length) { // positional; e.g. if i<n |\/ minus the
                                                                               // "i" and ALL ACTUAL NUMBERS!! -_-
      if (leftHalf[leftCounter].calculateVolume() < rightHalf[rightCounter].calculateVolume()) {
        modifiedCopy[i] = leftHalf[leftCounter]; // lesser volume boxes to the left
        leftCounter++;
      } else {
        modifiedCopy[i] = rightHalf[rightCounter]; // greater volume boxes to the right
        rightCounter++; // keep traversing
      }
      i++;
    }
    return modifiedCopy;
  }
}
