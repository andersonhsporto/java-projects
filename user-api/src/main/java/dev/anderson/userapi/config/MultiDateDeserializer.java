package dev.anderson.userapi.config;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.stream.Collectors;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MultiDateDeserializer extends StdDeserializer<LocalDate> {

  private static final long serialVersionUID = 1L;

  private static final DateTimeFormatter[] DATE_FORMATTERS =
      new DateTimeFormatter[] {
          DateTimeFormatter.ofPattern("dd-MM-yyyy"),
          DateTimeFormatter.ofPattern("dd/MM/yyyy"),
          DateTimeFormatter.ISO_OFFSET_DATE_TIME
          };

  public MultiDateDeserializer() {
    this(null);
  }

  public MultiDateDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt)
      throws IOException, JacksonException {
    JsonNode node = jp.getCodec().readTree(jp);
    final String date = node.textValue();

    for (var formatter : DATE_FORMATTERS) {
      try {
        return LocalDate.parse(date, formatter);
      } catch (DateTimeParseException e) {
      }
    }
    throw new JsonParseException(jp,
        "Unparseable date: \"" + date + "\". Supported formats: " + Arrays.stream(DATE_FORMATTERS)
            .map(DateTimeFormatter::toString).collect(Collectors.joining("; ")));
  }
}


