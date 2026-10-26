/* *****************************************************************************
 *  Name: Roshan
 *  NetID:
 *  Precept:
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 **************************************************************************** */

Which partner is submitting the program files?

Programming Assignment 8: Traveling Salesperson Problem

Hours to complete assignment (optional):


/**********************************************************************
 *  Explain how you implemented the nearest insertion heuristic.      *
 **********************************************************************/
The insertNearest(Point p) method follows these steps:
. If the tour is empty, a new node with point p is created, points to itself (circular), and becomes the root.
. If the tour is not empty:
. It iterates through the tour to find the node with the shortest Euclidean distance to p.
. A new node with point p is inserted after the nearest node found.
. The list remains circular by adjusting the next pointers accordingly.

This builds a tour by always inserting the next point next to its nearest neighbor in the current tour.


/**********************************************************************
 *  Explain how you implemented the smallest insertion heuristic.     *
 *  It's sufficient to list only the differences between this         *
 *  heuristic and the nearest insertion heuristic.                    *
 **********************************************************************/

The insertSmallest(Point p) method is similar in structure but differs in logic:
.  Instead of finding the closest existing point to p, it finds the edge where inserting p causes the smallest increase in the total tour length.

. It evaluates all edges by computing:
increase = dist(curr.p, p) + dist(p, curr.next.p) - dist(curr.p, curr.next.p)

. It then inserts p between curr and curr.next where this increase is minimal.

Key difference:
. Nearest insertion: looks at distance to single points.
. Smallest insertion: looks at added cost to insert between two nodes (edges).

/**********************************************************************
 *  Explain why it's better to use a circularly linked list instead   *
 *  of an array.                                                      *
 **********************************************************************/

1. Efficient insertion: Inserting a point between two nodes requires only updating a few pointers (O(1)), whereas arrays would require shifting elements (O(n)).

2. Natural tour structure: Tours are cycles. A circular list naturally supports wrapping from last back to first node.

3. Dynamic size: Arrays have fixed sizes or need resizing; linked lists grow dynamically without overhead.

/**********************************************************************
 *  Fill in the lengths computed by your heuristics.                  *
 **********************************************************************/

data file      nearest neighbor     smallest increase
-----------------------------------------------------
tsp10.txt         1566.1363             1655.7462
tsp100.txt   	  7389.9297		4887.2190
tsp1000.txt	  27868.7106		17265.6282
usa13509.txt	  77449.9794		45074.7769

/**********************************************************************
 *  Do two timing analyses. Estimate the running time (in seconds)    *
 *  of each heuristic as a function of n, using expressions of the    *
 *  form: a * n^b, where b is an integer.                             *
 *                                                                    *
 *  Explain how you determined each of your answers.                  *
 *                                                                    *
 *  To get your data points, run the two heuristics for n = 1,000,    *
 *  and repeatedly double n until the execution time exceeds 60       *
 *  seconds.                                                          *
 *                                                                    *
 *  You may use TSPTimer to help do this, as per the checklist.       *
 *  If you do so, execute it with the -Xint option. This turns off    *
 *  various compiler optimizations, which helps normalize and         *
 *  stabilize the timing data that you collect.                       *
 *                                                                    *
 *  (If n = 1,000 takes over 60 seconds, your code is too slow.       *
 *  See the checklist for a suggestion on how to fix it.)             *
 **********************************************************************/

For the timing analysis:

Use TSPTimer with -Xint as suggested.

Record times for increasing values of n (e.g., 1000, 2000, 4000, …) until runtime > 60s.

Plot or log values and fit them to a function a * n^b.

Expected time complexities:

Both heuristics use an O(n) loop inside each of the n insertions → O(n²) total.

So, time should scale roughly with n².


n               nearest time           smallest time
------------------------------------------------------------
1000		0.010 seconds		0.014 seconds
2000		0.016 seconds		0.015 seconds
5000		0.064 seconds		0.096 seconds
10000		0.277 seconds		0.363 seconds
100000		55.36 seconds		55.258 seconds
200000		603.049 seconds		208.642 seconds


/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

Yes or no?

No


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no?

No


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

