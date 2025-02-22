
import java.util.ArrayList;
import java.util.List;

class ListSequences {
    int num = 0;
    public ListSequences(int n){
        num = n;
    }

    public List<String> showSequences(){
        List<String> sequences = new ArrayList<>();
        generateHelper(num, "", sequences);
        return sequences;
    }

    /* 
        Recursively adds a 1 until remaining reaches 0, then adds it to the list and goes to the
        previous step, adding a zero if the character beforehand wasn't a zero. The recursion
        continues until the last entry is made, which starts with zero and alternates between zero
        and one.
    */
    private void generateHelper(int remaining, String sequence, List<String> sequences) {
        if (remaining == 0) {
            sequences.add(sequence);
            return;
        }

        // Adds a 1 to the current sequence, ticks down remaining by 1.
        generateHelper(remaining - 1, sequence + "1", sequences);

        // Checks if there was a zero before the current bit slot, if not then adds a zero. 
        if (!sequence.endsWith("0")) {
            generateHelper(remaining - 1, sequence + "0", sequences);
        }
    }
}   

public class BitSequences {

    public static void main(String[] args) {
        int numOfSequences = 7;
        ListSequences sequences = new ListSequences(numOfSequences);
        List<String> result = sequences.showSequences();
        System.out.println("Bit sequences of length " + numOfSequences + " without consecutive 0s:");
        for (String sequence : result) {
            System.out.println(sequence);
        }   
    }

}

