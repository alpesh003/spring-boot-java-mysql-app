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
        return "Sorting using Bubble Sort";
    }
}
