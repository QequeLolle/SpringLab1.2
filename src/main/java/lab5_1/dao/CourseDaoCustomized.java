package lab5_1.dao;

import java.util.List;

public interface CourseDaoCustomized {

    double medianaLength();

    double averageLength();

//    static final record averageMediana(double average, double mediana) {}

    List<Double> getAverageAndMedianaLength();
}
