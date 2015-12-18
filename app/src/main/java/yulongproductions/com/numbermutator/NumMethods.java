package yulongproductions.com.numbermutator;

/**
 * Created by Yulong on 12/17/2015.
 */
import java.util.ArrayList;
import java.util.List;

public class NumMethods {

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
                return true;
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
        Stack<Integer> stack = new ArrayStack<Integer>();
        for (int i = 0; i < this.getCount(n); i++) {
            stack.push(n % (int)Math.pow(10, (i + 1)));
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    public String reverse(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list = this.toArray(n);
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
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
        return 0;
    }

    public int getMedian(int n) {
        return 0;
    }

    public double getAverage(int n) {
        return this.getRunningSum(n) / this.getCount(n);
    }

    public int sort(int n) {
        return 0;
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
