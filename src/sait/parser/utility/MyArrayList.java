/**
 * 
 */
package sait.parser.utility;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import sait.parser.contracts.Iterator;
import sait.parser.contracts.ListADT;




import java.lang.reflect.Array;
import java.util.NoSuchElementException;



    /**
     * @author Chaoling Lu,Sheng Ming Yan,Mengdan Liu
     * @param <E>
     *
     */
    public class MyArrayList<E> implements ListADT<E>, Iterator<E> {

        //attributes
        private static final long serialVersionUID =1L;
        private E[] array;
        //capacity of a array
        private int size;
        private MyArrayList<E>.ArrayBasedIterator myIter;
        
//        private ListADT<E>[] list;

        
        public MyArrayList() {
        	array = (E[]) new Object[10];
        	
//        	list = new ListADT[10];
        	this.myIter = new ArrayBasedIterator(); 
        }


        public  MyArrayList(int i) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("size must bigger than 0");
            }
            array = (E[]) new Object [i];
            
//            list =  new ListADT[i];

            this.myIter = new ArrayBasedIterator();

        }

        @Override
        public int size() {
        	return this.size;
//            return this.list.length;
        }

        @Override
        public void clear() {
            this.size = 0;

        }

        @Override
        public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

            try {
                if (index < 0 || index > size) {

                    return false;
                }
                if (toAdd== null) {

                    return false;
                }

                if (this.array[index] == null) {
                    this.array[index] = toAdd;
                    size++;
                    return true;
                }
                if(this.array[index]!=null){
                    for (int i = array.length - 2; i >= index; i--) {
                    this.array[i] = this.array[i - 1];
 }
                }


                System.arraycopy(this.array, index, this.array, index + 1, size() - index - 1);


                this.array[index] = toAdd;
                size++;
                return true;
            } catch (ClassCastException e) {
                throw e;
            }

        }
        
//        private ListADT<E>[] extendSize() {
//        	ListADT<E>[] list2 = new ListADT[this.list.length];
//        	System.arraycopy(this.list, 0,list2,0, this.size);
//        	return list2;
//        }



        @Override
        public boolean add(E toAdd) throws NullPointerException {
            if( toAdd == null || toAdd.equals("")) {

                throw new NullPointerException();
            }
            
           
//           this.list = this.list.extendSize();
            

            if (size == array.length) {        	
            	
                //array has no room,create a new array with double the size
                System.arraycopy(this.array, 0,this.array,0, (int) Math.pow(this.array.length, 2));

//		for(int i = 0; i<array.length;i++) {
//			if(array[i] == null) {
//				array[i] =toAdd;
//
			}
//
//		}

//            }
            array[size] = toAdd;
            size++;

            return true;
        }

        @Override
        public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
            Iterator iterator = toAdd.iterator();
            boolean success = true;

            while (success && iterator.hasNext()) {
                Object next = iterator.next();
                success = this.add((E) next);
            }
            return success;
        }

        @Override
        public E get(int index) throws IndexOutOfBoundsException {

            return (E)this.array[index];
        }

        @Override
        public E remove(int index) throws IndexOutOfBoundsException {
            Object element = this.array[index];
            // this.elements[index] = null;
// {1,2,3,4,5} index=2 12445 1245n
            if (index < array.length - 1) {
                System.arraycopy(this.array, index + 1, this.array, index, size() - index - 1);
            }
            this.array[array.length- 1] = null;
            return (E) element;
        }

        @Override
        public E remove(E toRemove) throws NullPointerException {
            for (int i = 0; i < size(); i++) {
                if (this.array[i] != null && this.array[i].equals(toRemove)) {
                    return remove(i);
                }
            }

            return null;
        }

        @Override
        public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
            Object element = this.array[index];
            this.array[index] = toChange;
            return (E) element;
        }

        @Override
        public boolean isEmpty() {
            for (int i = 0; i < size(); i++) {
                if (this.array[i] != null) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean contains(E toFind) throws NullPointerException {
            if (toFind == null) {
                throw new NullPointerException();
            }
            for (int i = 0; i < size(); i++) {
                if (this.array[i] != null && this.array[i].equals(toFind)) {
                    return true;
                }
            }
            return false;
        }
// if array.length is smaller than toHold.lengh ,then create a new array double the size then add everything in.
        @Override
        public E[] toArray(E[] toHold) throws NullPointerException {
            if (toHold.length < array.length) {
                return (E[]) toArray();
            }
            // elements {1,2,3} toHold {7,8,,,,4,5} result {1,2,3,,,4,5}
            System.arraycopy(this.array, 0, toHold, 0, size());
            return toHold;
        }

        @Override
        public Object[] toArray() {
            // {1,2,3} {'jon','133',1,2,3}
// {1,2,3} arr = null
            Object[] toHold = new Object[size()];
            System.arraycopy(this.array, 0, toHold, 0, size());
            return toHold;
        }

        @Override
        public Iterator<E> iterator() {

            this.myIter = new ArrayBasedIterator();
            return myIter;
        }
        
        //arraylist = {1}
        //int i =0;
        //while(arraylist.hasNext()){
        // print..[i];
        //i++;
        //}
        
		@Override
		public boolean hasNext() {
//			E[] array2 = this.array;
			System.arraycopy(this.array, 0, this.array, 0, size()-1);
			return this.array.length!=0;
		}


		@Override
		public E next() throws NoSuchElementException {
			
            return toReturn;
		}

        /*---------------------------------INNER CLASS------------------*/
        private class ArrayBasedIterator implements Iterator<E> {
            private int position = 0;
            private E[] copyOfElements;
            private ArrayBasedIterator() {
                copyOfElements = (E[]) toArray();
            }
            @Override
            public boolean hasNext() {
                if (position < copyOfElements.length) {
                    return true;
                }
                else {
                    return false;
                }
            }
            @Override
            public E next() throws NoSuchElementException {
                E toReturn = copyOfElements[position];
                position++;
                return toReturn;
            }

        }



    }


