/***************************
 *  Name:   Roshan
 *  NetID:
 *  Precept:
 **************************/

Programming Assignment 4: Hamming Codes

OS: MacOS
Text editor:
Hours to complete assignment (optional):



/************************
 *  Which simulator did you use to develop your TOY programs?
 *  TOY.java or Visual X-TOY 7.1 (the toy.jar)?
 ************************/
TOY.java

/************************
 *  Describe what, if anything, you use each of the registers for
 *  in encode.toy.
 ************************/
R[1]: loop counter
R[2]: not used
R[3]: not used
R[4]: not used
R[5]: not used
R[6]: not used
R[7]: for address offset
R[8]: not used
R[9]: final output byte
R[A]: input character for encoding
R[B]: B bit of data
R[C]: C bit of data
R[D]: D bit of data
R[E]: parity and calculated bits
R[F]: parity and calculated bits


/************************
 *  Describe what, if anything, you use each of the registers for
 *  in decode.toy.
 ************************/
R[1]: input character for decoding
R[2]: original data bit 2
R[3]: original data bit 3
R[4]: original data bit 4
R[5]: original data bit 5
R[6]: original data bit 6
R[7]: original data bit 7
R[8]: not used
R[9]: not used
R[A]: calculated parity
R[B]: calculated parity
R[C]: calculated parity
R[D]: error correction
R[E]: error correction
R[F]: error correction


/************************
 *  Did you receive help from classmates, past COS 126 students, or
 *  anyone else? If so, please list their names.  ("A Sunday lab TA"
 *  or "Office hours on Thursday" is ok if you don't know their name.)
 ************************/

Yes or no?

/************************
 *  Did you encounter any serious problems? If so, please describe.
 ************************/

Yes or no?

I just need to learn about assembly TOY code in detail for solving it, everything else was fine. 

The assignment helped me improve my bitwise operations and I learned a lot about hamming codes.

/************************
 *  List any other comments here.
 ************************/