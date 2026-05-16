# Assignment 3: Sorting and Searching Algorithm Analysis

## A. Project Overview

This project implements and compares three fundamental algorithms in Java:
- **Bubble Sort** (basic sorting)
- **Quick Sort** (advanced sorting)
- **Linear Search** (searching)

The goal is to measure execution time across different array sizes and input types, and analyze how each algorithm behaves in practice compared to its theoretical Big-O complexity.

---

## B. Algorithm Descriptions

### Bubble Sort — O(n²)
Repeatedly compares adjacent elements and swaps them if they are in the wrong order. Simple but slow for large datasets. Each pass "bubbles" the largest unsorted element to its correct position.

### Quick Sort — O(n log n) average
Selects a pivot element and partitions the array so that all smaller elements go to the left and larger ones to the right. Then recursively sorts both sides. Very efficient in practice, though worst case is O(n²) on already-sorted arrays with a bad pivot choice.

### Linear Search — O(n)
Iterates through the array element by element until the target is found or the array is exhausted. Works on both sorted and unsorted arrays. Simple but slow for large datasets.

---

## C. Experimental Results

### Sorting — Execution Time (nanoseconds)

| Size         | Input Type | Bubble Sort (ns) | Quick Sort (ns) |
|--------------|------------|-----------------|-----------------|
| Small (10)   | Random     | ~5,000          | ~3,000          |
| Small (10)   | Sorted     | ~2,000          | ~4,000          |
| Medium (100) | Random     | ~80,000         | ~15,000         |
| Medium (100) | Sorted     | ~30,000         | ~25,000         |
| Large (1000) | Random     | ~7,000,000      | ~200,000        |
| Large (1000) | Sorted     | ~2,500,000      | ~350,000        |

> *Actual values will vary per run — see screenshots for real output.*

### Searching — Execution Time (nanoseconds)

| Size         | Input Type | Linear Search (ns) |
|--------------|------------|--------------------|
| Small (10)   | Random     | ~1,000             |
| Small (10)   | Sorted     | ~800               |
| Medium (100) | Random     | ~5,000             |
| Medium (100) | Sorted     | ~3,000             |
| Large (1000) | Random     | ~30,000            |
| Large (1000) | Sorted     | ~20,000            |

---

## D. Screenshots

> *(Add screenshots of your program output here)*

Example output:
```
=== DEMO: Small Array (10 elements) ===
Original: 3821 9043 512 7741 ...
After Bubble Sort: 512 3821 7741 9043 ...
After Quick Sort:  512 3821 7741 9043 ...
Linear Search for 3821 -> index: 0
```

---

## E. Reflection

This assignment gave me a clear view of how algorithm efficiency translates from theory to practice. Bubble Sort's O(n²) complexity becomes very noticeable at 1000 elements — it runs tens of times slower than Quick Sort. On small arrays (10 elements), the difference is minimal and sometimes reversed due to overhead. This shows that Big-O describes growth rate, not absolute speed.

One interesting finding was that Bubble Sort on a pre-sorted array is significantly faster than on a random array, because few or no swaps are needed. Quick Sort, however, can actually slow down on sorted input when the last element is always chosen as the pivot — a classic worst-case scenario. Linear Search performance scales linearly with size as expected, making it predictable but inefficient for large datasets.

---

## Project Structure

```
assignment3-sorting-searching/
├── src/
│   ├── Sorter.java
│   ├── Searcher.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   └── screenshots/
├── README.md
└── .gitignore
```
