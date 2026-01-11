package com.jonah.planner;

import com.jonah.planner.domain.Note;
import com.jonah.planner.dto.NoteDTO;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface NoteMapper {
    Note toEntity(NoteDTO noteDTO);

    NoteDTO toDto(Note note);
    List<NoteDTO> toDTOList(List<Note> notes);
}
