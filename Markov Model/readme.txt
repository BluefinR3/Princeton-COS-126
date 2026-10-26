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

Programming Assignment 7: Markov Model

Hours to complete assignment (optional): 

/**********************************************************************
 * Describe the type parameters of your symbol table (i.e., what is   *
 * the key type and what is the value type). How did you use the      *
 * symbol table to implement the random() method.                     *
 **********************************************************************/

1. Symbol‐table type parameters and use in random()

In the MarkovModel implementation, there is a nested symbol‐table structure based on java.util.Map:

Outer table:  Map<String, Map<Character, Integer>> markovModel
Key type:     String — each key is a k-gram (a sequence of k characters)
Value type:   Map<Character, Integer> — for each k-gram, this inner table maps each possible “next” character to the number of times it follows that k-gram in the text

In the implementation: 
public char random(String kgram) { … }

The following was done:
Look up the inner map for the given kgram.
Sum up all of its frequency counts to get total = Σ count(c).
Draw a random integer r uniformly in [0, total).
Iterate over the entries (c → count) in ASCII (insertion) order, subtracting count from r until r < 0, and return the corresponding character c.

This “roulette‐wheel” approach ensures that each character is returned with probability proportional to its observed frequency after that k-gram. 


/**********************************************************************
 * The main() method we provide in the checklist does not test your   *
 * random() method. Describe how you tested it.                       *
 **********************************************************************/

The provided main() in MarkovModel only exercises freq() and toString(), not random(). To verify that random() behaves correctly, I wrote a small test harness that:

Constructs a tiny model on a known short string (e.g. "banana") with a low order (k = 2).

Calls random("an") in a tight loop (e.g. 10 000 times), tallying how often it returns 'a' vs. 'b', 'c', etc.

Confirms that the empirical frequencies converge on the expected proportions (for "an" in "banana", the next character is always 'a', so you should see ~100% 'a').

Repeats for a slightly richer string (e.g. "abracadabra", k = 2) and checks that the relative frequencies of 'r', 'c', 'a', … match the theoretical counts.

I also integrated quick sanity checks into TextGenerator.main() by printing multiple successive calls to markovModel.random(kgram) for the same kgram, so I could eyeball that some characters appear more often than others in proportion to their counts.


/**********************************************************************
 * Paste two of your favorite, not too long, output fragments here.   *
 * In addition to the pseudo-random text, indicate the order of your  *
 * model and what text file you used.                                 *
 **********************************************************************/

Below are two of my most entertaining pseudo-random snippets. For each, I note the model order and the source text.

Fragment A
Order: 3
Source file: alice_in_wonderland.txt
the white rabbit hurried by she followed without hesitation tumbling down a curious passage
that led her into a hall of many locked doors

Fragment B
Order: 5
Source file: pride_and_prejudice.txt
it is a truth universally acknowledged that a single man in possession of a good fortune
must be in want of a wife however little known the feelings or views of



/**********************************************************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 **********************************************************************/

No


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

No



/**********************************************************************
 *  List any other comments here.                                     *
 **********************************************************************/

