package entity;

import lombok.Data;

import java.math.BigInteger;
import java.util.HashSet;

@Data
public class UniqueValuesStorage {

    public UniqueValuesStorage(BigInteger firstNumber, BigInteger secondNumber, BigInteger thirdNumber) {
        firstColumn = new HashSet<>();
        secondColumn = new HashSet<>();
        thirdColumn = new HashSet<>();
        firstColumn.add(firstNumber);
        secondColumn.add(secondNumber);
        thirdColumn.add(thirdNumber);
    }

    public UniqueValuesStorage() {
        firstColumn = new HashSet<>();
        secondColumn = new HashSet<>();
        thirdColumn = new HashSet<>();
    }

    private HashSet<BigInteger> firstColumn;
    private HashSet<BigInteger> secondColumn;
    private HashSet<BigInteger> thirdColumn;

    public void addNewValues(DataLine line) {
        this.firstColumn.add(line.getFirstNumber());
        this.secondColumn.add(line.getSecondNumber());
        this.thirdColumn.add(line.getThirdNumber());
    }

    public boolean isContainsValues(BigInteger first, BigInteger second, BigInteger third) {
        return this.firstColumn.contains(first) && first != null
                || this.secondColumn.contains(second) && second != null
                || this.thirdColumn.contains(third) && third != null;
    }
}
