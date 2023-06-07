package entity;

import lombok.Data;

import java.math.BigInteger;

@Data
public class DataLine {

    public DataLine() {

    }

    public DataLine(BigInteger firstNumber, BigInteger secondNumber, BigInteger thirdNumber) {
        setFirstNumber(firstNumber);
        setSecondNumber(secondNumber);
        setThirdNumber(thirdNumber);
    }

    private BigInteger firstNumber, secondNumber, thirdNumber;
}
