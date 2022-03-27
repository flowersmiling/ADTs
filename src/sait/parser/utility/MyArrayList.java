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
        


        
        public MyArrayList() {
        	array = (E[]) new Object[10];
        	
        	this.myIter = new ArrayBasedIterator(); 
        }

 
        public  MyArrayList(int i) {
            if (i < 0) {
                throw new IndexOutOfBoundsException("size must bigger than 0");
            }
            array = (E[]) new Object [i];
            
            this.myIter = new ArrayBasedIterator();

        }

        @Override
        public int size() {
        	return this.size;

        }

        @Override
        public void clear() {
            this.size = 0;

        }
        // adding element to a specific index.
        @Override
        public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

        	try { 
        		E element = (E) toAdd;
        		
                if (index < 0 || index > size) {

                    return false;
                }
                if (element == null) {

                    return false;
                }
                //check if the index is empty.
                if (this.array[index] == null) {
                    this.array[index] = element;
                    size++;
                    return true;
                }
                //if the index is not empty move the index to the right
         System.arraycopy(this.array, index, this.array, index + 1, size() - index);
         
         this.array[index] = element;
         size++;
         return true;
                
        	}
                catch(NullPointerException e) {
                	throw e;
                }
        }

         

        @Override
        public boolean add(E toAdd) throws NullPointerException {
            if( toAdd == null || toAdd.equals("")) {

                throw new NullPointerException();
            }
            
            

            if (size == array.length) {        	
            	

                System.arraycopy(this.array, 0,this.array,0, (int) Math.pow(this.array.length, 2));

			}

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
            Object array = this.array[index];

            if (index < size - 1) {
                System.arraycopy(this.array, index + 1, this.array, index, size() - index - 1);
            }
            this.array[size- 1] = null;
            size--;
            return (E) array;
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

            System.arraycopy(this.array, 0, toHold, 0, size());
            return toHold;
        }

        @Override
        public Object[] toArray() {

            Object[] toHold = new Object[size()];
            System.arraycopy(this.array, 0, toHold, 0, size());
            return toHold;
        }

        @Override
        public Iterator<E> iterator() {

            this.myIter = new ArrayBasedIterator();
            return myIter;
        }
        
        
		@Override
		public boolean hasNext() {
			this.myIter = new ArrayBasedIterator();
			return myIter.hasNext();
		}


		@Override
		public E next() throws NoSuchElementException {
	
			 this.myIter = new ArrayBasedIterator();
	         return (E) myIter.next();


		}

        /*---------------------------------INNER CLASS--------------------------------*/
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


