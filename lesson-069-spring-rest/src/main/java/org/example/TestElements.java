package org.example;

import java.util.ArrayList;
import java.util.List;

public class TestElements {

    private final List<TestElement> elements;

    public TestElements(TestElement[] elements) {
        this.elements = new ArrayList<>(List.of(elements));
    }

    public List<TestElement> getElements() {
        return elements;
    }

    public TestElement getElement(int id) {
        return  elements.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }


}
