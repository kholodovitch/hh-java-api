package ru.yaal.project.hhapi.search;

import org.junit.Test;
import ru.yaal.project.hhapi.dictionary.entry.entries.vacancy.VacancySearchFields;
import ru.yaal.project.hhapi.search.parameter.Text;
import ru.yaal.project.hhapi.vacancy.IterableVacancyList;
import ru.yaal.project.hhapi.vacancy.Vacancy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IterableVacancySearchTest {
    @Test
    public void searchLimitLess500() throws Exception {
        final int vacanciesLimit = 60;
        ISearch<IterableVacancyList> search = new IterableVacancySearch(vacanciesLimit);
        final String nameText = "java";
        search.addParameter(new Text(nameText, VacancySearchFields.VACANCY_NAME));
        IterableVacancyList ivl = search.search();
        assertEquals(vacanciesLimit, ivl.size());
        for (Vacancy vacancy : ivl) {
            assertTrue(vacancy.getName().toUpperCase().contains(nameText.toUpperCase()));
        }
    }

    @Test
    public void searchLimitMore500() throws Exception {
        final int vacanciesLimit = 501;
        ISearch<IterableVacancyList> search = new IterableVacancySearch(vacanciesLimit);
        final String nameText = "java";
        search.addParameter(new Text(nameText, VacancySearchFields.VACANCY_NAME));
        IterableVacancyList ivl = search.search();
        assertEquals(vacanciesLimit, ivl.size());
        for (Vacancy vacancy : ivl) {
            assertTrue(vacancy.getName().toUpperCase().contains(nameText.toUpperCase()));
        }
    }
}