package ru.yaal.project.hhapi.vacancy;

import ru.yaal.project.hhapi.dictionary.Dictionary;
import ru.yaal.project.hhapi.dictionary.DictionaryException;
import ru.yaal.project.hhapi.search.SearchException;

import java.util.List;

public class IterableVacancyList extends Dictionary<Vacancy> {

    public IterableVacancyList(VacancyPage vacancyFullList) throws DictionaryException {
        super(vacancyFullList.getItems(), Vacancy.NULL_VACANCY);
    }

    public IterableVacancyList(List<Vacancy> vacancyFullCollection) throws DictionaryException {
        super(vacancyFullCollection, Vacancy.NULL_VACANCY);
    }

    public IterableVacancyList(PageableVacancyList pageableVacancyList) throws DictionaryException, SearchException {
        super(pageableVacancyList.toList().toList(), Vacancy.NULL_VACANCY);

    }

    @Override
    protected void putName(Vacancy entry) throws DictionaryException {
        //����� �������� �� ����� �� ��������������, �.�. ����� (��������) �������� �� ���������.
    }

    @Override
    public Vacancy getByName(String name) {
        throw new UnsupportedOperationException("����� �������� �� ����� �� ��������������, �.�. ����� (��������) �������� �� ���������.");
    }
}
