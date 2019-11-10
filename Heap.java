import java.util.*;
public class Heap
{
    int heap[];
    int size;
    int maxsize;
    Heap(int maxsize)
    {
        this.maxsize=maxsize+1;
        size=0;
        heap=new int[maxsize];
    }
    void insert(int x)
    {
        if(size+1>=maxsize)
        {
            System.out.println("FULL");
            return;
        }
        else
        {
           size++;
           int i=size;
           while((i!=1)&&(x>heap[i/2]))
           {
               heap[i]=heap[i/2];
               i=i/2;
           }
           heap[i]=x;
        }
    }   
    int delete()
    {
		if(size==0)
        {
            System.out.println("EMPTY");
            return -9999;
        }
        int item=heap[1];
        heap[1]=heap[size];
        size--;
        buildMaxHeap();
		return item;
    }
    void buildMaxHeap()
    {
        for(int i=size/2;i>=1;i--)
        {
            maxHeapify(i,size);
        }
    }
    void maxHeapify(int parent, int size)
    {
        int lc=parent*2;
        int rc=lc+1;
        int largest=parent;
        if(lc<=size && heap[largest]<heap[lc])
            largest=lc;
        if(rc<=size && heap[largest]<heap[rc])
            largest=rc;
        if(largest!=parent)
        {
            int temp=heap[largest];
            heap[largest]=heap[parent];
            heap[parent]=temp;
            maxHeapify(largest,size);
        }
    }
    void heapSort()
    {
        buildMaxHeap();
        for(int i=size;i>0;i--)
        {
            int temp=heap[1];
            heap[1]=heap[i];
            heap[i]=temp;
            maxHeapify(1,i-1);
        }
        traverse();
    }
    void traverse()
    {
        System.out.print("["+heap[1]);
        for(int i=1;i<=size;i++)
        System.out.print(", "+heap[i]);
        System.out.println("]");
    }
}
