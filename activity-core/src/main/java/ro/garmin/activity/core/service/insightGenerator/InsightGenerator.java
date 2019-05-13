package ro.garmin.activity.core.service.insightGenerator;

import ro.garmin.activity.core.domain.Insight;

import java.util.List;

// interfata pentru declararea comportamentului generatoarelor de insighturi
public interface InsightGenerator {

    /**
     * genereaza o lista de insighturi generale
     */
    List<Insight> generateInsights();

}
