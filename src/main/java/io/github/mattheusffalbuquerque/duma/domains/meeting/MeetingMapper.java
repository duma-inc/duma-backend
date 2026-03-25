package io.github.mattheusffalbuquerque.duma.domains.meeting;

import java.util.List;
import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.CreateMeetingRequest;
import io.github.mattheusffalbuquerque.duma.domains.meeting.dto.MeetingResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MeetingMapper {

    public MeetingResponse toResponse(Meeting meeting);

    public Meeting toEntity(CreateMeetingRequest request);

    public List<MeetingResponse> toResponseList(List<Meeting> meetings);
    
} 