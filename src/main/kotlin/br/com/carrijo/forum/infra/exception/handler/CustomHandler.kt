package br.com.carrijo.forum.infra.exception.handler

import br.com.carrijo.forum.infra.exception.NotFoundException
import br.com.carrijo.forum.infra.exception.details.Errors
import br.com.carrijo.forum.infra.exception.details.ExceptionDetails
import br.com.carrijo.forum.infra.exception.details.ExceptionSetDetails
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.client.HttpServerErrorException.InternalServerError
import java.util.*
import java.util.stream.Collectors

@RestControllerAdvice
class CustomHandler {

    @ExceptionHandler(NotFoundException::class)
    fun notFound(
        exception: NotFoundException,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionDetails> {
        val date = Date()
        val notFoundDetails = ExceptionDetails(
            title = "Recurso Não encontrado",
            status = HttpStatus.NOT_FOUND.value(),
            timestamp = date,
            path = request.servletPath,
            message = exception.message
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFoundDetails)
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(
        exception: MethodArgumentNotValidException,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionSetDetails> {
        val date = Date()
        val set = exception.bindingResult.fieldErrors.stream().map { e ->
            Errors(field = e.field, message = e.defaultMessage.toString())
        }.collect(Collectors.toCollection { LinkedHashSet<Errors>() })
        val violationDetails = ExceptionSetDetails(
            title = ("Campos necessários não preenchidos"),
            status = (HttpStatus.BAD_REQUEST.value()),
            timestamp = date,
            path = request.servletPath,
            errorSet = set
        )
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(violationDetails)
    }

    @ExceptionHandler(InternalServerError::class)
    fun handleInternalServerError(
        exception: InternalServerError,
        request: HttpServletRequest
    ): ResponseEntity<ExceptionDetails> {
        val date = Date()
        val internalErrorDetails = ExceptionDetails(
            title = "Erro Interno Servidor",
            status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
            timestamp = date,
            path = request.servletPath,
            message = exception.message
        )
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(internalErrorDetails)
    }

}