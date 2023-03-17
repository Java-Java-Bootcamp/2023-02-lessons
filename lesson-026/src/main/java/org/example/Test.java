package org.example;

public class Test {
    private TestElement[] blocks;

    private int correctCount;
    private int wrongCount;

    private UserOutput userOutput;

    public Test(UserOutput userOutput, TestElement[] blocks) {
        this.blocks = blocks;
        this.userOutput = userOutput;
    }

    public void runTest() {
        for (TestElement block : blocks) {
            if(block.ask()) {
                correctCount++;
                userOutput.print("Right!");
            } else {
                wrongCount++;
                System.out.println("Wrong!");
            }
        }
        System.out.println("Result: correct - " + correctCount + " wrong - " + wrongCount);
    }
}
