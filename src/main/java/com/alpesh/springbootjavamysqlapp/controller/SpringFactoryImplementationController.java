package com.alpesh.springbootjavamysqlapp.controller;

import com.alpesh.springbootjavamysqlapp.service.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringFactoryImplementationController {
    private final SortingAlgorithm sortingAlgorithm;

    // based upon Qualifier used while constructor injection between quicksort or bubblesort,
    // the bean wil be given precedence.
    public SpringFactoryImplementationController(@Qualifier("quicksort") SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    // Get the desired implementation
    @GetMapping("/user/springfactory")
    public String getSortingClass() {
        return sortingAlgorithm.sortString();
    }
}
