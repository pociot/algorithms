package com.pociot;

import com.pociot.sorting.SmallSetSortingAlgorithmTest;
import com.pociot.sorting.SortingAlgorithmTest;
import com.pociot.structures.CustomLinkedListTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    SmallSetSortingAlgorithmTest.class,
    SortingAlgorithmTest.class,
    CustomLinkedListTest.class
})
public class TestRunner {
}
