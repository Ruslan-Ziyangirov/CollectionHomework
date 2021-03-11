package tasks.first;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {

        ArrayDeque<Integer> endNumbersVertex = new ArrayDeque<>();

        endNumbersVertex.addFirst(startIndex);
        String strings = Integer.toString(startIndex);
        while (!endNumbersVertex.isEmpty()) {
            for (int i = 0; i < adjacencyMatrix.length; i++) {
                if (adjacencyMatrix[endNumbersVertex.getFirst()][i] && !strings.contains(Integer.toString(i))) {
                    strings += Integer.toString(i);
                    endNumbersVertex.addLast(i);
                }

            }
            endNumbersVertex.removeFirst();
        }
        return strings;

    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> queChars = new ArrayDeque<>();


        if (s != null) {
            char[] charArray = s.toCharArray();

            for (int i = 0; i < charArray.length; i++) {
                switch (charArray[i]) {
                    case '(':
                        queChars.addFirst(charArray[i]);
                        break;

                    case '[':
                        queChars.addFirst(charArray[i]);
                        break;

                    case '{':
                        queChars.addFirst(charArray[i]);
                        break;

                    case ')':
                        if (queChars.getFirst() == '(')
                            queChars.removeFirst();
                        break;

                    case ']':
                        if (queChars.getFirst() == '[')
                            queChars.removeFirst();
                        break;

                    case '}':
                        if (queChars.getFirst() == '{')
                            queChars.removeFirst();
                        break;
                }

            }
            if (queChars.isEmpty()) {
                return true;
            }

        }
        return false;
    }

    @Override
    public Long polishCalculation(String s) {
        ArrayDeque<Integer> queInteger = new ArrayDeque<>();
        ArrayList<String> listOfSign =  new ArrayList<>();
        int result = 0;


        if (s != null) {
            String [] sings = s.split(" ");
            for (int i = 0; i < sings.length; i++) {
                if (sings[i].equals("+") || sings[i].equals("-") || sings[i].equals("*") || sings[i].equals("/")){
                    listOfSign.add(sings[i]);
                }else {
                    queInteger.addLast(Integer.parseInt(sings[i]));
                }
            }
            int i =0;
            while (!queInteger.isEmpty()){
                if(i == listOfSign.size()){
                    break;
                }
                for (i = 0; i < listOfSign.size(); i++) {
                    switch (listOfSign.get(i)) {
                        case "+":
                            result = queInteger.getLast();
                            queInteger.removeLast();
                            result = result + queInteger.getLast();
                            queInteger.removeLast();
                            queInteger.addLast(result);
                            break;

                        case "-":
                            result = queInteger.getLast();
                            queInteger.removeLast();
                            result = result - queInteger.getLast();
                            queInteger.removeLast();
                            queInteger.addLast(result);
                            break;

                        case "*":
                            result = queInteger.getLast();
                            queInteger.removeLast();
                            result = result * queInteger.getLast();
                            queInteger.removeLast();
                            queInteger.addLast(result);
                            break;

                        case "/":
                            result = queInteger.getLast();
                            queInteger.removeLast();
                            result = result / queInteger.getLast();
                            queInteger.removeLast();
                            queInteger.addLast(result);
                            break;
                    }
                }
            }
        }

        return (long) result;
    }
}
