package edu.yourname.assignment1;

public class Metrics {
    private long comparisons = 0;
    private long allocations = 0;
    private int maxDepth = 0;
    private int depth = 0;

    public void enter() {
        depth++;
        if (depth > maxDepth) maxDepth = depth;
    }
    public void exit() { depth--; }
    public void incComparisons() { comparisons++; }
    public void incAllocations(long k) { allocations += k; }

    public void reset() {
        comparisons = 0;
        allocations = 0;
        maxDepth = 0;
        depth = 0;
    }

    public long getComparisons() { return comparisons; }
    public long getAllocations() { return allocations; }
    public int getMaxDepth() { return maxDepth; }
}
