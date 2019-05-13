package ro.garmin.activity.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.garmin.activity.core.domain.RunningMetrics;
import ro.garmin.activity.core.repository.MetricsRepository;
import ro.garmin.activity.core.service.metricsGenerator.MetricsGenerator;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MetricsService {

    private final List<MetricsGenerator> metricsGenerators;
    private final MetricsRepository metricsRepository;

    @Autowired
    public MetricsService(List<MetricsGenerator> metricsGenerators, MetricsRepository metricsRepository) {
        this.metricsGenerators = metricsGenerators;
        this.metricsRepository = metricsRepository;

//        initializeAllMetrics();
    }

//    @PostConstruct
    public void initializeAllMetrics() {
        metricsRepository.deleteAll();
        List<RunningMetrics> runningMetrics = metricsGenerators
                .stream()
                .map(MetricsGenerator::generateMetrics)
                .collect(Collectors.toList());

        metricsRepository.saveAll(runningMetrics);
//        System.out.println("MetricsService generated " + metrics.size() + " metrics");
//        metrics.stream().forEach(System.out::println);
    }

}
