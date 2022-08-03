package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import timingtest.AList;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
    // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        int[] inputList = new int[]{4, 5, 6};
        BuggyAList<Integer> bAList = new BuggyAList<>();
        AListNoResizing<Integer> aAList = new AListNoResizing<>();

        for (int i = 0; i < inputList.length; i++) {
            bAList.addLast(inputList[i]);
            aAList.addLast(inputList[i]);
        }

        assertEquals(bAList.size(), aAList.size());
        for (int i = 0; i < inputList.length; i++) {
            assertEquals(bAList.removeLast(), aAList.removeLast());
        }
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 3);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bL.addLast(randVal);
                System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = bL.size();

                System.out.println("size of AList: " + size);
                System.out.println("size of BuggyList: " + sizeB);

                assertEquals(size, sizeB);
            } else if (operationNumber == 2) {
                if (L.size() > 0 && bL.size() > 0) {
                    assertEquals(L.removeLast(), bL.removeLast());
                }
            }
        }
    }

}
