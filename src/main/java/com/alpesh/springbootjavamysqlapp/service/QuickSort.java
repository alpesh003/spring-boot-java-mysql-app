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

    /**
     * @return the sorting class simple name to be returned in factory
     */
    @Override
    public String getSortingType() {
        return this.getClass().getSimpleName();
    }
}
