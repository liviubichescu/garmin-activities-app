package ro.garmin.activity.core.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.garmin.activity.core.domain.Insight;
import ro.garmin.activity.core.repository.InsightRepository;
import ro.garmin.activity.core.repository.MetricsRepository;
import ro.garmin.activity.core.service.insightGenerator.InsightGenerator;
import ro.garmin.activity.core.service.insightGenerator.PerformanceInsightGenerator;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsightService {

    // o lista de generator de insighturi

    private final List<InsightGenerator> insightGenerator;

    private final InsightRepository insightRepository;

    @Autowired
    public InsightService(List<InsightGenerator> insightGenerator, InsightRepository insightRepository) {
        this.insightGenerator = insightGenerator;
        this.insightRepository = insightRepository;

//        initializeAllInsights();
    }

    // avem o lista de generatoare de insighturi(gen generator pentru insighturi de tip running, swiming)
    // o parcurgem si pentru fiecare apelam metoda generateInsight() ca sa ne genereze insighturi
//    @PostConstruct
    public void initializeAllInsights() {
        insightRepository.deleteAll();
//        PerformanceInsightGenerator performanceInsightGenerator = new PerformanceInsightGenerator();

//        insightGenerator.add(new PerformanceInsightGenerator());

        List<Insight> insights = insightGenerator
                .stream()
                .map(insight-> insight.generateInsights())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        insightRepository.saveAll(insights);

//        System.out.println("InsightService generated " + insights.size()+ " insight");
//        insights.forEach(System.out::println);

    }


}
