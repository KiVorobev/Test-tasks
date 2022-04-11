package util;

import entity.DataLine;
import entity.Group;
import entity.UniqueValuesStorage;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class DataReader {
    private LinkedList<Group> store = new LinkedList<>();
    private UniqueValuesStorage uniqueStore = new UniqueValuesStorage();

    public void readDataFromFileToGroups() {
        Scanner fileScanner;
        while (true) {
            try {
                fileScanner = readFile();
                break;
            } catch (FileNotFoundException fileNotFoundException) {
                System.err.println("File with that name not found");
            }
        }
        int index = 0;
        while (fileScanner.hasNextLine()) {
            try {
                index++;
                DataLine line = getLineOfData(fileScanner);
                addLineToGroup(line, store, uniqueStore);
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException | StringIndexOutOfBoundsException badLineException) {
                System.err.println("[" + index + "]: Bad line");
            }
        }
        System.out.println(store.size());
    }

    private void addLineToGroup(DataLine line, LinkedList<Group> blockOfGroups, UniqueValuesStorage uniqueStore) {
        if (blockOfGroups.isEmpty()) {
            addGroup(line, blockOfGroups);
            return;
        }
        if (!uniqueStore.isContainsValues(line.getFirstNumber(), line.getSecondNumber(), line.getThirdNumber())) {
            uniqueStore.addNewValues(line);
            addGroup(line, blockOfGroups);
            return;
        }
        for (Group group : blockOfGroups) {
            if (group.getValues().isContainsValues(line.getFirstNumber(), line.getSecondNumber(), line.getThirdNumber())) {
                blockOfGroups.getLast().getLines().add(line);
                uniqueStore.addNewValues(line);
                return;
            }
        }
    }

    private void addGroup(DataLine line, LinkedList<Group> blockOfGroups) {
        blockOfGroups.add(new Group(new UniqueValuesStorage(
                line.getFirstNumber(), line.getSecondNumber(), line.getThirdNumber()), line));
    }

    private DataLine getLineOfData(Scanner fileScanner) throws ArrayIndexOutOfBoundsException, NumberFormatException, StringIndexOutOfBoundsException {
        DataLine line = new DataLine();
        String newLine = fileScanner.nextLine();
        String[] values = getValues(newLine);
        setValues(values, line);
        return line;
    }

    private void setValues(String[] values, DataLine line) {
        if (!values[0].equals("")) line.setFirstNumber(BigInteger.valueOf(Long.parseLong(values[0])));
        if (!values[1].equals("")) line.setSecondNumber(BigInteger.valueOf(Long.parseLong(values[1])));
        if (!values[2].equals("")) line.setThirdNumber(BigInteger.valueOf(Long.parseLong(values[2])));
    }

    private String[] getValues(String line) {
        String firstValue = line.substring(0, line.indexOf(";"));
        String secondValue = line.substring(line.indexOf(";") + 1, line.lastIndexOf(";"));
        String thirdValue = line.substring(line.lastIndexOf(";") + 1);
        return new String[]{firstValue, secondValue, thirdValue};
    }

    private String readFileName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter file name: ");
        return scanner.nextLine();
    }

    private Scanner readFile() throws FileNotFoundException {
        String fileName = readFileName();
        File myFile = new File("resources/" + fileName);
        return new Scanner(myFile);
    }
}
