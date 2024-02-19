package com.alpesh.springbootjavamysqlapp.controller;

import com.alpesh.springbootjavamysqlapp.factory.SortingFactory;
import com.alpesh.springbootjavamysqlapp.service.BubbleSort;
import com.alpesh.springbootjavamysqlapp.service.QuickSort;
import com.alpesh.springbootjavamysqlapp.service.SortingAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SpringFactoryImplementationController {
    private final SortingAlgorithm sortingAlgorithm;

    // based upon Qualifier used while constructor injection between quicksort or bubble-sort,
    // the bean will be given precedence.
    public SpringFactoryImplementationController(@Qualifier("quicksort") SortingAlgorithm sortingAlgorithm) {
        this.sortingAlgorithm = sortingAlgorithm;
    }

    // Get the desired implementation
    @GetMapping("/user/springfactory")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String sortString() {
        return sortingAlgorithm.sortString();
    }
    @GetMapping("/user/getSortingFactory")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String determineSortingAlgo() {
        SortingAlgorithm sortingAlgorithm = SortingFactory.getSortingAlgorithm(BubbleSort.class.getSimpleName());
//        SortingAlgorithm sortingAlgorithm = SortingFactory.getSortingAlgorithm(QuickSort.class.getSimpleName());
        return "Sorting Algorithm received is: " + sortingAlgorithm.getClass().getSimpleName();
    }
}
