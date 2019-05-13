package ro.garmin.activity.web.converter;

import org.springframework.stereotype.Component;
import ro.garmin.activity.core.domain.Insight;
import ro.garmin.activity.web.dto.InsightDTO;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsightConverter extends BaseConverter<Insight, InsightDTO> {


    @Override
    public Insight convertDtoToModel(InsightDTO dto) {
        return new Insight(dto.getMessage());
    }

    @Override
    public InsightDTO convertModelToDto(Insight insight) {
        return new InsightDTO(insight.getMessage());
    }

    public List<InsightDTO> convertListModelToDto(List<Insight> insights) {
        List<InsightDTO> insightDTOS = new ArrayList<>();
        for (Insight insight: insights){
            InsightDTO insightDTO = new InsightDTO(insight.getMessage());
            insightDTOS.add(insightDTO);
        }
        return insightDTOS;
    }

}
