package entity;

import lombok.Data;

import java.util.HashSet;

@Data
public class Group {

    public Group () {

    }

    public Group(UniqueValuesStorage storage, DataLine line) {
        values = storage;
        lines = new HashSet<>();
        lines.add(line);
    }

    private UniqueValuesStorage values;
    private HashSet<DataLine> lines;
}
