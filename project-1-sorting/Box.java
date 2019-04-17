
/*
 * GDG El Paso Github Workshop
 * Purpose: To practice insertion sort and merge sort using arrays
 * Last Modified: 17 April 2019
 */

public class Box {

  public double length;
  public double width;
  public double height;
  public double volume;

  public Box(double box_length, double box_width, double box_height) {
    length = box_length;
    width = box_width;
    height = box_height;
    volume = box_length * box_width * box_height;
  }

  public Box() {
  }

  public double calculateVolume() {
    return (length * width * height);
  }
}
