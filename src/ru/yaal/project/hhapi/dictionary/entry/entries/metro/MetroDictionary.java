package ru.yaal.project.hhapi.dictionary.entry.entries.metro;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.dictionary.IDictionary;

import java.util.List;

public class MetroDictionary extends Dictionary<MetroCity> {

    public MetroDictionary(List<MetroCity> metroCities) throws DictionaryException {
        for (MetroCity metroCity : metroCities) {
            putDictionaryEntry(metroCity);
        }
    }

    @Override
    public boolean hasEntryWithId(String id) throws DictionaryException {
        if (super.hasEntryWithId(id)) {
            return true;
        } else {
            for (MetroCity city : toList()) {
                IDictionary<MetroLine> lines = city.getLines();
                if (lines.hasEntryWithId(id)) {
                    return true;
                } else {
                    for (MetroLine line : lines.toList()) {
                        IDictionary<MetroStation> stations = line.getStations();
                        if (stations.hasEntryWithId(id)) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasEntryWithName(String name) {
        if (super.hasEntryWithName(name)) {
            return true;
        } else {
            for (MetroCity city : toList()) {
                IDictionary<MetroLine> lines = city.getLines();
                if (lines.hasEntryWithName(name)) {
                    return true;
                } else {
                    for (MetroLine line : lines.toList()) {
                        IDictionary<MetroStation> stations = line.getStations();
                        if (stations.hasEntryWithName(name)) return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public MetroCity getEntryById(String id) throws DictionaryException {
        if (hasEntryWithId(id)) {
            if (super.hasEntryWithId(id)) {
                return super.getEntryById(id);
            } else {
                for (MetroCity city : toList()) {
                    IDictionary<MetroLine> lines = city.getLines();
                    if (lines.hasEntryWithId(id)) {
                        return lines.getEntryById(id);
                    } else {
                        for (MetroLine line : lines.toList()) {
                            IDictionary<MetroStation> stations = line.getStations();
                            if (stations.hasEntryWithId(id)) return stations.getEntryById(id);
                        }
                    }
                }
            }
        }
        throw new DictionaryException("� ������� �� ������� �������� �� ����� \"%s\".", id);
    }

    @Override
    public MetroCity getEntryByName(String name) throws DictionaryException {
        if (hasEntryWithName(name)) {
            if (super.hasEntryWithName(name)) {
                return super.getEntryByName(name);
            } else {
                for (MetroCity city : toList()) {
                    IDictionary<MetroLine> lines = city.getLines();
                    if (lines.hasEntryWithName(name)) {
                        return lines.getEntryByName(name);
                    } else {
                        for (MetroLine line : lines.toList()) {
                            IDictionary<MetroStation> stations = line.getStations();
                            if (stations.hasEntryWithName(name)) return stations.getEntryByName(name);
                        }
                    }
                }
            }
        }
        throw new DictionaryException("� ������� �� ������� �������� �� ����� \"%s\".", name);
    }
}