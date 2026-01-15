package com.jonah.planner;

import com.jonah.planner.domain.Note;
import com.jonah.planner.dto.NoteRequestDTO;
import com.jonah.planner.dto.NoteResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note toEntity(NoteRequestDTO noteRequestDTO);

    NoteResponseDTO toResponseDto(Note note);

    List<NoteResponseDTO> toResponseDtoList(List<Note> notes);
}
