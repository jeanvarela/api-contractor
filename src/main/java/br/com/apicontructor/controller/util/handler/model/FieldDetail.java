package br.com.apicontructor.controller.util.handler.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FieldDetail {

    private String name;
    private String userMessage;
}
