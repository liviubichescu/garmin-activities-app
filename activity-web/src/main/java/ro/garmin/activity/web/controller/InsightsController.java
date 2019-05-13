package ro.garmin.activity.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.garmin.activity.core.domain.Activity;
import ro.garmin.activity.core.domain.Insight;
import ro.garmin.activity.core.domain.RunningActivity;
import ro.garmin.activity.core.repository.InsightRepository;
import ro.garmin.activity.core.service.RunningActivityService;
import ro.garmin.activity.web.converter.InsightConverter;
import ro.garmin.activity.web.converter.RunningActivityConverter;
import ro.garmin.activity.web.dto.InsightDTO;
import ro.garmin.activity.web.dto.RunningActivityDTO;

import java.util.ArrayList;
import java.util.List;


@RestController
public class InsightsController {

    private final InsightRepository insightRepository;

    private final InsightConverter insightConverter;

    @Autowired
    public InsightsController(InsightRepository insightRepository, InsightConverter insightConverter) {
        this.insightRepository = insightRepository;
        this.insightConverter = insightConverter;
    }


    @RequestMapping(value = "/insights", method = RequestMethod.GET)
    List<InsightDTO> getInsights() {
        return insightConverter.convertListModelToDto(insightRepository.findAll());
    }

}
