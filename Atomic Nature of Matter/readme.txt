/* *****************************************************************************
 *  Name: Roshan
 *  NetID:
 *  Precept:
 *
 *  Partner Name:
 *  Partner NetID:
 *  Partner Precept:
 **************************************************************************** */

Final Programming Project: Atomic Nature of Matter

/**********************************************************************
 * Approximate number of hours to complete this assignment            *
 **********************************************************************/

Number of hours: 5


/**************************************************************************
 *  The input size n for BeadTracker is the product of the number of      *
 *  pixels per frame and the number of frames. What is the estimated      *
 *  running time (in seconds) of BeadTracker as a function of n?          *
 *  Justify your answer with empirical data and explain how you used it.  *
 *  Your answer should be of the form a*n^b where b is an integer.        *
 **************************************************************************/

I tested the code, here is the time for it.
Frames: 20, n: 6,144,000, Time: 0.753 seconds
Frames: 50, n: 15,360,000, Time: 1.537 seconds
Frames: 75, n: 23,040,000, Time: 2.116 seconds
Frames: 100, n: 30,720,000, Time: 2.611 seconds
Frames: 150, n: 46,080,000, Time: 3.846 seconds
Frames: 100, n: 60,144,000, Time: 4.989 seconds

I compared the ratios between input sizes and time. The linear time increases nearly linearly with n. For example, from 20 to 50 frames, n increases to almost 2.5 times and time increases almost 2 times. Now from 100 to 200 frames, n and time both almost increases 2 times.

As linear relationship, estimated time is
T(n) = a * n^1.

/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

NO



/**************************************************************************
 *  List any other comments here.                                         *
 **************************************************************************/
