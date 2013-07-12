package ru.yaal.project.hhapi.parser;

import ru.yaal.project.hhapi.vacancy.Vacancy;

public class VacancyParser extends AbstractParser<Vacancy> {
    @Override
    public Vacancy parse(String content) {
        return gson.fromJson(content, Vacancy.class);
    }
}
