package sentimentpolaritycorrection;
/**
 * @(#)PolarityTree.java
 *
 *
 * @ Author: Eric Kang Sang Jun and Sylvester Olubolu Orimaye, PhD
 * Monash University
 *
 */
 
 
import java.util.LinkedList;


// When the given comment is positive, the branch goes right.
// When the given comment is negative, the branch goes left.
	
public class PolarityTree 
{
    private BSTNode root;					// A BSTNode object which holds the root of a PolarityTree.
    private BSTNode currentNode;			// A BSTNode object which is responsible for the traversal of a PolarityTree. (It acts like a current pointer)
    
    
    // A dafault constructor for creating an empty PolarityTree.
    //  Pre-condition: None.
    // Post-condition: A PolarityTree object is instantiated.
    public PolarityTree()
    {
		root = null;
		currentNode = null;	
    }
    
    
    // This method checks whether the PolarityTree is empty or not.
    //  Pre-condition: None.
    // Post-condition: A PolarityTree object is instantiated.
    public boolean isEmpty()
    {
    	return root == null;
    }
    
    
    // This method inserts a new element into the PolarityTree.
    //  Pre-condition: A PolarityTree is created.
    // Post-condition: A new BSTNode is created and inserted.
    public void insertBSTNode(int sentenceID, String sentencePolarity, String sentence)
    {
    	if(this.isEmpty()) // If the PolarityTree is empty, we add it as the first element.
    	{
    		root = new BSTNode(sentenceID, sentencePolarity,sentence);
    		currentNode = root;
    	}
    	
    	
    	else // Otherwise, we add an element according to the rules below as comments.
    	{
    		// Node going from positive to positive means going to right direction.
    		if(sentencePolarity.equals(currentNode.getBSTNodePolarity()) && currentNode.getBSTNodePolarity().equals("pos"))
    		{
    			currentNode.setRight(new BSTNode(sentenceID, sentencePolarity,sentence));
    			currentNode = currentNode.getRight();
    		}
    		
    		// Node going from negative to positive also means going to right direction.
    		else if(!(sentencePolarity.equals(currentNode.getBSTNodePolarity())) && currentNode.getBSTNodePolarity().equals("neg"))
    		{
    		    currentNode.setRight(new BSTNode(sentenceID, sentencePolarity,sentence));
    			currentNode = currentNode.getRight();	
    		}
    		
    		// Node going from negative to negative means going to left direction.
    		else if((sentencePolarity.equals(currentNode.getBSTNodePolarity())) && currentNode.getBSTNodePolarity().equals("neg"))
    		{
    		    currentNode.setLeft(new BSTNode(sentenceID, sentencePolarity,sentence));
    			currentNode = currentNode.getLeft();	
    		}
	
    		// Node going from positive to negative also means going to left direction.
    		else
    		{
    		    currentNode.setLeft(new BSTNode(sentenceID, sentencePolarity, sentence));
    			currentNode = currentNode.getLeft();
    		}
    	}	
    }
    
    
    
    // This method formats the output representation of a PolarityTree.
    //  Pre-condition: None.
    // Post-condition: A String representation of PolarityTree is printed onto the screen.
    public String toString()
    {
    	BSTNode current = root;
    	String result = "";
    	
    	// If the PolarityTree is null (that is, empty), just return the null value.
    	if(this.isEmpty())
    	{
    		return result;
    	}
    	
    	// Otherwise, the stored elements are printed depending on the branches they have.
    	else
    	{
    		boolean done = false;
	    	
	    	// While there is either right or left node to traverse, we keep on searching.
	    	while(!done)
	    	{
	    		// We store the current information into the String variable which will be returned as a result.	    		
	    		result += current.getBSTNodeID() + " " + current.getBSTNodePolarity() + " " + current.getBSTNodeSentence()+ "\n";
	    		
	    		if(current.hasRight())			// If the current node has a right branch, we go to the right.
	    		{
	    			current = current.getRight();
	    		}
	    		
	    		else if(current.hasLeft())		// If the current node has a left branch, we go to the left.
	    		{
	    			current = current.getLeft();
	    		}
	    		
	    		else							// When we reach the last node, the traversal stops.
	    		{
	    			done = true;
	    		}
	    		
	    	}
	    		
	    	return result;		
    	}
    }
    
    
    
