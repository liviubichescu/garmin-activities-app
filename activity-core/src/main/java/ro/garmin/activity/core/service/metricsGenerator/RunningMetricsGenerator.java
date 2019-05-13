package ro.garmin.activity.core.service.metricsGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.garmin.activity.core.domain.Activity;
import ro.garmin.activity.core.domain.RunningMetrics;
import ro.garmin.activity.core.domain.enumsType.ActivityType;
import ro.garmin.activity.core.repository.MetricsRepository;
import ro.garmin.activity.core.repository.RunningRepository;

@Component
public class RunningMetricsGenerator implements MetricsGenerator {

    private final RunningRepository runningRepository;
    private final MetricsRepository runningMetrics;

    @Autowired
    public RunningMetricsGenerator(RunningRepository runningRepository, MetricsRepository runningMetrics) {
        this.runningRepository = runningRepository;
        this.runningMetrics = runningMetrics;
    }

    @Override
    public RunningMetrics generateMetrics() {

        return runningPaceMetrics();

    }

    // calculeaza si seteaza in db metrice pe baza listei de activitati.
    private RunningMetrics runningPaceMetrics() {
        RunningMetrics metrics = new RunningMetrics();
        // setez metric-ul pe tipul RUNNING -pt ca fac generare de statistici de running
        metrics.setActivityType(ActivityType.RUNNING);

        int count = (int) runningRepository.findAll()
                .stream()
                .filter(x -> x.getType().equals(ActivityType.RUNNING))
                .count();
        if (count==0){
            return metrics;
        }
        // setez in pe numarul de activitati de RUNNING gasite
        metrics.setActivitiesCount(count);

        // calculez distanta totala in metri a tuturor activitatilor de tip running(pentru calcularea pace-ului)
        double totalDistanceInMeters = runningRepository.findAll()
                .stream()
                .filter(x -> x.getType().equals(ActivityType.RUNNING))
                .mapToDouble(a->a.getDistance().getValue())
                .sum();

        // calculez timpul total in secunde a tuturor activitatilor de tip running(pentru calcularea pace-ului)
        double totalTimeInSeconds = runningRepository.findAll()
                .stream()
                .filter(x -> x.getType().equals(ActivityType.RUNNING))
                .map(Activity::getDuration)
                .reduce(Long::sum)
                .get();
        // setex pace-ul general al tuturor activitailor de tip running
        metrics.setAveragePace((totalTimeInSeconds/60) / (totalDistanceInMeters/1000));

        // sete speed tuturor activitailor de tip running
        metrics.setAverageSpeed(100);

        // salvez in db metricul generat
        runningMetrics.save(metrics);
        return metrics;
    }

}
