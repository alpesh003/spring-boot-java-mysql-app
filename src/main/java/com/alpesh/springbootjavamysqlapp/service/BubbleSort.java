package com.alpesh.springbootjavamysqlapp.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("bubblesort")
public class BubbleSort implements SortingAlgorithm{
    /**
     * @return Bubble Sorting functionality
     */
    @Override
    public String sortString() {
        return "Returns Bubble Sort Algorithm";
    }

    /**
     * @return the sorting class simple name to be returned in factory
     */
    @Override
    public String getSortingType() {
        return this.getClass().getSimpleName();
    }
}