    // This method is the primary method of this class. It finds the consistently recurring comments based on the value of theta.
    // For example, if the theta value is 2, it tries to find those comments that occur in 2 consecutive order.
    //  Pre-condition: None.
    // Post-condition: A String representation of PolarityTree is printed onto the screen.
    public LinkedList<SentenceNode> findConsistentPolarity(int theta)
    {
    	BSTNode startingPrior = null;										// A BSTNode object that is used to set the starting point for the consistent occurence.
    	BSTNode current = root;											// A BSTNode object that is used to keep track of the current node.
    	LinkedList<SentenceNode> resultList = new LinkedList<SentenceNode>();	// A linked list composed of SentenceNode objects previously created to insert those comments that are valid with the theta value.
    	int currentCounter = 1;											// An int variable to keep track of the value of the occurence that has taken place.
    	
    	
    	// If the PolarityTree is empty, there is nothing to search.
    	if(this.isEmpty())
    	{
    		return null;
    	}
    	
    	
    	// Otherwise, we need to perform searching.
    	else
    	{
    		int currentID = 0;					// A int variable to store the current value of the comment.
    		int nextID = 0;						// A int variable to store the next value of the comment.
    		String currentPolarity = "";				// A String variable to store the current commentContent value.
    		String nextPolarity = "";				// A String variable to store the next adjacent commentContent value.
    		boolean done = false;					// A boolean flag value to control the finish of the primary while loop below.
	    	
	    	
	    	// While there is either right or left node to traverse, we keep on searching.
	    	while(!done)
	    	{		    		 
	    		currentID = current.getBSTNodeID();   		
	    		currentPolarity = current.getBSTNodePolarity();
	    		
	    		
	    		// If the starting node is not yet set, we set it from the beginning.
	    		if(startingPrior == null)
	    		{
	    			startingPrior = current;
	    		}
	    		
	    		
	    		// If the current node has a right node, we traverse it.
	    		if(current.hasRight())
	    		{
	    			current = current.getRight();					// We move the current node to the next right node and make that the new current.
	    			nextID = current.getBSTNodeID();		// The value of the next comment number is stored here.
	    			nextPolarity = current.getBSTNodePolarity();		// The value of the next comment content is stored here.
	    			
	    			
	    			// If the previous and the current nodes have the same comments, we increment the counter to compare with the theta value afterwards.
	    			if(currentPolarity.equals(nextPolarity))
	    			{
	    				currentCounter++;				// We increment the value of the current counter to compare with the thea value afterwards.
	    				
	    				// If the last node is reached, we still need to check if the last node is counted following the value of theta.
	    				if(!current.hasLeft() && !current.hasRight())
	    				{
	    					// If the theta value is equal to the counter, we still need to take the last node into consideration.
	    					if(currentCounter == theta)
		    				{
		    					boolean finished = false;
		    					
		    					while(!finished)
		    					{
		    						if(startingPrior != null)
		    						{
		    							resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(), startingPrior.getBSTNodeSentence()));
		    							startingPrior = startingPrior.getRight();
		    						}
		    						
		    						else
		    						{
		    							finished = true;
		    						}
		    					}
		    								
								currentCounter = 1;				// We reset the counter value after the loop.
			    				startingPrior = null;				// We reset the starting point after the loop.
		    				}	
	    				}
	    			}
	    			
	    			
	    			
	    			// If we encounter a different comment, we need to check for the theta value and its consecutive comments.	    			
	    			else
	    			{
	    				// If the theta value is equal to the counter we incremented,
	    				if(currentCounter == theta)
	    				{
	    					boolean finished = false;
	    					String matchingType = startingPrior.getBSTNodePolarity();		// We store the String value to compare with the consistent comment type.
	    					
	    					while(!finished)
	    					{	    						
	    						if(startingPrior.hasRight() && startingPrior.getBSTNodePolarity().equals(matchingType))
	    						{
	    							resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(), startingPrior.getBSTNodeSentence()));
	    							startingPrior = startingPrior.getRight();
	    						}
	    						
	    						else if(startingPrior.hasLeft() && startingPrior.getBSTNodePolarity().equals(matchingType))
	    						{
	    							resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(), startingPrior.getBSTNodeSentence()));
	    							startingPrior = startingPrior.getLeft();
	    						}
	    						
	    						else
	    						{
	    							finished = true;
	    						}
	    					}
		
