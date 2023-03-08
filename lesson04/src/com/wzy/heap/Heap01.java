package com.wzy.heap;

/**
 * @author wzy
 * @date 2022年01月10日 9:08
 */
public class Heap01 {

    public static class MyMaxHeap{
        private int[] heap;
        private final int limit;
        private int heapSize;

        public MyMaxHeap(int limit){
            heap = new int[limit];
            this.limit = limit;
            heapSize = 0;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("heap is full");
            }
            heap[heapSize] = value;
            //调整数据使其始终为大根堆
            heapInsert(heap, heapSize++);
        }

        public int pop() {
            int ans = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return ans;
        }

        //
        private void heapify(int[] heap, int index, int heapSize) {
            int left = index * 2 + 1;
            while (left < heapSize) {
                //得到左右子节点中较大的下标
                int largest = left + 1 < heapSize && heap[left +1] > heap[left] ? left + 1 : left;
                largest = heap[largest] > heap[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(heap, index, largest);
                index = largest;
                left = index * 2 + 1;
            }
        }

        private void heapInsert(int[] heap, int index) {
            while (heap[index] > heap[(index -1) / 2]) {
                swap(heap, index, (index -1) / 2);
                index = (index -1) / 2;
            }
        }


        private void swap(int[] heap, int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

    }

}
