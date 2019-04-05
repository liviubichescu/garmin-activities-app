package ro.garmin.activity.web.converter;


import ro.garmin.activity.core.domain.BaseEntity;
import ro.garmin.activity.web.dto.BaseDto;

public interface Converter<Model extends BaseEntity<Long>, Dto extends BaseDto> {

    Model convertDtoToModel(Dto dto);

    Dto convertModelToDto(Model model);
}