		    				currentCounter = 1;
		    				startingPrior = null;
	    				}
	    				
	    				
	    				else
	    				{
	    					currentCounter = 1;
		    				startingPrior = null;
	    				}
	    			}
	    		}
	    		
	    		
	    			// If the current node has a left node, we traverse it.
	    		else if(current.hasLeft())
	    		{
	    			current = current.getLeft();
					nextID = current.getBSTNodeID();
	    			nextPolarity = current.getBSTNodePolarity();
	    			
	    			if(currentPolarity.equals(nextPolarity))
	    			{
	    				currentCounter++;
	    				
	    				// If the last node is reached, 
	    				if(!current.hasLeft() && !current.hasRight())
	    				{
	    					if(currentCounter == theta)
		    				{
		    					boolean finished = false;
		    					
		    					while(!finished)
		    					{
		    						if(startingPrior != null)
	    							{
	    								resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(),startingPrior.getBSTNodeSentence()));
	    								startingPrior = startingPrior.getLeft();
	    							}
		    						
		    						else
		    						{
		    							finished = true;
		    						}
		    						
		    					}		
		    							    				
								currentCounter = 1;
			    				startingPrior = null;	
		    				}	
	    				}
	    			}
	    			
	    			
	    			// This part is to insert the consecutive ocurring elements into the linked list.
	    			else
	    			{
	    				if(currentCounter == theta)
	    				{
	    					boolean finished = false;
	    					String matchingType = startingPrior.getBSTNodePolarity();
	    					
	    					while(!finished)
	    					{
	    						//resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity()));
	    						
	    						if(startingPrior.hasRight() && startingPrior.getBSTNodePolarity().equals(matchingType))
	    						{
	    							resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(), startingPrior.getBSTNodeSentence()));
	    							startingPrior = startingPrior.getRight();
	    						}
	    						
	    						else if(startingPrior.hasLeft() && startingPrior.getBSTNodePolarity().equals(matchingType))
	    						{
	    							resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(), startingPrior.getBSTNodeSentence()));
	    							startingPrior = startingPrior.getLeft();
	    						}
	    						
	    						else
	    						{
	    							finished = true;
	    						}
	    					}
	    					
							currentCounter = 1;
	    					startingPrior = null;
	    				}


						else
						{
							currentCounter = 1;
	    					startingPrior = null;
						}
	    			}
	    		}
	    		
	    		
	    		// When the node has neither left nor right, it means we have reached the last node.
	    		else
	    		{
	    			if(currentCounter == theta)
		    		{
		    			boolean finished = false;
		    					
		    			while(!finished)
		    			{	
		    				if(startingPrior.hasRight())
		    				{
		    					resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(),startingPrior.getBSTNodeSentence()));
		    					startingPrior = startingPrior.getRight();
		    				}
		    						
		    				else if(startingPrior.hasLeft())
	    					{
	    						resultList.add(new SentenceNode(startingPrior.getBSTNodeID(), startingPrior.getBSTNodePolarity(), startingPrior.getBSTNodeSentence()));
	    						startingPrior = startingPrior.getLeft();
	    					}
		    						
		    				else
		    				{
		    					finished = true;
		    				}
		    						
		    			}		
		    							    				
						currentCounter = 1;
			    		startingPrior = null;	
		    		}	
	    			
	    			done = true;
	    		}
	    		
	    	}
	    		
	    		
	    	
	    	return resultList;		
    	}
    }
}

