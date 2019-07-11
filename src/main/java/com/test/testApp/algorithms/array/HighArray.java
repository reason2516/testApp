package com.test.testApp.algorithms.array;

public class HighArray<T> {
    private Object[] arr;
    private int nElems; // the number of elements
    private int maxLength; // the max length of array

    public HighArray(int length) {
        arr = new Object[length];
        nElems = 0;
        maxLength = length;
    }

    /**
     * 查询
     *
     * @param searchKey
     * @return
     */
    public boolean find(T searchKey) {
        boolean ret = false;
        for (int i = 0; i < nElems; i++) {
            if (this.arr[i] == searchKey) {
                ret = true;
                break;
            }
        }
        return ret;
    }


    /**
     * 插入
     *
     * @param value
     */
    public void insert(T value) {
        if (this.maxLength == this.nElems) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.arr[nElems] = value;
        this.nElems++;
    }

    /**
     * 删除
     *
     * @param value
     * @return
     */
    public boolean delete(T value) {
        boolean ret;
        int i;
        for (i = 0; i < this.nElems; i++) {
            if (this.arr[i].equals(value)) {
                break;
            }
        }

        // can't find
        if (i == this.nElems) {
            ret = false;
        } else {
            ret = true;
            // mov element after the deleted element
            for (int k = i; i < nElems - 1; i++) {
                this.arr[k] = this.arr[k + 1];
            }
            this.arr[nElems--] = null; // delete the last element and nElems - 1
        }
        return ret;
    }

    /**
     * get Element which the index is the max
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public T getMax() {
        if (this.nElems == 0) {
            return null;
        } else {
            return (T) this.arr[nElems - 1];
        }
    }

    /**
     * delete the element which the index is the max
     */
    public void removeMax() {
        this.arr[nElems - 1] = null;
    }

    /**
     * display
     */
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(this.arr[i] + "");
            System.out.print("");
        }
    }
}
