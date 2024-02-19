package com.alpesh.springbootjavamysqlapp.factory;

import com.alpesh.springbootjavamysqlapp.service.SortingAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This Factory implementation uses
 * Spring annotation based factory creation for
 * BubbleSort and QuickSort classes
 */
@Service
public class SortingFactory {
    // Define a list of all possible implementation of SortingAlgorithm
    @Autowired
    private List<SortingAlgorithm> sortingAlgorithmList;

    // Define the hashmap which will be initialized ith all possible values of implementation class
    private static final Map<String,SortingAlgorithm> mySortingAlgorithm = new HashMap<>();

    @PostConstruct
    public void initSortingAlgorithm(){
        for (SortingAlgorithm sortingAlgo: sortingAlgorithmList) {
            mySortingAlgorithm.put(sortingAlgo.getSortingType(), sortingAlgo);
        }
    }

    public static SortingAlgorithm getSortingAlgorithm(String sortingType) {
        if(null == mySortingAlgorithm.get(sortingType)) {
            throw new RuntimeException("Unknown Sorting Type : " + sortingType);
        }
        return mySortingAlgorithm.get(sortingType);
    }
}
