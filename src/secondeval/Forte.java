package secondeval;

import java.util.Scanner;

public class Forte {
    static void generateOperandCombinations(String[] operands, String[][] operandCombinations) {
        int k = 0;
        for(int i = 0; i < operands.length - 1; i++) {
            for(int j = i+1; j < operands.length; j++) {
                operandCombinations[k][0] = operands[i];
                operandCombinations[k][1] = operands[j];
                k++;
            }
        }
        for(int i = operands.length-1; i > 0; i--) {
            for(int j = i-1; j >= 0; j--) {
                operandCombinations[k][0] = operands[i];
                operandCombinations[k][1] = operands[j];
                k++;
            }
        }
    }
    static void generateOperatorCombinations(String[] operators, String[][] operatorCombinations) {
        int l = 0;
        for(int i = 0; i < operators.length; i++) {
            for(int j = 0; j < operators.length; j++) {
                for(int k = 0; k < operators.length; k++) {
                    operatorCombinations[l][0] = operators[i];
                    operatorCombinations[l][1] = operators[j];
                    operatorCombinations[l][2] = operators[k];
                    l++;
                }
            }
        }
    }
    static void getSecondOperandComboPair(String[][] operandCombinations, String[] firstOperandPair, String[][] secondOperandComboPair) {
        int k = 0;
        outer: for(String[] i : operandCombinations) {
            if(!(i[0].equals(firstOperandPair[0]))) {
                if(!(i[0].equals(firstOperandPair[1]))) {
                    if (!(i[1].equals(firstOperandPair[0]))) {
                        if (!(i[1].equals(firstOperandPair[0]))) {
                            secondOperandComboPair[k][0] = i[0];
                            secondOperandComboPair[k][1] = i[1];
                            k++;
                            if(k == 2) break outer;
                        }
                    }
                }
            }
        }
    }
    static void solve(String[][] operandCombinations, String[][] operatorCombinations, String[] firstOperandPair, String[][] secondOperandComboPair, String[] secondOperandPair, String[] operatorCombo, int result) {
        int firstResult, secondResult, totalResult;
        firstResult = secondResult = totalResult = 0;
        outer: for(String[] i : operandCombinations) {
            firstOperandPair[0] = i[0];
            firstOperandPair[1] = i[1];
            getSecondOperandComboPair(operandCombinations, firstOperandPair, secondOperandComboPair);
            for(String[] j : secondOperandComboPair) {
                secondOperandPair[0] = j[0];
                secondOperandPair[1] = j[1];
                for(String[] k : operatorCombinations) {
                    operatorCombo[0] = k[0];
                    operatorCombo[1] = k[1];
                    operatorCombo[2] = k[2];

                    if(operatorCombo[0].equals("+")) {
                        firstResult = (Integer.parseInt(firstOperandPair[0])) + (Integer.parseInt(firstOperandPair[1]));
                    } else if (operatorCombo[0].equals("-")) {
                        firstResult = (Integer.parseInt(firstOperandPair[0])) - (Integer.parseInt(firstOperandPair[1]));
                    } else if (operatorCombo[0].equals("*")) {
                        firstResult = (Integer.parseInt(firstOperandPair[0])) * (Integer.parseInt(firstOperandPair[1]));
                    } else if (operatorCombo[0].equals("/")) {
                        if((Integer.parseInt(firstOperandPair[1])) == 0) break;
                        firstResult = (Integer.parseInt(firstOperandPair[0])) / ((Integer.parseInt(firstOperandPair[1])));
                    }

                    if(operatorCombo[2].equals("+")) {
                        secondResult = (Integer.parseInt(secondOperandPair[0])) + (Integer.parseInt(secondOperandPair[1]));
                    } else if (operatorCombo[2].equals("-")) {
                        secondResult = (Integer.parseInt(secondOperandPair[0])) - (Integer.parseInt(secondOperandPair[1]));
                    } else if (operatorCombo[2].equals("*")) {
                        secondResult = (Integer.parseInt(secondOperandPair[0])) * (Integer.parseInt(secondOperandPair[1]));
                    } else if (operatorCombo[2].equals("/")) {
                        if((Integer.parseInt(secondOperandPair[1])) == 0) break;
                        secondResult = (Integer.parseInt(secondOperandPair[0])) / ((Integer.parseInt(secondOperandPair[1])));
                    }

                    if(operatorCombo[1].equals("+")) {
                        totalResult = firstResult + secondResult;
                    } else if (operatorCombo[1].equals("-")) {
                        totalResult = firstResult - secondResult;
                    } else if (operatorCombo[1].equals("*")) {
                        totalResult = firstResult * secondResult;
                    } else if (operatorCombo[1].equals("/")) {
                        if(secondResult == 0) break;
                        totalResult = firstResult / (secondResult);
                    }

                    if(totalResult == result) {
                        break outer;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter the resultant number: ");
        int result = input.nextInt();
        String[] operands = new String[4];
        String[] operators = {"+", "-", "*", "/"};
        String[][] operatorCombinations = new String[64][3];
        String[][] operandCombinations = new String[12][2];
        System.out.println("Enter the four numbers: ");
        for(int i = 0; i < 4; i++) {
            operands[i] = input.next();
        }
        generateOperandCombinations(operands, operandCombinations);
        generateOperatorCombinations(operators, operatorCombinations);
        String[] firstOperandPair = new String[2];
        String[][] secondOperandComboPair = new String[2][2];
        String[] secondOperandPair = new String[2];
        String[] operatorCombo = new String[3];
        solve(operandCombinations,operatorCombinations,firstOperandPair,secondOperandComboPair,secondOperandPair,operatorCombo, result);
        System.out.println("output execution: ");
        System.out.println(firstOperandPair[0] + " " + operatorCombo[0] + " " + firstOperandPair[1] + " " + operatorCombo[1] + " " + secondOperandPair[0] + " " + operatorCombo[2] + " " + secondOperandPair[1]);
    }
}
