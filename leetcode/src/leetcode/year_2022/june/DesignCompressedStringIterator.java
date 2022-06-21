package leetcode.year_2022.june;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class DesignCompressedStringIterator {
    public static void main(String[] args) {
        DesignCompressedStringIterator stringIterator = new DesignCompressedStringIterator("L1e2t1C1o1d1e1");
//        DesignCompressedStringIterator stringIterator = new DesignCompressedStringIterator("x6");
        System.out.println(stringIterator.next()); // return "L"
        System.out.println(stringIterator.next()); // return "e"
        System.out.println(stringIterator.next()); // return "e"
        System.out.println(stringIterator.next()); // return "t"
        System.out.println(stringIterator.next()); // return "C"
        System.out.println(stringIterator.next()); // return "o"
        System.out.println(stringIterator.hasNext()); // return True
        System.out.println(stringIterator.next()); // return "d"
        System.out.println(stringIterator.hasNext()); // return True
    }

    private final Queue<Character> alphabetQueue;
    private final Queue<Integer> numberQueue;
    private Character currChar;
    private int currCharRemain;

    public DesignCompressedStringIterator(String compressedString) {
        this.alphabetQueue = new LinkedList<>();
        this.numberQueue = new LinkedList<>();

        String[] alphabets = compressedString.split("\\d+");
        String[] numberSplit = compressedString.split("[a-zA-z]", -1);
        List<Integer> numbers = Arrays.stream(numberSplit)
                .filter(s -> !s.isEmpty())
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        for (int i = 0; i < alphabets.length; i++) {
            alphabetQueue.add(alphabets[i].charAt(0));
            numberQueue.add(numbers.get(i));
        }
        currChar = alphabetQueue.poll();
        currCharRemain = numberQueue.poll();
    }

    public char next() {
        if (currCharRemain > 0) {
            currCharRemain--;
            return currChar;
        }

        if (alphabetQueue.isEmpty()) {
            return ' ';
        }

        currChar = alphabetQueue.poll();
        currCharRemain = numberQueue.poll() - 1;
        return currChar;
    }

    public boolean hasNext() {
        if (currCharRemain > 0) {
            return true;
        }
        return !alphabetQueue.isEmpty();
    }
}
