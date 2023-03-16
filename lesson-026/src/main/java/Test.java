public class Test {
    private TestElement[] blocks;

    private int correctCount;
    private int wrongCount;

    public Test(TestElement[] blocks) {
        this.blocks = blocks;
    }

    public void runTest() {
        for (TestElement block : blocks) {
            if(block.ask()) {
                correctCount++;
                System.out.println("Right!");
            } else {
                wrongCount++;
                System.out.println("Wrong!");
            }
        }
        System.out.println("Result: correct - " + correctCount + " wrong - " + wrongCount);
    }
}
