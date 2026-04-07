package br.com.apicontructor.controller.util.handler;

import br.com.apicontructor.controller.util.handler.enumerator.ProblemTypeEnum;
import br.com.apicontructor.controller.util.handler.model.FieldDetail;
import br.com.apicontructor.controller.util.handler.model.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String detail = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.";

        BindingResult bindingResult = ex.getBindingResult();

        List<FieldDetail> fields = bindingResult.getFieldErrors()
                                                .stream()
                                                .map(field -> FieldDetail.builder()
                                                        .name(field.getField())
                                                        .userMessage(messageSource.getMessage(field.getDefaultMessage(), null
                                                                , new Locale("pt", "BR")))
                                                        .build()).collect(Collectors.toList());

        Problem problem = createProblemBuilder(status.value(), ProblemTypeEnum.DADOS_INVALIDOS, detail, fields);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

            body = Problem.builder()
                    .timestamp(LocalDateTime.now())
                    .title(status.getReasonPhrase())
                    .status(status.value())
                    .build();


        return super.handleExceptionInternal(ex, body, headers, status, request);
    }

    private Problem createProblemBuilder(Integer statusCode,
                                         ProblemTypeEnum problemType, String detail, List<FieldDetail> fieldDetails) {

        return Problem.builder()
                .timestamp(LocalDateTime.now())
                .status(statusCode)
                .title(problemType.getTitle())
                .fields(fieldDetails)
                .build();
    }
}
