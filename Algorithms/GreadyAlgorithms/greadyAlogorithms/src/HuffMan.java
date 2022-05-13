import org.w3c.dom.Node;

import java.util.*;

public class HuffMan {
    Node node;

    public Noder buildTreeStructure(Map<Character, Integer> frequencies){
        int numberOfNodes = frequencies.size() - 1;
        PriorityQueue<Noder> pq = new PriorityQueue<>(numberOfNodes,(noder1, noder2)->
            Integer.signum(noder1.frequency - noder2.frequency));

        for(Map.Entry<Character, Integer> entry : frequencies.entrySet()){
            Noder entryNoder = new Noder();
            entryNoder.character = entry.getKey();
            entryNoder.frequency = entry.getValue();
            pq.add(entryNoder);
        }

        for(int i = 0; i <= numberOfNodes; i++){
            Noder newNoder = new Noder();
            newNoder.left = pq.poll();
            newNoder.right = pq.poll();
            newNoder.frequency = newNoder.left.frequency + newNoder.right.frequency;
            pq.add(newNoder);
        }

        return pq.poll();
    }
}
