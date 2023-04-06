package org.example;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private final TestElements elements;

    public TestController(TestElements elements) {
        this.elements = elements;
    }

    @GetMapping("api/element")
    public List<TestElement> getElements() {
        return elements.getElements();
    }
}
