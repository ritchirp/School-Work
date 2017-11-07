import java.util.ArrayList;
import java.util.Arrays;

public class Square implements Comparable<Square> {

    ArrayList<Integer> domain;
    int row;
    int col;


    public Square(int val, int row, int col) {
        this.row = row;
        this.col = col;
        domain = new ArrayList<>();
        if (val == 0) {
            for (int i = 1; i < 10; i++) domain.add(new Integer(i));
        }

        else {
            domain.add(val);
        }
    }

    public void assign(int i) {
        domain = new ArrayList<>();
        domain.add(new Integer(i));
    }

    public ArrayList<Integer> getDomain() {
        return domain;
    }

    public boolean removeFromDomain(Square s) {
        if (s.domain.size() == 1) {
            return this.domain.remove(new Integer(s.domain.get(0)));
        }
        return false;
    }

    public boolean addToDomain(int val) {
        return domain.add(val);
    }

    @Override
    public int compareTo(Square s) {
        if (this.domain.size() < s.domain.size()) return -1;
        if (this.domain.size() > s.domain.size()) return 1;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) return false;
        Square s = (Square) o;
        if (this.row == s.row && this.col == s.col) return true;
        return false;
    }

    @Override
    public String toString() {
        if (domain.size() == 1) return domain.get(0).toString();
        else return "-";
    }
}
