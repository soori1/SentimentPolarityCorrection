package sentimentpolaritycorrection;
/**
 * @(#)BSTNode.java
 *
 *
 * @ Author: Eric Kang Sang Jun and Sylvester Olubolu Orimaye, PhD
 * Monash University
 *
 * This class is to create a BST node specifically for the construction of Binary Search Tree.
 * Note that BSTNode is slightly different from NodeItem, in a way that BSTNode contains 2 additional left and right branch objects. 
 * (That is, BSTNode left & BSTNode right)
 *
 */


public class BSTNode 
{
	private BSTNode left;				// A BSTNode object for left-hand side of a given node.
	private BSTNode right;				// A BSTNode object for right-hand side of a given node.			
	private int sentenceID;			// A int variable to store the value of the comment number.
	private String sentencePolarity;		// A String variable to store whether it is "pos" or "neg" (positive or negetive comment)
        private String sentence;                    // Stores the actual sentence.


	// A default constructor to create a BSTNode object.
	//  Pre-condition: None.
    // Post-condition: A BSTNode object is instantiated.
    public BSTNode() 
    {
    	left = null;
    	right = null;
    	sentenceID = 0;;
        sentencePolarity= "";
        sentence = "";
    }
    
    
    // A constructor to create a BSTNode object with specific values.
    //  Pre-condition: None.
    // Post-condition: A BSTNode object with specific instance variable values is instantiated.
    public BSTNode(int sentenceID, String sentencePolarity, String sentence) 
    {
    	left = null;
    	right = null;
    	this.sentenceID = sentenceID;
	this.sentencePolarity = sentencePolarity;
        this.sentence = sentence;
    } 
    
    
    // A mutator method to set the left node of a current BSTNode.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The left BSTNode of a current BSTNode is set.
    public void setLeft(BSTNode leftNode)
    {
        this.left = leftNode;
    }
     
     
    // A mutator method to set the right node of a current BSTNode.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The right BSTNode of a current BSTNode is set.
    public void setRight(BSTNode rightNode)
    {
        this.right = rightNode;
    }
    
    
    // This mutator method sets the sentenceID for that node.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The sentenceID instance variable is modified with a new int value.
    public void setBSTNodeID(int sentenceID)
    {
    	this.sentenceID = sentenceID;
    }
    
    
    // This method sets the polarity for that node.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The sentencePolarity instance variable is modified with a new String value.
    public void setBSTNodePolarity(String sentencePolarity)
    {
    	this.sentencePolarity = sentencePolarity;
    }
  
  
    // This method sets the actual sentence for that node.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The sentencePolarity instance variable is modified with a new String value.
    public void setBSTNodeSentence(String sentence)
    {
    	this.sentence = sentence;
    }
    
    
    // An accessor method to retrieve the left BSTNode object.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The left BSTNode object from the current BSTNode object is returned.
    public BSTNode getLeft()
    {
    	return this.left;
    }  
    
    
    // An accessor method to retrieve the right BSTNode object.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The right BSTNode object from the current BSTNode object is returned.
    public BSTNode getRight()
    {
    	return this.right;
    }
    
    
    // This accessor method retrieves the value of the sentenceID stored in that node.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The int value of sentenceID instance variable is returned to the caller method.
    public int getBSTNodeID()
    {
    	return this.sentenceID;
    }
    
    
    // This accessor method retrieves the polarity stored in that node.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: The String value of sentencePolarity instance variable is returned to the caller method.
    public String getBSTNodePolarity()
    {
    	return this.sentencePolarity;
    }
    
    
    // This accessor method retrieves the sentence stored in that node.
    // Pre-condition: There is a BSTNode object to process.
    // Post-condition: The String value of sentencePolarity instance variable is returned to the caller method.
    
    public String getBSTNodeSentence()
    {
    	return this.sentence;
    }
    
    // This method returns true if the node has a right node, and false otherwise.
    // Pre-condition: There is a BSTNode object to process.
    // Post-condition: It returns true if there is a right BSTNode from the current BSTNode, and false otherwise to the caller method.
    public boolean hasRight()
    {
    	return this.right != null;
    }
    
    
        
    // This method returns true if the node has a left node, and false otherwise.
    //  Pre-condition: There is a BSTNode object to process.
    // Post-condition: It returns true if there is a left BSTNode from the current BSTNode, and false otherwise to the caller method.
    public boolean hasLeft()
    {
    	return this.left != null;
    }
    
    
    // This methods changes the representation format of the object.
    //  Pre-condition: There is a BSTNode object to print. It will print the elements of the node if not null.
    // Post-condition: The instance variables of a BSTNode object is printed onto the screen.
    public String toString()
    {
    	return "" + sentenceID + " " + sentencePolarity + " " + sentence;
    }
}