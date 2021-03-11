//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: SupportTicket
// Files:
// Course: CS 300, spring, and 2019
//
// Author: Sheriff Issaka
// Email: issaka@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (name of your pair programming partner)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * @author Sheriff
 *
 */
public class SupportTicket implements Comparable<SupportTicket> {
  // creates a string to be used below
  String str;

  /**
   * @param str initializes string creates a new support ticket
   */
  public SupportTicket(String str) {
    // if str is empty, throw an exception
    if (str == null) {
      throw new NullPointerException();
    } else {
      // else initialize str with given input
      this.str = str;
    }
  }

  /**
   * @param SupportTicket compares given support tickets
   */
  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(SupportTicket o) {
    // compares given support tickets
    if (this.str.length() == o.str.length()) {
      // compares the content if the length is the same
      return this.toString().compareTo(o.toString());
    } else {
      // returns the difference in length if length isn't equal
      return this.str.length() - o.str.length();
    }
  }

  @Override
  public String toString() {
    // returns the instance string value
    return str;
  }

}
