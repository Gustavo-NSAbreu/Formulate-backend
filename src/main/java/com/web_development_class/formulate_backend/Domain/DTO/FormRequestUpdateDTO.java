package com.web_development_class.formulate_backend.Domain.DTO;

import java.util.Set;

public record FormRequestUpdateDTO(FormDTO form, Set<QuestionDTO> questions) {}
