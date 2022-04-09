package ru.hh.school.dao;

import org.hibernate.SessionFactory;
import ru.hh.school.employers.StatisticsDto;
import ru.hh.school.entity.Area;

public class VacancyDao extends GenericDao{
  public VacancyDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  public StatisticsDto getSalaryStatistics(Area area){
    // ToDo дополните запрос, чтобы возвращался ru.hh.school.employers.StatisticsDto
    // https://vladmihalcea.com/the-best-way-to-map-a-projection-query-to-a-dto-with-jpa-and-hibernate/
    return getSession().createQuery(
        "SELECT new ru.hh.school.employers.StatisticsDto (count(vacancy.id), min(vacancy.compensationFrom), max(vacancy.compensationTo))" +
           "FROM Vacancy vacancy WHERE vacancy.area = :area", StatisticsDto.class)
        .setParameter("area", area)
        .getSingleResult();
  }
}
