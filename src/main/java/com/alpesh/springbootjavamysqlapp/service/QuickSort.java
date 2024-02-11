package com.alpesh.springbootjavamysqlapp.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quicksort")
public class QuickSort implements SortingAlgorithm{
    /**
     * @return Quick sort functionality
     */
    @Override
    public String sortString() {
        return "Returns Quick Sort Algorithm";
    }
}
