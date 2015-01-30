
package sentimentpolaritycorrection;
/**
 *
 * @author Sylvester olubolu Orimaye, PhD
 * Monash University
 */
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class SentimentPolarityCorrection {

    private static LinkedList<SentenceNode> polarityTable = new LinkedList<SentenceNode>();
    private static PolarityTree polarityTree;    
    
    public SentimentPolarityCorrection(List<SentenceNode> naivelyClassifiedSentences){
        
        /*************************************************/
        //You could replace this with an implementation that 
        //returns the output of your classifier for each sentence
        //the index of your loop could be your id, polarity is from 
        //classifier, and sentence is the actual sentence
        for(SentenceNode sentenceNode : naivelyClassifiedSentences){
            polarityTable.add(sentenceNode);
        }
        /************************************************/
        
        polarityTree = new PolarityTree();
        
        ListIterator nodesIterator = polarityTable.listIterator();
		
        while(nodesIterator.hasNext())
		{
                    SentenceNode nodeItem = (SentenceNode) nodesIterator.next();
                    polarityTree.insertBSTNode(nodeItem.getID(), nodeItem.getPolarity(),nodeItem.getSentence());
		}
    }
    
    
    public static PolarityTree polarityTree(){
        return polarityTree;
    }
    
    
    public static LinkedList<SentenceNode> polarityTable(){
        return polarityTable;
    }
    
    
    public static LinkedList<SentenceNode> consistentSentencePolarity(int theta){
        return polarityTree.findConsistentPolarity(theta);
    }
    
    
    /****UNCOMMENT FOR EXAMPLE USAGE
    
    public static void main(String[] args) {
        List<SentenceNode> naivelyClassifiedSentences = new ArrayList();
        naivelyClassifiedSentences.add(new SentenceNode(0, "pos", "I like the phone."));
        naivelyClassifiedSentences.add(new SentenceNode(1, "pos", "I like the camera quality."));
        naivelyClassifiedSentences.add(new SentenceNode(2, "neg", "I hate the screen resolution though."));
        naivelyClassifiedSentences.add(new SentenceNode(3, "pos", "The screen size is good."));
        naivelyClassifiedSentences.add(new SentenceNode(4, "neg", "But not as confortable as other brands."));
        naivelyClassifiedSentences.add(new SentenceNode(5, "pos", "Except for that, I would recommend it."));
        naivelyClassifiedSentences.add(new SentenceNode(6, "pos", "And it's really value for money."));
        SentimentPolarityCorrection spc = new SentimentPolarityCorrection(naivelyClassifiedSentences);
        
        // This part prints out the final results containing the consistent sentence polarity.
		ListIterator<SentenceNode> listIterator = consistentSentencePolarity(2).listIterator();
                
                while(listIterator.hasNext()) 
                {
                            System.out.println(listIterator.next());
                }
    }
    
    */
    
}
