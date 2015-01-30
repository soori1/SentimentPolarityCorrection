package sentimentpolaritycorrection;
/*
 * @(#)SentenceNode.java
 *
 *
 * @ Author: Eric Kang Sang Jun and Sylvester Olubolu Orimaye, PhD
 * Monash University

 *
 * This class is to create a node for the construction of linked list when reading in the text file input.
 * This class is tested with NodeItemTestClass class. 
 *
 */


public class SentenceNode 
{
	private int sentenceID;					// A int variable to store the value of the comment line number.
	private String sentencePolarity;				// A String variable to store whether it is a "pos" or "neg" (positive or negetaive comment)
	private String sentence;                                // The actual sentence 
	
	// A dafault constructor to instantiate a default SentenceNode object.
	//  Pre-condition: None.
    // Post-condition: A SentenceNode object is instantiated.
    public SentenceNode() 
    {
    	sentenceID = 0;
    	sentencePolarity = "";
        sentence = "";
    }
    
    
    // A constructor with specific number and content.
   	//  Pre-condition: None.
    // Post-condition: A SentenceNode object with specific instance variable values is instantiated.
    public SentenceNode(int sentenceID, String sentencePolarity, String sentence)
    {
    	this.sentenceID = sentenceID;
    	this.sentencePolarity = sentencePolarity;
        this.sentence = sentence;
    }
    
    
    // This mutator method sets a new number for the node.
    //  Pre-condition: There is a SentenceNode object to process.
    // Post-condition: The int value of sentenceID instance variable is modified with a new value.
    public void setID(int sentenceID)
    {
    	this.sentenceID = sentenceID;
    }
    
    
    // This mutator method sets a new content for the node.
    //  Pre-condition: There is a SentenceNode object to process.
    // Post-condition: The String value of sentencePolarity instance variable is modified with a new value.
	public void setPolarity(String sentencePolarity)
    {
    	this.sentencePolarity = sentencePolarity;
    }
    
        
    public void setSentence(String sentence){
        this.sentence = sentence;
    }
    
    
    // This accessor method gets the number for that node.
    //  Pre-condition: There is a SentenceNode object to process.
    // Post-condition: The int value of sentenceID instance variable is returned to the caller method.
    public int getID()
    {
    	return sentenceID;
    }
    
    
    // This accessor method gets the content for that node.
    //  Pre-condition: There is a SentenceNode object to process.
    // Post-condition: The String value of sentencePolarity instance variable is returned to the caller method.
	public String getPolarity()
    {
    	return sentencePolarity;
    }
    
        
    public String getSentence(){
        return sentence;
    }
    
    // This method resets a given node to its default value.
    //  Pre-condition: There is a SentenceNode object to process.
    // Post-condition: The instance variables of a SentenceNode object is reset to the stated values.
    public void resetNode()
    {
		sentenceID = 0;
		sentencePolarity = "";
                sentence = "";
    }
    
    
    // This method changes the way a SentenceNode object is printed onto the screen.
    //  Pre-condition: There is a SentenceNode object to print. It will print the elements of the node if not null.
    // Post-condition: The instance variables of a SentenceNode object is printed onto the screen.
    public String toString()
    {
    	return sentenceID + " " + sentencePolarity + " " + sentence;
    }
}
