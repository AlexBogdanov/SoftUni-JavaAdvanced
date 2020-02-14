package p04Froggy.Lake;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import p04Froggy.LakeComparator.LakeComparator;

public class Lake implements Iterable<Integer> {

    List<Integer> nums;
    int pointer;

    public Lake(Integer... nums) {
        this.nums = new ArrayList<>();
        this.pointer = 0;

        this.nums = List.of(nums).stream()
            .sorted(new LakeComparator())
            .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int num : this.nums) {
            sb.append(num + ", ");
        }
        
        String res = sb.toString();
        res = res.substring(0, res.length() - 2);
        return res;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<Integer> {

        @Override
        public boolean hasNext() {
            return nums.size() - 1 > pointer++;
        }

        @Override
        public Integer next() {
            return nums.get(pointer);
        }
        
    }

}
