package org.tasks.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1Part1 {

    protected final List<Integer> first = new ArrayList<>();
    protected final List<Integer> second = new ArrayList<>();
    protected int finalId;

    public String returnDistance(List<String> input) {
        populateLists(input);
        sortLists();
        calculateDistance();
        return String.valueOf(finalId);
    }

    protected void populateLists(List<String> input) {
        for (String line : input) {
            String[] locations = line.split(" {3}");
            first.add(Integer.valueOf(locations[0]));
            second.add(Integer.valueOf(locations[1]));
        }
    }

    private void sortLists() {
        Collections.sort(first);
        Collections.sort(second);
    }

    private void calculateDistance(){
        for (int count = 0; count <first.size(); count++) {
            finalId = finalId + (Math.abs(first.get(count) - second.get(count)));
        }
    }
}
