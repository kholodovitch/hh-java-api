package ru.yaal.project.hhapi.dictionary.entry;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.Constants;
import ru.yaal.project.hhapi.dictionary.entry.entries.area.Area;
import ru.yaal.project.hhapi.dictionary.entry.entries.metro.MetroLine;
import ru.yaal.project.hhapi.dictionary.entry.entries.proffield.ProfField;

import static org.junit.Assert.assertEquals;

public class AbstractDictionaryEntryTest {
    @Test
    public void testToString() throws Exception {
        assertEquals("�������(male)", Constants.Gender.MALE.toString());
        assertEquals("������ ����(fullDay)", Constants.Schedule.FULL_DAY.toString());
        assertEquals("�����-���������(2)", Area.AREAS.getByName("�����-���������").toString());
        assertEquals("����������������, ����������(1.221)",
                ProfField.PROF_FIELDS.getById("1.221").toString());
        assertEquals("���������(5)", MetroLine.MOSCOW.getByName("���������").toString());
        assertEquals("������������(14.198)", MetroLine.SAINT_PETERSBURG.getByName("������������").toString());
    }
}
