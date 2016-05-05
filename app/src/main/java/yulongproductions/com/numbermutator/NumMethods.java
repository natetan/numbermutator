package yulongproductions.com.numbermutator;

/**
 * Created by Yulong on 12/17/2015.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumMethods {
    private List<Integer> mainList = new ArrayList<Integer>();

    public int getMaxDigit(int n) {
        n = Math.abs(n);
        if (n / 10 == 0) {
            return n % 10;
        } else {
            return Math.max(n % 10, getMaxDigit(n / 10));
        }
    }

    public int getMinDigit(int n) {
        n = Math.abs(n);
        if (n / 10 == 0) {
            return n % 10;
        } else {
            return Math.min(n % 10, getMinDigit(n / 10));
        }
    }

    public String createNumSequence(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Number must be at least 1");
        }
        if (n == 1) {
            return this.toString(n);
        } else {
            return createNumSequence(n - 1) + ", " + n;
        }
    }

    public boolean isSorted(int n) {
        if (n < 0) {
            n = n * -1;
        }
        if (n / 10 == 0) {
            return true;
        } else {
            if (n % 10 < n / 10 % 10) {
                return false;
            } else {
                return isSorted(n / 10);
            }
        }
    }

    public int getRunningSum(int n) {
        this.negativeCheck(n);
        if (n / 10 == 0) {
            return n;
        } else {
            return n % 10 + getRunningSum(n / 10);
        }
    }

    public int getCount(int n) {
        this.negativeCheck(n);
        if (n / 10 == 0) {
            return 1;
        } else {
            return 1 + getCount(n / 10);
        }
    }

    public List<Integer> toArray(int n) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<Integer> stack = new LinkedStack<Integer>();
        for (int i = 0; i < this.getCount(n); i++) {
            stack.push(n % (int) Math.pow(10, (i + 1)));
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public String reverse(int n) {
        this.mainList = this.toArray(n);
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = this.mainList.size() - 1; i >= 0; i--) {
            newList.add(this.mainList.get(i));
        }
        return this.printFromArray(newList);
    }

    public String printFromArray(List<Integer> list) {
        String output = "";
        for (int i = 0; i < list.size(); i++) {
            output += list.get(i);
        }
        return output;
    }

    public int getMode(int n) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int num : this.toArray(n)) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            max = Math.max(max, num);
        }
        return max;
    }

    public int getMedian(int n) {
        int median = 0;
        this.mainList = this.toArray(this.sort(n));
        if (this.getCount(n) % 2 == 0) {
            return (int) this.mainList.get((this.mainList.size() / 2) +
                    this.mainList.get(this.mainList.size() / 2 - 1)) / 2;
        } else {
            return this.mainList.get(this.mainList.size() / 2);
        }
    }

    public double getAverage(int n) {
        return this.getRunningSum(n) / this.getCount(n);
    }

    public int sort(int n) {
        this.mainList = this.toArray(n);
        this.sort(this.mainList);
        return Integer.parseInt(this.printFromArray(this.mainList));
    }

    public void sort(List<Integer> list) {
        if (list.size() > 1) {
            int size1 = list.size() / 2;
            int size2 = list.size() - size1;
            List<Integer> half1 = new ArrayList<>();
            List<Integer> half2 = new ArrayList<>();
            for (int i = 0; i < size1; i++) {
                half1.add(list.remove(0));
            }
            for (int i = 0; i < size2; i++) {
                half2.add(list.remove(0));;
            }
            this.sort(half1);
            this.sort(half2);
            this.merge(list, half1, half2);
        }
    }

    private void merge(List<Integer> list, List<Integer> half1, List<Integer> half2) {
        while (!half1.isEmpty() && !half2.isEmpty()) {
            if (half1.indexOf(0) <= half2.indexOf(0)) {
                list.add(half1.remove(0));
            } else {
                list.add(half2.remove(0));
            }
        }
        while (!half1.isEmpty()) {
            list.add(half1.remove(0));
        }
        while (!half2.isEmpty()) {
            list.add(half2.remove(0));
        }
    }

    public String toString(int n) {
        return n + "";
    }

    private void negativeCheck(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number can't be negative");
        }
    }
}
