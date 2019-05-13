package ro.garmin.activity.core.service.insightGenerator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.garmin.activity.core.domain.Insight;
import ro.garmin.activity.core.domain.RunningActivity;
import ro.garmin.activity.core.domain.RunningMetrics;
import ro.garmin.activity.core.domain.enumsType.ActivityType;
import ro.garmin.activity.core.domain.enumsType.InsightsType;
import ro.garmin.activity.core.repository.InsightRepository;
import ro.garmin.activity.core.repository.MetricsRepository;
import ro.garmin.activity.core.repository.RunningRepository;

import java.util.Comparator;
import java.util.List;


// generator pentru insighturile bazate pe performanta
@Component
public class PerformanceInsightGenerator implements InsightGenerator {

    private static String OVER_AVERAGE_MSG = "Your last %s activity %s was %s. This is better than your average %s. Keep on going!";
    private static String BEST_PRFORMANCE_MSG = "YOooOOHOOooOO!!! For your last %s activity you scored the best %s until now!!! WELL DONE!";
    private final RunningRepository runningRepository;
    private final MetricsRepository runningMetricsRepository;
    private final InsightRepository insightRepository;

    @Autowired
    public PerformanceInsightGenerator(RunningRepository runningRepository, MetricsRepository runningMetricsRepository, InsightRepository insightRepository) {
        this.runningRepository = runningRepository;
        this.runningMetricsRepository = runningMetricsRepository;
        this.insightRepository = insightRepository;
    }

//    private List<Insight> insights = new LinkedList<>();

    @Override
    public List<Insight> generateInsights() {

        runningPaceInsights();

        return insightRepository.findAll();
    }

    /**
     * Adauga un nou insight bazat pe ultimei activitati.
     * Calculeaza pace-ul pentru si adauga insight daca pace-ul este mai mare decat toate de pana acum
     * sau daca pace-ul este peste media de pace
     */
    private void runningPaceInsights() {

        // aflam care este ultima activitate
        RunningActivity lastRunningActivity = getLatestActivity();

        // returnam primul metric generat
        RunningMetrics metrics = runningMetricsRepository.findAll()
                .stream()
                .filter(m -> m.getActivityType().equals(ActivityType.RUNNING))
                .findFirst()
                .orElse(null);

        if (metrics != null && lastRunningActivity.getPace() < metrics.getAveragePace()) {
            Insight insight = new Insight(String.format(OVER_AVERAGE_MSG, "running", "pace", lastRunningActivity.getPace(), "pace"));
            insight.setType(InsightsType.PERFORMANCE);
            insightRepository.save(insight);
        }

        // aflam cel mai mic pace pe care il are o activitate de running din db-ul nostru
        RunningActivity bestPaceActivity = this.runningRepository.findAll()
                .stream()
                .filter(s -> s.getType().equals(ActivityType.RUNNING))
                .min(Comparator.comparing(RunningActivity::getPace))
                .orElse(null);

        if (bestPaceActivity != null && lastRunningActivity.getPace() <= bestPaceActivity.getPace()) {
            Insight insight = new Insight(String.format(BEST_PRFORMANCE_MSG, "running", "pace"));
            insight.setType(InsightsType.PERFORMANCE);
            insightRepository.save(insight);
        }

    }

    // returneaza ultima activitate de un anumit tip
    private RunningActivity getLatestActivity() {
        return runningRepository.findAll()
                .stream()
                .filter(a->a.getType().equals(ActivityType.RUNNING))
//                .findAny()
                .max(Comparator.comparing(RunningActivity::getDateTime))
                .orElse(null);
    }


}
