package com.wzy.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @author wzy
 * @date 2022年01月10日 11:32
 * 自定义堆，解决一些特殊需求
 */
public class Heap02 {
    public static class MyHeap<T>{
        // 动态类型的数组
        private ArrayList<T> heap;
        // 记录所有 样本 在堆上的位置
        // 最重要的，可以动态改变堆中的元素之后，调整成堆的关键
        private HashMap<T, Integer> indexMap;
        // 堆的大小
        private int heapSize;
        // 比较器
        private Comparator<? super T> comparator;

        public MyHeap(Comparator<? super T> com){
            heap = new ArrayList<>();
            indexMap = new HashMap<>();
            heapSize = 0;
            comparator = com;
        }

        public boolean isEmpty(){
            return heapSize == 0;
        }

        public int size(){
            return heapSize;
        }

        public boolean contains(T key){
            return indexMap.containsKey(key);
        }

        public void push(T value){
            heap.add(value);
            indexMap.put(value, heapSize);
            heapInsert(heapSize++);
        }

        public T pop(){
            T ans = heap.get(0);
            int end = heapSize - 1;
            swap(0, end);
            heap.remove(end);
            indexMap.remove(ans);
            heapify(0, --heapSize);
            return ans;
        }

        private void heapify(int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) { // 如果有左孩子，有没有右孩子，可能有可能没有！
                // 把较大孩子的下标，给largest
                int largest = left + 1 < heapSize && comparator.compare(heap.get(left + 1), heap.get(left)) < 0
                        ? left + 1 : left;
                largest = comparator.compare(heap.get(largest), heap.get(index)) < 0 ? largest : index;
                if (largest == index) {
                    break;
                }
                // index和较大孩子，要互换
                swap(largest, index);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int index) {
            while (comparator.compare(heap.get(index), heap.get((index - 1)/2)) < 0){
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int i, int j){
            T o1 = heap.get(i);
            T o2 = heap.get(j);
            heap.set(j, o1);
            heap.set(i, o2);
            indexMap.put(o1, j);
            indexMap.put(o2, i);
        }

        //
        public void resign(T value){
            int valueIndex = indexMap.get(value);
            heapInsert(valueIndex);
            heapify(valueIndex, heapSize);
        }
    }
}
